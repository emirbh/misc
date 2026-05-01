[200~#!/usr/bin/env python3
"""
Sync a source directory to a target directory, copying only files/dirs
that differ. Entries listed in a `.exclude` file (one pattern per line)
are skipped entirely.
"""

from __future__ import annotations

import argparse
import filecmp
import fnmatch
import os
import shutil
import sys
from dataclasses import dataclass, field
from pathlib import Path
from typing import Iterator


@dataclass
class SyncStats:
    copied: int = 0
    skipped: int = 0
    excluded: int = 0
    deleted: int = 0
    errors: list[str] = field(default_factory=list)

    def report(self) -> str:
        lines = [
            f"Copied:   {self.copied}",
            f"Skipped:  {self.skipped} (identical)",
            f"Excluded: {self.excluded}",
            f"Deleted:  {self.deleted} (not in source)",
        ]
        if self.errors:
            lines.append(f"Errors:   {len(self.errors)}")
            for err in self.errors:
                lines.append(f"  - {err}")
        return "\n".join(lines)


def parse_exclude_file(exclude_path: Path) -> list[str]:
    """Read `.exclude` and return a list of glob patterns, ignoring blanks
    and comments (lines starting with #)."""
    if not exclude_path.is_file():
        return []
    patterns: list[str] = []
    for raw in exclude_path.read_text().splitlines():
        line = raw.strip()
        if line and not line.startswith("#"):
            patterns.append(line)
    return patterns


def is_excluded(rel_path: Path, patterns: list[str]) -> bool:
    """Check whether *any* component of `rel_path` matches an exclude pattern."""
    parts = rel_path.parts
    return any(
        fnmatch.fnmatch(part, pat)
        for part in parts
        for pat in patterns
    )


def iter_entries(directory: Path) -> Iterator[Path]:
    """Yield every path under `directory` relative to it."""
    for root, dirs, files in os.walk(directory):
        root_path = Path(root)
        for name in dirs + files:
            yield (root_path / name).relative_to(directory)


def files_are_identical(src: Path, dst: Path) -> bool:
    """Shallow + content comparison of two files."""
    if not dst.exists():
        return False
    if src.is_dir() != dst.is_dir():
        return False
    if src.is_file() and dst.is_file():
        return filecmp.cmp(src, dst, shallow=False)
    return True  # both are dirs — structure checked elsewhere


def copy_if_changed(
    src: Path,
    dst: Path,
    rel: Path,
    *,
    stats: SyncStats,
    dry_run: bool,
    verbose: bool,
) -> None:
    """Copy *src* to *dst* only when they differ. Updates *stats* in place."""
    if src.is_dir():
        if not dst.exists():
            if verbose:
                print(f"MKDIR    {rel}")
            if not dry_run:
                dst.mkdir(parents=True, exist_ok=True)
            stats.copied += 1
        return

    if files_are_identical(src, dst):
        stats.skipped += 1
        if verbose:
            print(f"SKIP     {rel}")
        return

    if verbose:
        print(f"COPY     {rel}")
    if not dry_run:
        try:
            dst.parent.mkdir(parents=True, exist_ok=True)
            shutil.copy2(src, dst)
        except OSError as exc:
            stats.errors.append(f"{rel}: {exc}")
            return
    stats.copied += 1


def sync(
    source: Path,
    target: Path,
    *,
    prune: bool = False,
    dry_run: bool = False,
    verbose: bool = False,
) -> SyncStats:
    """
    One-way sync from *source* to *target*.

    Parameters
    ----------
    source:   root of the source tree
    target:   root of the target tree (created if missing)
    prune:    delete files in target that don't exist in source
    dry_run:  log actions without touching the filesystem
    verbose:  print every decision
    """
    stats = SyncStats()
    exclude_patterns = parse_exclude_file(source / ".exclude")

    if verbose and exclude_patterns:
        print(f"Exclude patterns: {exclude_patterns}")

    # --- copy / update pass ------------------------------------------------
    for rel in iter_entries(source):
        if is_excluded(rel, exclude_patterns):
            stats.excluded += 1
            if verbose:
                print(f"EXCLUDE  {rel}")
            continue

        copy_if_changed(
            source / rel, target / rel, rel,
            stats=stats, dry_run=dry_run, verbose=verbose,
        )

    # --- prune pass (optional) ---------------------------------------------
    if prune and target.is_dir():
        for rel in sorted(iter_entries(target), reverse=True):
            src_path = source / rel
            dst_path = target / rel
            if not src_path.exists() and not is_excluded(rel, exclude_patterns):
                if verbose:
                    print(f"DELETE   {rel}")
                if not dry_run:
                    try:
                        if dst_path.is_dir():
                            dst_path.rmdir()
                        else:
                            dst_path.unlink()
                    except OSError as exc:
                        stats.errors.append(f"delete {rel}: {exc}")
                        continue
                stats.deleted += 1

    return stats


def parse_arguments(argv: list[str] | None = None) -> argparse.Namespace:
    """Parse and validate CLI arguments."""
    parser = argparse.ArgumentParser(
        description="Sync source → target, respecting a .exclude file."
    )
    parser.add_argument("source", type=Path, help="Source directory")
    parser.add_argument("target", type=Path, help="Target directory")
    parser.add_argument(
        "--prune", action="store_true",
        help="Delete target entries that no longer exist in source",
    )
    parser.add_argument(
        "--dry-run", "-n", action="store_true",
        help="Show what would happen without writing anything",
    )
    parser.add_argument(
        "--verbose", "-v", action="store_true",
        help="Print every file decision",
    )
    args = parser.parse_args(argv)

    if not args.source.is_dir():
        sys.exit(f"Error: source '{args.source}' is not a directory")

    return args


def main(argv: list[str] | None = None) -> None:
    args = parse_arguments(argv)

    if args.dry_run:
        print("=== DRY RUN ===\n")

    stats = sync(
        args.source,
        args.target,
        prune=args.prune,
        dry_run=args.dry_run,
        verbose=args.verbose,
    )
    print(f"\n{stats.report()}")
    if stats.errors:
        sys.exit(1)


if __name__ == "__main__":
    main()
