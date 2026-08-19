# Keeping Project ISDA up to date

All five upstream repositories are tracked as **git submodules**, each pinned to a
specific commit. Nothing updates automatically — pulling the parent repo does *not* pull
the submodules. This page covers how to get everything current.

Every command below is run from the repo root unless stated otherwise:

```bash
cd /Users/emirbh/Projects/ISDA
```

---

## TL;DR

```bash
git pull && git submodule update --remote --merge && git submodule status
```

Pulls the parent repo, advances every submodule to the tip of its tracked branch, then
shows you what moved. Review, then commit the new pins (see [§5](#5-recording-the-new-pins)).

---

## 1. Prerequisites

Submodules use SSH remotes (`git@github.com:...`), so you need a GitHub SSH key loaded.
Verify with:

```bash
ssh -T git@github.com
```

A "successfully authenticated" response (even though it says shell access is not
provided) means you are good. If this fails, everything below fails.

---

## 2. Checking what is out of date

Fetch upstream refs for all submodules without changing any working tree:

```bash
git submodule foreach 'git fetch -q origin'
```

Then show each submodule's branch and how many commits it is behind:

```bash
git submodule foreach --quiet 'b=$(git rev-parse --abbrev-ref HEAD); n=$(git rev-list --count HEAD..@{u} 2>/dev/null || echo "?"); printf "%-36s %-8s %s behind\n" "$name" "$b" "$n"'
```

Sample output:

```
cdm-5-demo-trade-java                main     0 behind
cdm-7-demo-legaldocumentation-java   main     0 behind
common-domain-model                  master   0 behind
drr                                  main     0 behind
drr-5-demo-trade-java                main     0 behind
```

A `?` in the count means that submodule has no upstream tracking branch — usually
because it ended up in detached HEAD. See [§6](#6-fixing-a-detached-head).

For a compact view of the pinned commits at any time:

```bash
git submodule status
```

---

## 3. Updating everything

```bash
git pull
git submodule update --remote --merge
```

- `git pull` updates this repo (docs, tooling, and the *recorded pins* if someone else
  bumped them).
- `--remote` fetches each submodule's **tracked branch** — the `branch =` values in
  `.gitmodules` — rather than the pinned commit.
- `--merge` merges the new commits into the submodule's current branch, so it stays
  attached instead of detaching.

Tracked branches are:

| Submodule | Branch |
|---|---|
| `common-domain-model` | `master` |
| `drr` | `main` |
| `cdm-5-demo-trade-java` | `main` |
| `cdm-7-demo-legaldocumentation-java` | `main` |
| `drr-5-demo-trade-java` | `main` |

---

## 4. Updating just one

A submodule is an ordinary git repo. Go in and use git normally:

```bash
cd drr && git pull && cd ..
```

```bash
cd common-domain-model && git pull && cd ..
```

---

## 5. Recording the new pins

After any submodule moves, the parent repo reports it as modified:

```bash
git status
git submodule status
```

The parent tracks *which commit* each submodule sits at, so a moved submodule is a
change to be committed:

```bash
git add drr common-domain-model
git commit -m "Bump drr and common-domain-model to latest upstream"
```

To see what actually changed in a pin before committing:

```bash
git diff --submodule=log
```

### Discarding an update

To throw away submodule movement and snap everything back to the committed pins:

```bash
git submodule update
```

Note the missing `--remote` — that is what makes this command reset rather than advance.

---

## 6. Fixing a detached HEAD

`git submodule update` (without `--remote`), a fresh clone, or checking out an older
parent commit all leave submodules in **detached HEAD** at the pinned commit. Committed
work is not lost, but `git pull` inside the submodule will not work until you reattach:

```bash
cd common-domain-model && git checkout master && cd ..
```

```bash
cd drr && git checkout main && cd ..
```

Reattach all of them at once:

```bash
git submodule foreach 'git checkout $(git config -f $toplevel/.gitmodules submodule.$name.branch || echo main)'
```

---

## 7. Fresh clone

```bash
git clone --recurse-submodules <repo-url> ISDA
```

If already cloned without submodules, or a new submodule was added upstream:

```bash
git submodule update --init --recursive
```

If a submodule URL changed in `.gitmodules`:

```bash
git submodule sync --recursive
```

---

## 8. Optional convenience config

These are **not** set by default — they change how everyday git commands behave, so
apply them only if you want that:

```bash
git config submodule.recurse true
```
Makes `git pull`, `git checkout` and friends recurse into submodules automatically.

```bash
git config status.submodulesummary 1 && git config diff.submodule log
```
Makes `git status` and `git diff` show which commits a submodule moved by, instead of
just "modified content".

---

## 9. Before you bump a pin

The pins are deliberate, not incidental.

- **`common-domain-model` tracks `master`, a pre-release CDM 8 development line.**
  Pulling it brings in in-flight model changes that are expected to keep moving. If you
  need a stable base, the `5.x.x` branch — the line `drr` actually builds against — is
  the alternative.
- **`drr` builds against a released CDM 5.29.0 from the artifact registry**, not against
  the sibling `common-domain-model/` checkout. Updating one does not update the other,
  and the two are not interchangeable: there are three verified breaking changes between
  them.
- **Verify the build after bumping**, especially for the two focus repos:

  ```bash
  cd common-domain-model && mvn clean install -DskipTests
  ```

  ```bash
  cd drr && mvn clean install -DskipTests
  ```

  Both require JDK 21.

Read [`CDM-DRR-integration-notes.md`](CDM-DRR-integration-notes.md) before moving either
focus-repo pin.

---

## Document set

| Document | Contents |
|---|---|
| [`00-workspace-overview.md`](00-workspace-overview.md) | Inventory, how the pieces relate, build commands |
| [`CDM-summary.md`](CDM-summary.md) | What is in the CDM repo, layer by layer |
| [`CDM-design.md`](CDM-design.md) | CDM architecture, conventions, how to extend it |
| [`DRR-summary.md`](DRR-summary.md) | What is in the DRR repo, layer by layer |
| [`DRR-design.md`](DRR-design.md) | DRR architecture, conventions, how to extend it |
| [`CDM-DRR-integration-notes.md`](CDM-DRR-integration-notes.md) | Version skew, coupling points, migration scope |
