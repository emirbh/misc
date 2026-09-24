#!/usr/bin/env python3
"""Test coverage per contributor: unit + integration tests in one report.

Run from the root of a git repo, no arguments:

    python coverage_by_contributor.py

It runs the whole test suite once with coverage switched on (unit and
integration tests together), uses `git blame` to credit every executable line
to whoever last changed it, and prints one table: how much of each person's
code the tests run. The table is also saved as coverage_by_contributor.csv.

    Go repo (has go.mod):  go test -tags=integration -coverpkg=./... ./...
    Python repo:           python -m pytest --cov=.

Integration tests in Go are usually behind a build tag; set GO_TAGS below if
yours use a different one. Test files themselves are not counted.
"""
from __future__ import annotations

import csv
import json
import re
import subprocess
import sys
import tempfile
from collections.abc import Iterable, Iterator, Mapping
from dataclasses import dataclass
from functools import reduce
from pathlib import Path

# ---------------------------------------------------------------- settings

REPO = Path.cwd().resolve()
GO_TAGS = "integration"                 # build tag(s) that switch on integration tests
OUTPUT_CSV = REPO / "coverage_by_contributor.csv"
PY_TEST_FILE = re.compile(r"(^|/)(tests?/|test_[^/]*\.py$|[^/]*_test\.py$|conftest\.py$)")


# ---------------------------------------------------------------- data model

@dataclass(frozen=True)
class FileCoverage:
    """Executable and executed line numbers for one source file."""

    statements: frozenset[int]
    executed: frozenset[int]


@dataclass(frozen=True)
class Tally:
    lines: int = 0
    covered: int = 0

    def __add__(self, other: "Tally") -> "Tally":
        return Tally(self.lines + other.lines, self.covered + other.covered)

    def row(self, name: str) -> dict[str, str | int]:
        pct = f"{100 * self.covered / self.lines:.1f}%" if self.lines else "n/a"
        return {"Contributor": name, "Lines": self.lines, "Covered": self.covered,
                "Uncovered": self.lines - self.covered, "Coverage": pct}


@dataclass(frozen=True)
class BlameLine:
    line: int
    author: str
    email: str


# ---------------------------------------------------------------- test runners

class TestRunner:
    """Runs a repo's full test suite with coverage and returns per-file coverage."""

    name = "?"

    def __init__(self, repo: Path):
        self.repo = repo

    @staticmethod
    def detect(repo: Path) -> "TestRunner":
        return (GoRunner if (repo / "go.mod").exists() else PythonRunner)(repo)

    def run(self) -> dict[str, FileCoverage]:
        raise NotImplementedError

    def _exec(self, cmd: list[str]) -> None:
        print(f"running: {' '.join(cmd)}", file=sys.stderr)
        result = subprocess.run(cmd, cwd=self.repo)
        if result.returncode != 0:
            print("warning: some tests failed; coverage is from the tests that ran", file=sys.stderr)


class GoRunner(TestRunner):
    name = "Go"

    def run(self) -> dict[str, FileCoverage]:
        with tempfile.TemporaryDirectory() as tmp:
            profile = Path(tmp) / "cover.out"
            self._exec(["go", "test", f"-tags={GO_TAGS}", "-coverpkg=./...",
                        f"-coverprofile={profile}", "./..."])
            if not profile.exists():
                sys.exit("error: go test produced no coverage profile")
            return GoProfile(self.repo).parse(profile.read_text())


class PythonRunner(TestRunner):
    name = "Python"

    def run(self) -> dict[str, FileCoverage]:
        with tempfile.TemporaryDirectory() as tmp:
            report = Path(tmp) / "coverage.json"
            self._exec([sys.executable, "-m", "pytest", "-q", f"--cov={self.repo}",
                        f"--cov-report=json:{report}"])
            if not report.exists():
                sys.exit("error: pytest produced no coverage report (is pytest-cov installed?)")
            files = json.loads(report.read_text())["files"]
        return {
            path: FileCoverage(
                statements=frozenset(d["executed_lines"]) | frozenset(d["missing_lines"]),
                executed=frozenset(d["executed_lines"]),
            )
            for path, d in ((_relative(p, self.repo), d) for p, d in files.items())
            if not PY_TEST_FILE.search(path)
        }


def _relative(path: str, repo: Path) -> str:
    p = Path(path)
    return (p.resolve().relative_to(repo) if p.is_absolute() else p).as_posix()


# ---------------------------------------------------------------- go profiles

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
    """Turns a Go cover profile into line-level coverage.

    Go reports coverage per block, so each source line inside a block is
    counted, except blank lines, comments and lone braces. A line is covered if
    any block containing it ran (this also merges the duplicate blocks that
    -coverpkg produces).
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
            yield BlameLine(line=line_no, author=meta.get("author", "unknown"),
                            email=meta.get("author-mail", "").strip("<>").lower())
            meta, expecting_header = {}, True
        elif expecting_header:
            line_no, expecting_header = int(raw.split()[2]), False
        else:
            key, _, value = raw.partition(" ")
            meta[key] = value


# ---------------------------------------------------------------- report

def line_tallies(coverage: Mapping[str, FileCoverage], blame: GitBlame) -> Iterator[tuple[str, str, Tally]]:
    """Yield (email, author, Tally) for every executable line in the repo."""
    for path in sorted(coverage):
        cov, blamed = coverage[path], blame(path)
        for n in sorted(cov.statements):
            if (b := blamed.get(n)) is not None:
                yield b.email or b.author, b.author, Tally(1, int(n in cov.executed))


def aggregate(records: Iterable[tuple[str, str, Tally]]) -> dict[str, tuple[str, Tally]]:
    def step(acc: dict[str, tuple[str, Tally]], rec: tuple[str, str, Tally]):
        key, name, tally = rec
        _, prev = acc.get(key, (name, Tally()))
        return {**acc, key: (name, prev + tally)}
    return reduce(step, records, {})


def build_rows(totals: Mapping[str, tuple[str, Tally]]) -> list[dict[str, str | int]]:
    ranked = sorted(totals.values(), key=lambda nt: nt[1].lines, reverse=True)
    grand = reduce(lambda a, nt: a + nt[1], ranked, Tally())
    return [t.row(n) for n, t in ranked] + [grand.row("TOTAL")]


def to_markdown(rows: list[dict[str, str | int]]) -> str:
    headers = list(rows[0])
    widths = {h: max(len(h), *(len(str(r[h])) for r in rows)) for h in headers}
    fmt = lambda vals: "| " + " | ".join(str(v).ljust(widths[h]) for h, v in zip(headers, vals)) + " |"
    return "\n".join([
        fmt(headers),
        "|" + "|".join("-" * (widths[h] + 2) for h in headers) + "|",
        *(fmt(r.values()) for r in rows),
    ])


def write_csv(rows: list[dict[str, str | int]], path: Path) -> None:
    with path.open("w", newline="") as fh:
        writer = csv.DictWriter(fh, fieldnames=list(rows[0]))
        writer.writeheader()
        writer.writerows(rows)


def main() -> int:
    if not (REPO / ".git").exists():
        sys.exit(f"error: {REPO} is not the root of a git repo; run this from the repo root")
    runner = TestRunner.detect(REPO)
    print(f"{runner.name} repo: running unit + integration tests with coverage", file=sys.stderr)
    coverage = runner.run()
    rows = build_rows(aggregate(line_tallies(coverage, GitBlame(REPO))))
    print("\nTest coverage per contributor (unit + integration)\n")
    print(to_markdown(rows))
    write_csv(rows, OUTPUT_CSV)
    print(f"\nsaved {OUTPUT_CSV.name}", file=sys.stderr)
    return 0


if __name__ == "__main__":
    sys.exit(main())
