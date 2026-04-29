import requests
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText
from email.mime.base import MIMEBase
from email import encoders
from bs4 import BeautifulSoup
from urllib.parse import urljoin, urlparse
from dataclasses import dataclass, field
from typing import Optional
import mimetypes


@dataclass
class MHTMLResource:
    url: str
    content: bytes
    content_type: str
    is_page: bool = False


class MHTMLArchiver:
    RESOURCE_TAGS = [("img", "src"), ("link", "href"), ("script", "src"),
                     ("video", "src"), ("audio", "src"), ("source", "src")]

    def __init__(self, max_depth: int = 2, same_domain_only: bool = True,
                 timeout: int = 10, max_pages: int = 50):
        self.max_depth = max_depth
        self.same_domain_only = same_domain_only
        self.timeout = timeout
        self.max_pages = max_pages
        self.session = requests.Session()
        self.session.headers.update({
            "User-Agent": "Mozilla/5.0 (compatible; MHTMLArchiver/1.0)"
        })
        self.visited: set[str] = set()
        self.resources: dict[str, MHTMLResource] = {}

    def _normalize_url(self, url: str) -> str:
        parsed = urlparse(url)
        return parsed._replace(fragment="").geturl()

    def _is_same_domain(self, url: str, base_url: str) -> bool:
        return urlparse(url).netloc == urlparse(base_url).netloc

    def _is_page_link(self, url: str) -> bool:
        path = urlparse(url).path.lower()
        non_page_exts = {'.css', '.js', '.png', '.jpg', '.jpeg', '.gif',
                         '.svg', '.ico', '.woff', '.woff2', '.ttf', '.eot',
                         '.mp4', '.mp3', '.pdf', '.zip', '.webp'}
        return not any(path.endswith(ext) for ext in non_page_exts)

    def _fetch(self, url: str) -> Optional[requests.Response]:
        try:
            resp = self.session.get(url, timeout=self.timeout)
            resp.raise_for_status()
            return resp
        except Exception as e:
            print(f"  [skip] {url}: {e}")
            return None

    def _collect_resources(self, soup: BeautifulSoup, page_url: str):
        """Fetch and store static resources (images, CSS, JS, etc.)."""
        for tag, attr in self.RESOURCE_TAGS:
            for el in soup.find_all(tag):
                src = el.get(attr)
                if not src:
                    continue
                abs_url = self._normalize_url(urljoin(page_url, src))
                if abs_url in self.resources:
                    continue
                resp = self._fetch(abs_url)
                if resp is None:
                    continue
                content_type = resp.headers.get("Content-Type", "").split(";")[0]
                if not content_type:
                    content_type = mimetypes.guess_type(abs_url)[0] or "application/octet-stream"
                self.resources[abs_url] = MHTMLResource(
                    url=abs_url, content=resp.content,
                    content_type=content_type
                )

        # Also grab CSS background images / @import via inline style tags
        for style in soup.find_all("style"):
            self._extract_css_urls(style.string or "", page_url)

    def _extract_css_urls(self, css_text: str, base_url: str):
        """Naive extraction of url(...) references from CSS."""
        import re
        for match in re.finditer(r'url\(["\']?(.*?)["\']?\)', css_text):
            ref = match.group(1)
            if ref.startswith("data:"):
                continue
            abs_url = self._normalize_url(urljoin(base_url, ref))
            if abs_url not in self.resources:
                resp = self._fetch(abs_url)
                if resp:
                    ct = resp.headers.get("Content-Type", "").split(";")[0] or "application/octet-stream"
                    self.resources[abs_url] = MHTMLResource(
                        url=abs_url, content=resp.content, content_type=ct
                    )

    def _crawl(self, url: str, base_url: str, depth: int):
        """Recursively crawl pages and collect everything."""
        url = self._normalize_url(url)
        if url in self.visited or len(self.visited) >= self.max_pages:
            return
        if self.same_domain_only and not self._is_same_domain(url, base_url):
            return

        self.visited.add(url)
        print(f"[depth={depth}] Crawling: {url}")

        resp = self._fetch(url)
        if resp is None:
            return

        content_type = resp.headers.get("Content-Type", "")
        if "text/html" not in content_type:
            return

        soup = BeautifulSoup(resp.text, "html.parser")

        # Store this page as a resource
        self.resources[url] = MHTMLResource(
            url=url, content=resp.content,
            content_type="text/html", is_page=True
        )

        # Collect static assets
        self._collect_resources(soup, url)

        # Recurse into linked pages
        if depth < self.max_depth:
            for a_tag in soup.find_all("a", href=True):
                link = self._normalize_url(urljoin(url, a_tag["href"]))
                if self._is_page_link(link) and link not in self.visited:
                    self._crawl(link, base_url, depth + 1)

    def _build_mhtml(self, root_url: str, title: str) -> str:
        msg = MIMEMultipart("related", type="text/html")
        msg["Subject"] = title
        msg["Content-Location"] = root_url
        msg["MIME-Version"] = "1.0"

        # Root page first
        root = self.resources.pop(root_url, None)
        if root:
            html_part = MIMEText(root.content.decode("utf-8", errors="replace"), "html", "utf-8")
            html_part.add_header("Content-Location", root_url)
            msg.attach(html_part)

        # Then all other resources (pages + assets)
        for url, res in self.resources.items():
            maintype, _, subtype = res.content_type.partition("/")
            if res.is_page:
                part = MIMEText(res.content.decode("utf-8", errors="replace"), "html", "utf-8")
            else:
                part = MIMEBase(maintype or "application", subtype or "octet-stream")
                part.set_payload(res.content)
                encoders.encode_base64(part)
            part.add_header("Content-Location", url)
            msg.attach(part)

        return msg.as_string()

    def save(self, url: str, output_path: str, depth: Optional[int] = None):
        if depth is not None:
            self.max_depth = depth

        self._crawl(url, url, depth=0)

        # Determine title from root page
        root = self.resources.get(self._normalize_url(url))
        title = url
        if root:
            soup = BeautifulSoup(root.content, "html.parser")
            if soup.title and soup.title.string:
                title = soup.title.string.strip()

        mhtml_content = self._build_mhtml(self._normalize_url(url), title)

        with open(output_path, "w", encoding="utf-8") as f:
            f.write(mhtml_content)

        print(f"\nSaved {len(self.resources) + 1} resources to {output_path}")
        print(f"  Pages crawled: {len(self.visited)}")


# Usage
archiver = MHTMLArchiver(
    max_depth=2,          # how deep to follow links
    same_domain_only=True,  # stay on same domain
    max_pages=50,         # cap on total pages
    timeout=10
)
archiver.save("https://example.com", "output.mhtml")
