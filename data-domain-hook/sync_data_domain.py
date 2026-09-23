#!/usr/bin/env python3
"""pre-commit hook: push the $id's governed by each staged data-domain.json to DMR.

For every staged data-domain.json:
  1. read its "domainName"
  2. collect "$id" from every *.json file in its directory tree
  3. POST {"domainName": ..., "ids": [...]} to $DMR_SERVER/domain/update
"""
from __future__ import annotations

import json
import os
import sys
import urllib.request
from dataclasses import dataclass
from pathlib import Path
from typing import Iterator, Sequence

DOMAIN_FILE = "data-domain.json"


@dataclass(frozen=True)
class DomainUpdate:
    domain_name: str
    ids: tuple[str, ...]

    @classmethod
    def from_domain_file(cls, domain_file: Path) -> "DomainUpdate":
        name = json.loads(domain_file.read_text(encoding="utf-8"))["domainName"]
        return cls(name, tuple(sorted(set(collect_ids(domain_file.parent)))))

    def payload(self) -> bytes:
        return json.dumps({"domainName": self.domain_name, "ids": list(self.ids)}).encode()


def json_files(root: Path) -> Iterator[Path]:
    return (p for p in root.rglob("*.json") if p.name != DOMAIN_FILE)


def read_id(path: Path) -> str | None:
    data = json.loads(path.read_text(encoding="utf-8"))
    return data.get("$id") if isinstance(data, dict) else None


def collect_ids(root: Path) -> Iterator[str]:
    return (i for i in map(read_id, json_files(root)) if i)


@dataclass(frozen=True)
class DmrClient:
    base_url: str
    timeout: float = 30.0

    @classmethod
    def from_env(cls) -> "DmrClient":
        url = os.environ.get("DMR_SERVER")
        if not url:
            raise SystemExit("DMR_SERVER is not set")
        return cls(url.rstrip("/"))

    def update(self, update: DomainUpdate) -> int:
        req = urllib.request.Request(
            f"{self.base_url}/domain/update",
            data=update.payload(),
            headers={"Content-Type": "application/json"},
            method="POST",
        )
        with urllib.request.urlopen(req, timeout=self.timeout) as resp:
            return resp.status


def main(argv: Sequence[str] | None = None) -> int:
    domain_files = [Path(p) for p in (argv if argv is not None else sys.argv[1:])
                    if Path(p).name == DOMAIN_FILE]
    if not domain_files:
        return 0
    client = DmrClient.from_env()
    try:
        updates = [DomainUpdate.from_domain_file(f) for f in domain_files]
        for u in updates:
            status = client.update(u)
            print(f"DMR: domain '{u.domain_name}' updated with {len(u.ids)} ids (HTTP {status})")
    except (json.JSONDecodeError, KeyError, OSError) as exc:  # URLError is an OSError
        print(f"data-domain sync failed: {exc!r}", file=sys.stderr)
        return 1
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
