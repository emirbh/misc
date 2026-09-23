# data-domain upsert (pre-commit hook)

Keeps the DMR server's view of each data domain in sync with the repository.
Every time a commit contains a `data-domain.json`, the hook collects the `$id` of
every JSON file governed by that domain and sends them to DMR.

---

## 1. How it works

A `data-domain.json` governs its own folder **and all sub-folders**:

```
models/
└── sales/
    ├── data-domain.json        {"domainName": "Sales"}
    ├── trade.json              {"$id": "urn:trade", ...}        ─┐
    └── eu/                                                      │ governed by "Sales"
        ├── no_id.json          {"name": "..."}   (no $id, skipped) │
        └── fr/                                                  │
            └── position.json   {"$id": "urn:position", ...}    ─┘
```

When the commit contains `models/sales/data-domain.json`:

| Step | What happens |
|---|---|
| 1 | pre-commit starts the hook, because a file named `data-domain.json` is staged. Without one, the hook is skipped. |
| 2 | The hook reads `domainName` from the file. |
| 3 | It scans every `*.json` file under `models/sales/`, recursively, and reads `$id`. Files without `$id`, and files whose JSON is not an object, are skipped. |
| 4 | Duplicate ids are removed and the list is sorted. |
| 5 | `POST $DMR_SERVER/domain/update` is sent with the body below. |
| 6 | A 2xx response lets the commit go through. Any error **blocks the commit**. |

Request body:

```json
{ "domainName": "Sales", "ids": ["urn:position", "urn:trade"] }
```

If several `data-domain.json` files are staged, every one is parsed first and
then **one request per domain** is sent. If any domain file is invalid, **nothing**
is sent.

### Order relative to other hooks

pre-commit runs hooks in the order they appear in `.pre-commit-config.yaml`. The
upsert hook is the **last entry**, and `fail_fast: true` makes pre-commit stop at
the first failing hook. So DMR is called only when every other check (formatting,
linting, schema validation, …) has already passed.

---

## 2. Prerequisites

- Python 3.9 or newer (standard library only; no extra packages)
- git
- pre-commit: `pip install pre-commit` or `brew install pre-commit`
- Network access from the developer machine to the DMR server

---

## 3. Configure

### 3.1 Add the files to the repository

```
<repo>/
├── .pre-commit-config.yaml
├── scripts/
│   └── sync_data_domain.py
├── tests/
│   └── test_sync_data_domain.py
└── data-domain-upsert.md
```

### 3.2 `.pre-commit-config.yaml`

```yaml
fail_fast: true              # stop at first failure → DMR only called if all hooks pass

repos:
  # ---- existing hooks go FIRST ----
  - repo: https://github.com/pre-commit/pre-commit-hooks
    rev: v5.0.0
    hooks:
      - id: check-json
      - id: end-of-file-fixer

  # ---- must stay LAST ----
  - repo: local
    hooks:
      - id: sync-data-domain
        name: upsert data-domain ids to DMR
        entry: python scripts/sync_data_domain.py
        language: python
        files: (^|/)data-domain\.json$
```

> If your environment brings in outside hooks through the FinOS git-proxy,
> mirror `pre-commit-hooks` internally and point `repo:` at that mirror.
> The `local` hook needs no download.

### 3.3 Set the DMR server

The hook reads the server address from the `DMR_SERVER` environment variable.
A trailing `/` is allowed.

```bash
# macOS / zsh — add to ~/.zshrc
export DMR_SERVER="https://dmr.internal.example.com"
```

GUI git clients (IntelliJ, VS Code, SourceTree) may not read `~/.zshrc`. If the
hook reports `DMR_SERVER is not set` there, start the IDE from a terminal or
set the variable in the IDE's environment settings.

### 3.4 Install the hook (once per clone)

```bash
pre-commit install
```

---

## 4. Execute

### Normal use

Commit as usual. The hook runs by itself when a `data-domain.json` is staged:

```bash
git add models/sales/data-domain.json
git commit -m "Sales domain: add EU positions"
```

```
check json...............................................Passed
upsert data-domain ids to DMR............................Passed
- hook id: sync-data-domain
- duration: 0.21s

DMR: domain 'Sales' updated with 2 ids (HTTP 200)
```

> The hook runs only when `data-domain.json` itself is in the commit.
> If you add a new JSON file under a domain and want DMR updated, also stage the
> domain file (touch or edit it), or run the hook manually as shown below.

### Run manually (no commit)

```bash
# one domain
pre-commit run sync-data-domain --files models/sales/data-domain.json

# every domain in the repo (full resync)
pre-commit run sync-data-domain --all-files

# or call the script directly
DMR_SERVER=https://dmr.internal.example.com \
  python scripts/sync_data_domain.py models/sales/data-domain.json
```

### Skip in an emergency

```bash
SKIP=sync-data-domain git commit -m "..."   # skip only this hook
```

---

## 5. Failures and how to fix them

| Message | Cause | Fix |
|---|---|---|
| `DMR_SERVER is not set` | Environment variable missing | See 3.3 |
| `KeyError('domainName')` | `data-domain.json` has no `domainName` | Add the property |
| `JSONDecodeError(... ) ` | A domain file or a governed `.json` file is not valid JSON | Fix the file shown in the message |
| `HTTPError 4xx/5xx` | DMR rejected the request | Check the DMR server logs and the request body |
| `URLError(ConnectionRefused / timeout)` | Server unreachable | Check the VPN or proxy; the timeout is 30 s |

The commit is blocked in every case above. Nothing is sent to DMR until every
staged domain file has been parsed successfully.

---

## 6. Test

```bash
pip install pytest
pytest tests -v
pytest tests -v -k e2e        # only the end-to-end git tests
```

Fixtures: `workdir` gives each test a temp cwd with `DMR_SERVER` cleared.
`sales_domain` builds a sample domain tree. `dmr` starts a local fake DMR
server that records requests. `repo` creates a git repo with the hook installed
through `pre-commit install`.

| Area | What it covers |
|---|---|
| `collect_ids` / `read_id` | Recursive scan; files without `$id`, non-object JSON and the domain file itself are skipped; invalid JSON fails |
| `DomainUpdate` | Duplicates removed and ids sorted; request body; missing `domainName` |
| `main()` | No-op without a domain file; one request per domain; nothing sent if any domain is invalid; missing `DMR_SERVER`; HTTP 400/404/500/503; server unreachable |
| `test_e2e_*` | Real `git commit` in a temp repo: server called, hook skipped without a domain file, commit blocked when the server is down. Skipped automatically if `pre-commit` isn't on PATH |

---

## 7. Known limitations and customisation

- **Request body:** the body is `{"domainName", "ids"}`. If the DMR API expects
  a different shape, change `DomainUpdate.payload()`.
- **Authentication:** none. If DMR needs a token, add a header in
  `DmrClient.update()`, for example from `DMR_TOKEN`.
- **Nested domains:** a `data-domain.json` inside a governed sub-folder does not
  stop the scan, so those ids are also sent under the parent domain.
- **Timing:** DMR is updated **before** the commit is recorded. If the commit is
  aborted afterwards (for example, the commit message editor is closed), DMR is
  already updated. To update only after a successful commit, add
  `stages: [post-commit]` to the hook and run
  `pre-commit install --hook-type post-commit`. The hook then can no longer
  block the commit.
- **What gets read:** the hook reads files from the working tree, so unstaged
  edits to governed JSON files are included.
