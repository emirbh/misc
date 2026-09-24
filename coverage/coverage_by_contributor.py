#!/usr/bin/env python3
"""Per-contributor unit & integration test coverage report.

Joins coverage reports with `git blame`. Every executable line is attributed
to the contributor who last touched it, and the report shows how much of each
contributor's code is exercised by unit tests, integration tests, and both
combined. Python (coverage.py JSON) and Go (cover profiles) are detected
automatically.

Produce the inputs first (from the repo root).

Python:
    pytest tests/unit        --cov=src --cov-report=json:coverage-unit.json
    pytest tests/integration --cov=src --cov-report=json:coverage-integration.json

Go (integration tests behind a build tag, e.g. `//go:build integration`):
    go test -coverpkg=./... -coverprofile=coverage-unit.out ./...
    go test -tags=integration -run Integration -coverpkg=./... \
        -coverprofile=coverage-integration.out ./...

Go, integration/e2e against a running binary (Go 1.20+):
    go build -cover -coverpkg=./... -o app ./cmd/app
    GOCOVERDIR=covdata ./app &   # run the suite against it, then stop it
    go tool covdata textfmt -i=covdata -o coverage-integration.out

Then:

    python coverage_by_contributor.py \
        --unit coverage-unit.json --integration coverage-integration.json \
        [--repo .] [--since 2026-01-01] [--path src/] [--csv out.csv]
"""
from __future__ import annotations

import argparse
import csv
import json
import subprocess
import sys
from collections.abc import Iterable, Iterator, Mapping
from dataclasses import dataclass, fields
from datetime import date, datetime, timezone
from functools import reduce
from pathlib import Path


# ---------------------------------------------------------------- data model

@dataclass(frozen=True)
class FileCoverage:
    """Executable and executed line numbers for one source file."""

    statements: frozenset[int]
    executed: frozenset[int]

    @classmethod
    def from_json(cls, data: Mapping) -> "FileCoverage":
        executed = frozenset(data.get("executed_lines", ()))
        missing = frozenset(data.get("missing_lines", ()))
        return cls(statements=executed | missing, executed=executed)


EMPTY = FileCoverage(frozenset(), frozenset())


class CoverageReport:
    """A coverage report (coverage.py JSON or Go cover profile), keyed by repo-relative path."""

    def __init__(self, files: Mapping[str, FileCoverage]):
        self._files = dict(files)

    @classmethod
    def load(cls, report: Path | None, repo: Path) -> "CoverageReport":
        if report is None:
            return cls({})
        text = report.read_text()
        if text.lstrip().startswith("mode:"):
            return cls(GoProfile(repo).parse(text))
        raw = json.loads(text)["files"]
        return cls({_relative(p, repo): FileCoverage.from_json(d) for p, d in raw.items()})

    @property
    def paths(self) -> frozenset[str]:
        return frozenset(self._files)

    def __getitem__(self, path: str) -> FileCoverage:
        return self._files.get(path, EMPTY)


def _relative(path: str, repo: Path) -> str:
    p = Path(path)
    return (p.resolve().relative_to(repo) if p.is_absolute() else p).as_posix()


# ---------------------------------------------------------------- go support

@dataclass(frozen=True)
class GoBlock:
    """One line of a Go cover profile: file.go:L1.C1,L2.C2 numStmts count."""

    file: str
    start: int
    end: int
    statements: int
    count: int

    @classmethod
    def parse(cls, line: str) -> "GoBlock":
        location, n_stmts, count = line.rsplit(" ", 2)
        file, _, span = location.rpartition(":")
        begin, _, finish = span.partition(",")
        return cls(file, int(begin.split(".")[0]), int(finish.split(".")[0]), int(n_stmts), int(count))

    @property
    def lines(self) -> range:
        return range(self.start, self.end + 1)


_NON_CODE = {"", "{", "}", ")", "})", "},"}


class GoProfile:
    """Turns a Go cover profile into line-level FileCoverage.

    Go reports coverage per block, not per line, so each source line inside a
    block is counted, except blank lines, comments and lone braces. A line is
    covered if any block containing it ran (this also merges the duplicate
    blocks `-coverpkg` produces).
    """

    def __init__(self, repo: Path):
        self.repo = repo
        self.modules = self._find_modules(repo)

    @staticmethod
    def _find_modules(repo: Path) -> dict[str, str]:
        def module_name(gomod: Path) -> str | None:
            return next((ln.split()[1] for ln in gomod.read_text().splitlines()
                         if ln.startswith("module ")), None)
        found = ((module_name(g), g.parent.relative_to(repo).as_posix())
                 for g in repo.rglob("go.mod") if "vendor" not in g.parts)
        return {name: "" if d == "." else d for name, d in found if name}

    def repo_path(self, import_path: str) -> str:
        """github.com/acme/svc/pkg/x.go -> pkg/x.go (longest matching module wins)."""
        if Path(import_path).is_absolute():
            return _relative(import_path, self.repo)
        match = max((m for m in self.modules if import_path.startswith(m + "/")), key=len, default=None)
        if match is None:
            return import_path
        rest = import_path[len(match) + 1:]
        return f"{self.modules[match]}/{rest}" if self.modules[match] else rest

    def _code_lines(self, path: str) -> frozenset[int]:
        source = self.repo / path
        if not source.exists():
            return frozenset()
        return frozenset(
            n for n, text in enumerate(source.read_text().splitlines(), 1)
            if text.strip() not in _NON_CODE and not text.strip().startswith("//")
        )

    def parse(self, text: str) -> dict[str, FileCoverage]:
        blocks = [GoBlock.parse(ln) for ln in text.splitlines()[1:] if ln.strip()]
        by_file: dict[str, list[GoBlock]] = {}
        for b in (b for b in blocks if b.statements):
            by_file.setdefault(self.repo_path(b.file), []).append(b)

        def to_coverage(path: str, file_blocks: list[GoBlock]) -> FileCoverage:
            code = self._code_lines(path)
            lines = lambda bs: frozenset(n for b in bs for n in b.lines) & code
            return FileCoverage(statements=lines(file_blocks),
                                executed=lines(b for b in file_blocks if b.count > 0))

        return {p: to_coverage(p, bs) for p, bs in by_file.items()}


@dataclass(frozen=True)
class BlameLine:
    line: int
    author: str
    email: str
    time: datetime


@dataclass(frozen=True)
class Tally:
    statements: int = 0
    unit: int = 0
    integration: int = 0
    combined: int = 0

    def __add__(self, other: "Tally") -> "Tally":
        return Tally(*(getattr(self, f.name) + getattr(other, f.name) for f in fields(self)))

    @staticmethod
    def pct(part: int, whole: int) -> str:
        return f"{100 * part / whole:.1f}%" if whole else "n/a"

    def row(self, name: str) -> dict[str, str | int]:
        return {
            "Contributor": name,
            "Statements": self.statements,
            "Unit": self.pct(self.unit, self.statements),
            "Integration": self.pct(self.integration, self.statements),
            "Combined": self.pct(self.combined, self.statements),
            "Uncovered": self.statements - self.combined,
        }


# ---------------------------------------------------------------- git blame

class GitBlame:
    """Callable returning {line_number: BlameLine} for a file."""

    def __init__(self, repo: Path):
        self.repo = repo

    def __call__(self, path: str) -> dict[int, BlameLine]:
        result = subprocess.run(
            ["git", "-C", str(self.repo), "blame", "-w", "--line-porcelain", "--", path],
            capture_output=True, text=True,
        )
        if result.returncode != 0:
            print(f"warning: skipping {path}: {result.stderr.strip()}", file=sys.stderr)
            return {}
        return {b.line: b for b in parse_porcelain(result.stdout)}


def parse_porcelain(text: str) -> Iterator[BlameLine]:
    meta: dict[str, str] = {}
    line_no, expecting_header = 0, True
    for raw in text.splitlines():
        if raw.startswith("\t"):
            yield BlameLine(
                line=line_no,
                author=meta.get("author", "unknown"),
                email=meta.get("author-mail", "").strip("<>").lower(),
                time=datetime.fromtimestamp(int(meta.get("author-time", 0)), tz=timezone.utc),
            )
            meta, expecting_header = {}, True
        elif expecting_header:
            line_no, expecting_header = int(raw.split()[2]), False
        else:
            key, _, value = raw.partition(" ")
            meta[key] = value


# ---------------------------------------------------------------- pipeline

def line_tallies(
    path: str, unit: CoverageReport, integ: CoverageReport, blame: GitBlame, since: datetime | None
) -> Iterator[tuple[str, str, Tally]]:
    """Yield (email, author, Tally) for each executable line in one file."""
    u, i = unit[path], integ[path]
    blamed = blame(path)
    for n in sorted(u.statements | i.statements):
        b = blamed.get(n)
        if b is None or (since and b.time < since):
            continue
        in_u, in_i = n in u.executed, n in i.executed
        yield b.email or b.author, b.author, Tally(1, int(in_u), int(in_i), int(in_u or in_i))


def aggregate(records: Iterable[tuple[str, str, Tally]]) -> dict[str, tuple[str, Tally]]:
    def step(acc: dict[str, tuple[str, Tally]], rec: tuple[str, str, Tally]):
        key, name, tally = rec
        _, prev = acc.get(key, (name, Tally()))
        return {**acc, key: (name, prev + tally)}
    return reduce(step, records, {})


def build_rows(totals: Mapping[str, tuple[str, Tally]]) -> list[dict[str, str | int]]:
    ranked = sorted(totals.values(), key=lambda nt: nt[1].statements, reverse=True)
    grand = reduce(lambda a, nt: a + nt[1], ranked, Tally())
    return [t.row(n) for n, t in ranked] + [grand.row("TOTAL")]


def to_markdown(rows: list[dict[str, str | int]]) -> str:
    if not rows:
        return "No covered source files found."
    headers = list(rows[0])
    widths = {h: max(len(h), *(len(str(r[h])) for r in rows)) for h in headers}
    fmt = lambda vals: "| " + " | ".join(str(v).ljust(widths[h]) for h, v in zip(headers, vals)) + " |"
    return "\n".join([
        fmt(headers),
        "|" + "|".join("-" * (widths[h] + 2) for h in headers) + "|",
        *(fmt(r.values()) for r in rows),
    ])


# ---------------------------------------------------------------- cli

def main(argv: list[str] | None = None) -> int:
    ap = argparse.ArgumentParser(description=__doc__, formatter_class=argparse.RawDescriptionHelpFormatter)
    ap.add_argument("--unit", type=Path, help="coverage file from the unit test run (coverage.py JSON or Go profile)")
    ap.add_argument("--integration", type=Path, help="coverage file from the integration test run (coverage.py JSON or Go profile)")
    ap.add_argument("--repo", type=Path, default=Path("."), help="git repo root (default: .)")
    ap.add_argument("--since", type=date.fromisoformat, help="only count lines last changed on/after YYYY-MM-DD")
    ap.add_argument("--path", action="append", default=[], help="only files under this prefix (repeatable)")
    ap.add_argument("--csv", type=Path, help="also write the table to this CSV file")
    args = ap.parse_args(argv)

    if not (args.unit or args.integration):
        ap.error("give at least one of --unit / --integration")

    repo = args.repo.resolve()
    unit = CoverageReport.load(args.unit, repo)
    integ = CoverageReport.load(args.integration, repo)
    since = datetime.combine(args.since, datetime.min.time(), timezone.utc) if args.since else None
    blame = GitBlame(repo)

    paths = sorted(p for p in unit.paths | integ.paths
                   if not args.path or any(p.startswith(pre) for pre in args.path))
    records = (rec for p in paths for rec in line_tallies(p, unit, integ, blame, since))
    rows = build_rows(aggregate(records))

    print(to_markdown(rows))
    if args.csv and rows:
        with args.csv.open("w", newline="") as fh:
            writer = csv.DictWriter(fh, fieldnames=list(rows[0]))
            writer.writeheader()
            writer.writerows(rows)
    return 0


if __name__ == "__main__":
    sys.exit(main())
