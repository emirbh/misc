"""pytest suite for scripts/sync_data_domain.py.

Run:  pytest tests -v
"""
from __future__ import annotations

import importlib.util
import json
import shutil
import subprocess
import sys
import threading
from http.server import BaseHTTPRequestHandler, HTTPServer
from pathlib import Path

import pytest

SCRIPT = Path(__file__).resolve().parents[1] / "scripts" / "sync_data_domain.py"


# --------------------------------------------------------------------------- fixtures
@pytest.fixture(scope="session")
def sdd():
    """The hook module, imported from scripts/."""
    spec = importlib.util.spec_from_file_location("sync_data_domain", SCRIPT)
    module = importlib.util.module_from_spec(spec)
    sys.modules[spec.name] = module  # dataclasses need the module registered
    spec.loader.exec_module(module)
    return module


def write_json(path: Path, data) -> Path:
    path.parent.mkdir(parents=True, exist_ok=True)
    path.write_text(data if isinstance(data, str) else json.dumps(data), encoding="utf-8")
    return path


@pytest.fixture
def workdir(tmp_path, monkeypatch) -> Path:
    """Fresh cwd per test, DMR_SERVER cleared."""
    monkeypatch.chdir(tmp_path)
    monkeypatch.delenv("DMR_SERVER", raising=False)
    return tmp_path


@pytest.fixture
def sales_domain(workdir) -> Path:
    """sales/ domain with nested files, a file without $id, non-object JSON, and an outsider."""
    write_json(workdir / "sales/trade.json", {"$id": "urn:trade"})
    write_json(workdir / "sales/eu/fr/position.json", {"$id": "urn:position"})
    write_json(workdir / "sales/eu/no_id.json", {"name": "x"})
    write_json(workdir / "sales/eu/list.json", [1, 2, 3])
    write_json(workdir / "sales/readme.txt", "not json")
    write_json(workdir / "other/outside.json", {"$id": "urn:outside"})
    return write_json(workdir / "sales/data-domain.json", {"domainName": "Sales"})


class FakeDmrServer:
    """Local HTTP server recording every request; `status` controls the reply."""

    def __init__(self):
        self.requests: list[tuple[str, dict]] = []
        self.status = 200
        outer = self

        class Handler(BaseHTTPRequestHandler):
            def do_POST(self):
                body = self.rfile.read(int(self.headers["Content-Length"]))
                outer.requests.append((self.path, json.loads(body)))
                self.send_response(outer.status)
                self.end_headers()

            def log_message(self, *_):
                pass

        self._httpd = HTTPServer(("127.0.0.1", 0), Handler)
        self.url = f"http://127.0.0.1:{self._httpd.server_port}"

    @property
    def bodies(self) -> list[dict]:
        return [body for _, body in self.requests]

    def start(self):
        threading.Thread(target=self._httpd.serve_forever, daemon=True).start()

    def stop(self):
        self._httpd.shutdown()
        self._httpd.server_close()


@pytest.fixture
def dmr(monkeypatch, workdir):
    """Running fake DMR server with DMR_SERVER pointing at it."""
    server = FakeDmrServer()
    server.start()
    monkeypatch.setenv("DMR_SERVER", server.url)
    yield server
    server.stop()


# --------------------------------------------------------------------------- collect_ids
def test_collects_ids_recursively_and_skips_non_matching(sdd, sales_domain):
    assert sorted(sdd.collect_ids(sales_domain.parent)) == ["urn:position", "urn:trade"]


def test_domain_file_itself_is_not_scanned(sdd, workdir):
    write_json(workdir / "d/data-domain.json", {"domainName": "D", "$id": "urn:domain"})
    assert list(sdd.collect_ids(workdir / "d")) == []


def test_invalid_json_raises(sdd, workdir):
    write_json(workdir / "d/bad.json", "{broken")
    with pytest.raises(json.JSONDecodeError):
        list(sdd.collect_ids(workdir / "d"))


@pytest.mark.parametrize(
    "content, expected",
    [
        ({"$id": "urn:a"}, "urn:a"),
        ({"other": 1}, None),
        ([{"$id": "urn:in-list"}], None),
        ("\"just a string\"", None),
    ],
)
def test_read_id(sdd, workdir, content, expected):
    assert sdd.read_id(write_json(workdir / "f.json", content)) == expected


# --------------------------------------------------------------------------- DomainUpdate
def test_from_domain_file_dedupes_and_sorts(sdd, sales_domain):
    write_json(sales_domain.parent / "dup.json", {"$id": "urn:trade"})
    assert sdd.DomainUpdate.from_domain_file(sales_domain) == sdd.DomainUpdate(
        "Sales", ("urn:position", "urn:trade")
    )


def test_payload_shape(sdd):
    payload = json.loads(sdd.DomainUpdate("Sales", ("a", "b")).payload())
    assert payload == {"domainName": "Sales", "ids": ["a", "b"]}


def test_missing_domain_name_raises(sdd, workdir):
    domain = write_json(workdir / "d/data-domain.json", {"name": "oops"})
    with pytest.raises(KeyError):
        sdd.DomainUpdate.from_domain_file(domain)


# --------------------------------------------------------------------------- main()
def test_no_domain_file_in_commit_is_noop(sdd, workdir):
    write_json(workdir / "x.json", {"$id": "urn:x"})
    assert sdd.main(["x.json"]) == 0  # DMR_SERVER not even required


def test_posts_update_for_staged_domain_file(sdd, sales_domain, dmr, capsys):
    assert sdd.main([str(sales_domain), "sales/trade.json"]) == 0
    assert dmr.requests == [
        ("/domain/update", {"domainName": "Sales", "ids": ["urn:position", "urn:trade"]})
    ]
    assert "'Sales' updated with 2 ids" in capsys.readouterr().out


def test_one_call_per_domain_file(sdd, workdir, dmr, monkeypatch):
    monkeypatch.setenv("DMR_SERVER", dmr.url + "/")  # trailing slash tolerated
    a = write_json(workdir / "a/data-domain.json", {"domainName": "A"})
    b = write_json(workdir / "b/data-domain.json", {"domainName": "B"})
    write_json(workdir / "a/x.json", {"$id": "urn:a"})
    write_json(workdir / "b/y.json", {"$id": "urn:b"})

    assert sdd.main([str(a), str(b)]) == 0
    assert dmr.bodies == [
        {"domainName": "A", "ids": ["urn:a"]},
        {"domainName": "B", "ids": ["urn:b"]},
    ]


def test_nothing_sent_if_any_domain_is_invalid(sdd, workdir, dmr, capsys):
    good = write_json(workdir / "a/data-domain.json", {"domainName": "A"})
    bad = write_json(workdir / "b/data-domain.json", {"noName": True})

    assert sdd.main([str(good), str(bad)]) == 1
    assert dmr.requests == []
    assert "domainName" in capsys.readouterr().err


def test_missing_dmr_server_fails(sdd, sales_domain):
    with pytest.raises(SystemExit, match="DMR_SERVER"):
        sdd.main([str(sales_domain)])


@pytest.mark.parametrize("status", [400, 404, 500, 503])
def test_server_error_blocks_commit(sdd, sales_domain, dmr, capsys, status):
    dmr.status = status
    assert sdd.main([str(sales_domain)]) == 1
    assert str(status) in capsys.readouterr().err


def test_server_unreachable_blocks_commit(sdd, sales_domain, monkeypatch):
    monkeypatch.setenv("DMR_SERVER", "http://127.0.0.1:9")
    assert sdd.main([str(sales_domain)]) == 1


# --------------------------------------------------------------------------- end-to-end: git + pre-commit
PRE_COMMIT_CONFIG = """\
fail_fast: true
repos:
  - repo: local
    hooks:
      - id: sync-data-domain
        name: upsert data-domain ids to DMR
        entry: {python} scripts/sync_data_domain.py
        language: system
        files: (^|/)data-domain\\.json$
"""

needs_pre_commit = pytest.mark.skipif(
    not (shutil.which("pre-commit") and shutil.which("git")),
    reason="pre-commit/git not installed",
)


@pytest.fixture
def repo(workdir):
    """Git repo with the hook installed through pre-commit; returns a commit() helper."""
    def git(*args, **kw):
        return subprocess.run(["git", *args], capture_output=True, text=True, **kw)

    git("init", "-q")
    git("config", "user.email", "test@example.com")
    git("config", "user.name", "test")
    (workdir / "scripts").mkdir()
    shutil.copy(SCRIPT, workdir / "scripts/sync_data_domain.py")
    (workdir / ".pre-commit-config.yaml").write_text(PRE_COMMIT_CONFIG.format(python=sys.executable))
    subprocess.run(["pre-commit", "install"], check=True, capture_output=True)
    git("add", "-A")
    git("commit", "-qm", "setup")

    def commit():
        git("add", "-A")
        return git("commit", "-m", "change")

    return commit


@needs_pre_commit
def test_e2e_commit_with_domain_file_calls_server(repo, sales_domain, dmr):
    result = repo()
    assert result.returncode == 0, result.stdout + result.stderr
    assert dmr.bodies[0]["domainName"] == "Sales"


@needs_pre_commit
def test_e2e_commit_without_domain_file_skips_hook(repo, workdir):
    write_json(workdir / "x.json", {"$id": "urn:x"})
    result = repo()  # DMR_SERVER unset: would fail if the hook ran
    assert result.returncode == 0, result.stdout + result.stderr


@needs_pre_commit
def test_e2e_commit_blocked_when_server_down(repo, sales_domain, monkeypatch):
    monkeypatch.setenv("DMR_SERVER", "http://127.0.0.1:9")
    assert repo().returncode != 0
