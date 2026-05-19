# Data Model Registry — Design Document

## 1. Overview

The Data Model Registry is a Go service that stores JSON Schema data models in MongoDB and serves them through a REST API. It supports two categories of data models:

- **Logical models** (`data-model`) — technology-agnostic conceptual models describing business entities and their properties.
- **Physical models** (`model_implementation`) — concrete implementations of logical models tied to a specific storage technology (e.g., MongoDB collection, PostgreSQL table).

Physical models reference the logical model they implement via the `implements` field, and any model property can reference another model via JSON Schema's `$ref` mechanism.

The system is designed to run across multiple environments (local development through production) with a single codebase and configuration-driven behavior.

---

## 2. Data Model Structure

Each data model is a JSON Schema document with the following structure:

```json
{
  "$id": "https://example.com/schemas/customer",
  "$schema": "https://json-schema.org/draft/2020-12/schema",
  "title": "Customer",
  "description": "Core customer entity for the billing domain",
  "type": "data-model",
  "properties": {
    "customerId": { "type": "string", "description": "UUID primary key" },
    "email": { "type": "string", "description": "Primary contact email" },
    "address": {
      "$ref": "https://example.com/schemas/address"
    }
  }
}
```

### 2.1 Model Types

| Field Value            | Internal Constant | Description                                  |
|------------------------|-------------------|----------------------------------------------|
| `data-model`           | `domain.Logical`  | Conceptual, technology-agnostic data model   |
| `model_implementation` | `domain.Physical`  | Concrete implementation of a logical model   |

### 2.2 Reference Tracking

Physical models point to their logical counterpart via the `implements` field. Any property in any model can reference another model via `$ref`. At registration time, the system:

1. Recursively extracts all `$ref` values from properties (including nested objects and array items).
2. Appends the `implements` target (if present) to the refs list.
3. Stores the deduplicated list in a `refs` array field for O(1) reference lookups.

### 2.3 Search Text

A `_search` field is computed at registration time by concatenating:

- Model title and description
- Model type
- All property names and their descriptions (recursively)
- The `implements` target ID (if present)

This pre-built string powers full-text search across all stored models.

### 2.4 Go Domain Struct

Defined in `internal/domain/model.go`:

```go
type DataModel struct {
    ID          string              `json:"$id"                   bson:"_id"`
    Schema      string              `json:"$schema"               bson:"schema"`
    Title       string              `json:"title"                 bson:"title"`
    Description string              `json:"description,omitempty" bson:"description,omitempty"`
    Type        ModelType           `json:"type"                  bson:"type"`
    Properties  map[string]Property `json:"properties,omitempty"  bson:"properties,omitempty"`
    Implements  string              `json:"implements,omitempty"   bson:"implements,omitempty"`
    Refs        []string            `json:"refs,omitempty"         bson:"refs,omitempty"`
    SearchText  string              `json:"-"                      bson:"_search,omitempty"`
}
```

### 2.5 Validation Rules

- `$id` is required.
- `title` is required.
- `type` must be `data-model` or `model_implementation`.
- Physical models must have a non-empty `implements` field.

---

## 3. Architecture

```
┌───────────────────────────────────────────────────────────┐
│                      cmd/main.go                          │
│              Cobra CLI + Viper Configuration               │
│                     ┌───────────┐                         │
│                     │  serve    │                          │
│                     └─────┬─────┘                         │
│                           │                               │
│                    ┌──────▼──────┐                         │
│                    │  api/       │  REST API (net/http)    │
│                    │  handlers   │                         │
│                    └──────┬──────┘                         │
│                           │                               │
│                    ┌──────▼──────┐                         │
│                    │  service/   │  Business logic         │
│                    │  ModelSvc   │                         │
│                    └──────┬──────┘                         │
│                           │                               │
│                    ┌──────▼──────┐                         │
│                    │ repository/ │  Storage interface      │
│                    │ Repository  │                         │
│                    └──┬───┬───┬──┘                         │
│                       │   │   │                           │
│              ┌────────┘   │   └────────┐                  │
│              ▼            ▼            ▼                   │
│         ┌────────┐  ┌─────────┐  ┌─────────┐             │
│         │ local/ │  │ lungo/  │  │ mongo/  │             │
│         │in-mem  │  │ in-mem  │  │ MongoDB │             │
│         │ map    │  │ MongoDB │  │ driver  │             │
│         └────────┘  └─────────┘  └─────────┘             │
└───────────────────────────────────────────────────────────┘
```

### 3.1 Layer Responsibilities

| Layer           | Package                    | Purpose                                                        |
|-----------------|----------------------------|----------------------------------------------------------------|
| CLI             | `cmd/main.go`              | Cobra command tree, Viper config loading, server bootstrap     |
| Configuration   | `internal/config/`         | Config struct, validation, collection/database name derivation |
| API             | `internal/api/`            | HTTP handlers, request/response serialization                  |
| Service         | `internal/service/`        | Business logic, validation, search, reference graph            |
| Repository      | `internal/repository/`     | Storage interface definition                                   |
| Local Repo      | `internal/repository/local/`  | In-memory store with inverted index (original, test-only)   |
| Lungo Repo      | `internal/repository/lungo/`  | In-memory MongoDB-compatible store via lungo                |
| Mongo Repo      | `internal/repository/mongo/`  | Production MongoDB driver implementation                    |
| Domain          | `internal/domain/`         | Core types, pure transformation functions                      |
| FP Utilities    | `internal/fp/`             | Generic functional programming helpers                         |

---

## 4. Configuration System

### 4.1 Config Fields

| Field         | Flag              | Env Var               | Default                       | Description                                                        |
|---------------|-------------------|-----------------------|-------------------------------|--------------------------------------------------------------------|
| `domain`      | `--domain`        | `REGISTRY_DOMAIN`     | *(required)*                  | Business domain name (e.g., `billing`, `inventory`)                |
| `model_scope` | `--model-scope`   | `REGISTRY_MODEL_SCOPE`| `both`                        | Which model types to serve: `logical`, `physical`, or `both`       |
| `environment` | `--environment`   | `REGISTRY_ENVIRONMENT`| `local_dev`                   | Runtime environment: `local_dev`, `dev`, `uat`, `prod`             |
| `mongo_uri`   | `--mongo-uri`     | `REGISTRY_MONGO_URI`  | *(required unless local_dev)* | MongoDB connection string                                          |
| `mongo_db`    | `--mongo-db`      | `REGISTRY_MONGO_DB`   | `<domain>_schema_registry`    | MongoDB database name override                                    |
| `peer_url`    | `--peer-url`      | `REGISTRY_PEER_URL`   | *(empty)*                     | URL of peer service for cross-type model resolution                |
| `listen_addr` | `--listen-addr`   | `REGISTRY_LISTEN_ADDR`| `:8080`                       | HTTP server listen address                                         |

### 4.2 Configuration Precedence

Viper resolves values in this order (highest priority first):

1. CLI flags (`--domain billing`)
2. Environment variables (`REGISTRY_DOMAIN=billing`)
3. Config file (`config.yaml`)
4. Defaults

### 4.3 Config File

The service looks for `config.yaml` in the current directory or `$HOME/.schema-registry/`. A custom path can be specified with `--config /path/to/config.yaml`.

```yaml
domain: "billing"
model_scope: "both"
environment: "local_dev"
mongo_uri: ""
mongo_db: ""
peer_url: ""
listen_addr: ":8080"
```

### 4.4 Validation Rules

- `domain` is always required.
- `model_scope` must be `logical`, `physical`, or `both`.
- `environment` must be `local_dev`, `dev`, `uat`, or `prod`.
- `mongo_uri` is required for all environments except `local_dev`.

---

## 5. Database Design

### 5.1 Dynamic Collection Naming

Collections are named based on the configured domain and model scope:

```
<domain>_datamodels_<scope>
```

| Configuration              | Collection Name                  |
|----------------------------|----------------------------------|
| `domain=billing, scope=logical`  | `billing_datamodels_logical`   |
| `domain=billing, scope=physical` | `billing_datamodels_physical`  |
| `domain=billing, scope=both`     | `billing_datamodels_all`       |
| `domain=inventory, scope=logical`| `inventory_datamodels_logical` |

### 5.2 Dynamic Database Naming

The database name defaults to `<domain>_schema_registry` (e.g., `billing_schema_registry`) but can be overridden with the `mongo_db` configuration field.

### 5.3 Single Collection vs. Split Collections

The system uses a **single collection per service instance**. When `model_scope` is set to `logical` or `physical`, the service only stores and serves that type, and the collection name reflects this. When set to `both`, a single collection holds both types, discriminated by the `type` field.

To run separate repositories for logical and physical models, deploy two instances of the service with different `model_scope` settings. Each gets its own collection:

```
Instance A:  --domain billing --model-scope logical   → billing_datamodels_logical
Instance B:  --domain billing --model-scope physical  → billing_datamodels_physical
```

The `peer_url` field connects the two instances so each can resolve cross-type references.

### 5.4 MongoDB Indexes

Three indexes are created on each collection at startup:

| Index Name     | Key(s)             | Type      | Purpose                                            |
|----------------|--------------------|-----------|----------------------------------------------------|
| `text_search`  | `_search`          | Text      | Full-text search across all model metadata          |
| `idx_type`     | `type`             | Standard  | Fast filtering by model type (logical/physical)     |
| `idx_refs`     | `refs`             | Multi-key | O(log n) lookup for reference graph queries         |

Index creation is idempotent — calling `EnsureIndexes` on startup is safe.

### 5.5 Search Strategy

All searchable content is pre-concatenated into a single `_search` string field at registration time. This includes the title, description, model type, all property names and descriptions, and the implements target.

- **MongoDB (production)**: Uses a native text index on `_search` with `$text` queries. Results are sorted by text relevance score (`$meta: "textScore"`).
- **Lungo (local dev)**: Since lungo does not support `$text` indexes or `$regex`, search is performed client-side: all documents matching the type filter are fetched, then filtered in-memory by checking that every query word appears in the lowercase `_search` field. This is acceptable for local development volumes.

Both implementations use AND semantics — all words in the query must appear in the model's search text.

---

## 6. Storage Backend Selection

### 6.1 Environment-Based Switching

| Environment | Backend  | Notes                                                 |
|-------------|----------|-------------------------------------------------------|
| `local_dev` | Lungo    | MongoDB-compatible store, persisted to `local_dev_db.json` |
| `dev`       | MongoDB  | Requires `mongo_uri`                                  |
| `uat`       | MongoDB  | Requires `mongo_uri`                                  |
| `prod`      | MongoDB  | Requires `mongo_uri`                                  |

### 6.2 Lungo (Local Development)

[Lungo](https://github.com/256dpi/lungo) is an in-memory MongoDB-compatible database written in Go. It implements the same `IClient`/`IDatabase`/`ICollection` interfaces as the official MongoDB driver, providing:

- Zero external dependencies for local development.
- Fast startup and teardown.
- Compatible query semantics for CRUD operations, array queries (`refs` lookups), and sorting.

#### 6.2.1 JSON File Persistence

Lungo persists all data to `local_dev_db.json` in the working directory. This file is loaded on startup and written after every mutation, so data survives process restarts.

JSON was chosen over BSON (lungo's default `FileStore` format) because the project's security policy prohibits creation of binary files, and local development will never accumulate enough data for JSON serialization overhead to matter.

The custom `JSONStore` (`internal/repository/lungo/jsonstore.go`) implements lungo's `Store` interface:

- **`Load()`** — reads `local_dev_db.json`, deserializes the JSON into lungo's internal `Catalog` structure (namespaces, documents, indexes), and rebuilds the in-memory index trees.
- **`Store()`** — converts the in-memory `Catalog` back to JSON and writes it atomically to disk.

The file structure mirrors lungo's namespace layout:

```json
{
  "namespaces": {
    "billing_schema_registry.billing_datamodels_all": {
      "documents": [
        [
          {"Key": "_id", "Value": "https://example.com/schemas/customer"},
          {"Key": "title", "Value": "Customer"},
          ...
        ]
      ],
      "indexes": {
        "idx_type": {"key": [{"Key": "type", "Value": 1}], "unique": false},
        "idx_refs": {"key": [{"Key": "refs", "Value": 1}], "unique": false}
      }
    }
  }
}
```

If `local_dev_db.json` does not exist on startup, an empty catalog is created and the file is written on the first mutation.

**Limitations vs. real MongoDB:**

- No text index support — search is done client-side with string matching.
- No `$regex` operator support.

Despite these differences, both backends implement the same `repository.Repository` interface, so the service and API layers are completely unaware of which backend is in use.

### 6.3 MongoDB (Non-Local Environments)

The production MongoDB implementation uses:

- Official Go driver (`go.mongodb.org/mongo-driver`).
- Upsert semantics for `Save()` to support both insert and update.
- Text index with relevance scoring for search.
- Connection validation via `Ping()` on startup.

### 6.4 Repository Interface

All storage backends implement this interface (`internal/repository/repository.go`):

```go
type Repository interface {
    Save(ctx context.Context, model domain.DataModel) error
    FindByID(ctx context.Context, id string) (*domain.DataModel, error)
    Delete(ctx context.Context, id string) error
    Search(ctx context.Context, opts SearchOptions) ([]domain.DataModel, error)
    FindByRef(ctx context.Context, ref string) ([]domain.DataModel, error)
    FindImplementations(ctx context.Context, logicalID string) ([]domain.DataModel, error)
    List(ctx context.Context, modelType *domain.ModelType) ([]domain.DataModel, error)
}
```

---

## 7. REST API

### 7.1 Endpoints

| Method   | Path                        | Description                                        |
|----------|-----------------------------|----------------------------------------------------|
| `GET`    | `/api/v1/health`            | Health check                                       |
| `GET`    | `/api/v1/models`            | List all models (optional `?type=` filter)         |
| `POST`   | `/api/v1/models`            | Register a new model                               |
| `GET`    | `/api/v1/models/search`     | Full-text search with pagination                   |
| `GET`    | `/api/v1/models/{id}`       | Get a model by `$id`                               |
| `PUT`    | `/api/v1/models/{id}`       | Update a model (upsert)                            |
| `DELETE` | `/api/v1/models/{id}`       | Delete a model (optional `?cascade=true`)          |
| `GET`    | `/api/v1/models/{id}/graph` | Get one-hop reference graph for a model            |
| `GET`    | `/api/v1/stats`             | Summary statistics (counts, unimplemented models)  |

### 7.2 Search Parameters

| Parameter | Type   | Description                                         |
|-----------|--------|-----------------------------------------------------|
| `q`       | string | Search query (words are ANDed)                      |
| `type`    | string | Filter by model type: `data-model` or `model_implementation` |
| `offset`  | int    | Pagination offset (zero-based)                      |
| `limit`   | int    | Maximum results per page                            |

### 7.3 Example: Register a Logical Model

```bash
curl -X POST http://localhost:8080/api/v1/models \
  -H 'Content-Type: application/json' \
  -d '{
    "$id": "https://example.com/schemas/customer",
    "$schema": "https://json-schema.org/draft/2020-12/schema",
    "title": "Customer",
    "description": "Core customer entity for the billing domain",
    "type": "data-model",
    "properties": {
      "customerId": {"type": "string", "description": "UUID primary key"},
      "email": {"type": "string", "description": "Primary contact email"}
    }
  }'
```

### 7.4 Example: Register a Physical Model

```bash
curl -X POST http://localhost:8080/api/v1/models \
  -H 'Content-Type: application/json' \
  -d '{
    "$id": "https://example.com/schemas/customer-mongo",
    "$schema": "https://json-schema.org/draft/2020-12/schema",
    "title": "Customer MongoDB",
    "description": "MongoDB collection mapping for Customer",
    "type": "model_implementation",
    "implements": "https://example.com/schemas/customer",
    "properties": {
      "_id": {"type": "string", "description": "Maps to customerId"},
      "email": {"type": "string"}
    }
  }'
```

### 7.5 Example: Search

```bash
curl "http://localhost:8080/api/v1/models/search?q=billing+email&limit=10"
```

### 7.6 Example: Cascade Delete

```bash
curl -X DELETE "http://localhost:8080/api/v1/models/https://example.com/schemas/customer?cascade=true"
```

This deletes the logical model and all physical models that implement it.

---

## 8. CLI Usage

### 8.1 Start the Server (Local Dev)

```bash
schema-registry serve --domain billing
```

This starts the server on `:8080` with lungo (in-memory) storage, collection `billing_datamodels_all`.

### 8.2 Start with Separate Model Scope

```bash
# Logical models only
schema-registry serve --domain billing --model-scope logical --listen-addr :8080

# Physical models only, pointing to the logical peer
schema-registry serve --domain billing --model-scope physical --listen-addr :8081 \
  --peer-url http://localhost:8080
```

### 8.3 Start with Production MongoDB

```bash
schema-registry serve \
  --domain billing \
  --environment prod \
  --mongo-uri "mongodb://user:pass@mongo-host:27017" \
  --listen-addr :8080
```

### 8.4 Using Environment Variables

```bash
export REGISTRY_DOMAIN=billing
export REGISTRY_ENVIRONMENT=prod
export REGISTRY_MONGO_URI=mongodb://mongo-host:27017
schema-registry serve
```

---

## 9. Peer URL and Cross-Type Resolution

When `model_scope` is set to `logical` or `physical`, the service only stores one type. The `peer_url` configuration points to the companion service instance that stores the other type.

| This Instance Serves | Peer Serves | Peer URL Purpose                                    |
|----------------------|-------------|-----------------------------------------------------|
| `logical`            | `physical`  | Resolve physical implementations of logical models  |
| `physical`           | `logical`   | Resolve the logical model a physical one implements  |

The peer URL field is currently stored in configuration for future use in cross-service resolution.

---

## 10. Project Structure

```
data-model-registry/
├── cmd/
│   └── main.go                          # Cobra CLI entry point
├── config.yaml                          # Default configuration
├── go.mod
├── go.sum
└── internal/
    ├── api/
    │   └── handlers.go                  # REST API handlers
    ├── config/
    │   ├── config.go                    # Config struct and validation
    │   └── config_test.go
    ├── domain/
    │   ├── model.go                     # Core types and pure functions
    │   └── model_test.go
    ├── fp/
    │   ├── fp.go                        # Generic FP utilities
    │   └── fp_test.go
    ├── repository/
    │   ├── repository.go                # Storage interface
    │   ├── local/
    │   │   ├── local_repo.go            # In-memory store (inverted index)
    │   │   └── local_repo_test.go
    │   ├── lungo/
    │   │   ├── lungo_repo.go            # Lungo MongoDB-compatible store
    │   │   ├── lungo_repo_test.go
    │   │   └── jsonstore.go             # JSON file persistence for lungo
    │   └── mongo/
    │       ├── mongo_repo.go            # Production MongoDB store
    │       └── mongo_repo_test.go
    └── service/
        ├── model_service.go             # Business logic layer
        └── model_service_test.go
```

---

## 11. Dependencies

| Dependency                       | Version | Purpose                                      |
|----------------------------------|---------|----------------------------------------------|
| `github.com/spf13/cobra`        | v1.10   | CLI command framework                        |
| `github.com/spf13/viper`        | v1.21   | Configuration management (file, env, flags)  |
| `github.com/256dpi/lungo`       | v0.4    | In-memory MongoDB-compatible store           |
| `go.mongodb.org/mongo-driver`   | v1.17   | Official MongoDB Go driver                   |

---

## 12. Testing

### 12.1 Test Coverage

| Package                        | Tests                                                                      |
|--------------------------------|----------------------------------------------------------------------------|
| `internal/domain`              | Ref extraction, search text building, prepare, validation, predicates      |
| `internal/fp`                  | Map, Filter, Reduce, FlatMap, Unique, Paginate, Tokenize, Result           |
| `internal/repository/local`    | Full CRUD, search (single/multi-word, case-insensitive), pagination, refs  |
| `internal/repository/lungo`    | CRUD, search, find implementations, list with type filter                  |
| `internal/repository/mongo`    | Same suite as local (requires running MongoDB, skipped if `MONGO_URI` unset) |
| `internal/service`             | Register, remove (with/without cascade), stats, reference graph            |
| `internal/config`              | Collection naming, database naming, validation                             |

### 12.2 Running Tests

```bash
# All tests (MongoDB tests auto-skip if MONGO_URI not set)
go test ./...

# Including MongoDB integration tests
MONGO_URI=mongodb://localhost:27017 go test ./...
```

---

## 13. Design Decisions

### 13.1 Single Collection Per Instance (Not Split)

Rather than maintaining separate collections within a single service process, each service instance owns one collection. To separate logical and physical models into different collections, deploy two instances with `--model-scope logical` and `--model-scope physical`. This approach:

- Keeps the codebase simple — one `Repository` interface, one collection per instance.
- Allows independent scaling and deployment of logical vs. physical model services.
- Uses the `peer_url` mechanism for cross-type resolution when needed.

### 13.2 Pre-Built Search Text

Instead of building compound text indexes across multiple fields, all searchable content is concatenated into a single `_search` field. This gives:

- Predictable search behavior across both MongoDB and lungo backends.
- Simple index configuration (one text index per collection).
- Full control over what content is searchable.

### 13.3 Lungo Over Mocked In-Memory Store

The original codebase had a hand-built in-memory store (`local/`) with an inverted index. Lungo was added as a second in-memory option because it uses the same BSON/query semantics as MongoDB, catching query-construction bugs that a hand-built store would miss. The original local store is retained for unit tests that need no external dependencies at all.

### 13.4 JSON Persistence Over BSON

Lungo ships with a `FileStore` that serializes its catalog to a BSON binary file. A custom `JSONStore` was implemented instead because:

- The project's security policy does not allow creation of binary files.
- Local development datasets are small enough that JSON serialization overhead is negligible.
- JSON files are human-readable, making it easy to inspect or manually edit the local database during development.
- The file (`local_dev_db.json`) can be committed to version control to share seed data across the team if desired.

### 13.5 Cobra + Viper

Cobra provides a structured CLI with subcommands, flags, and help generation. Viper layers configuration from files, environment variables, and flags with a single unified API. Together they allow the same binary to be configured differently across environments without code changes.
