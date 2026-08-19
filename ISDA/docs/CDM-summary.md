# CDM — Summary

**Repository:** `/Users/emirbh/Projects/ISDA/common-domain-model`
**Branch / version:** `master`, `8.0.0-dev.3-1-g2c05b193` (last commit 2026-08-11)
**Group / artifact:** `org.finos.cdm : cdm-parent`
**License:** Community Specification License 1.0 (a specification licence, not Apache/MIT)

## What it is

The FINOS **Common Domain Model** is a machine-readable and machine-executable model of
how financial products are traded and managed across the transaction lifecycle. It is a
*logical* model: it deliberately prescribes no physical storage or wire format, and
positions itself as the interoperability layer between formats that already exist
(FpML for confirmation, FIX pre-trade, ISO 20022 for reporting).

It is governed as a FINOS open standard, hosted by ISDA, ICMA and ISLA jointly, with
release management contracted to Regnosys. Model changes flow through Working Groups
(Steering, Contribution Review, Collateral, Derivatives, Technology Architecture,
Physical Risk, Tokenized Assets, plus ISLA and ICMA groups) rather than through
individual maintainer discretion.

## Where things live

| Path | Contents |
|---|---|
| `rosetta-source/src/main/rosetta/` | **The model.** 145 `.rosetta` files, ~43,700 lines, flat (no nesting) |
| `rosetta-source/src/main/java/` | Hand-written Java support — native function implementations |
| `rosetta-source/src/main/resources/ingest/` | Translate pipeline + test-pack config (54 files) |
| `rosetta-source/src/main/resources/functions/` | Function I/O samples — sec-lending, repo-and-bond, business-event, workflow-step, fpml-5-10 (228 files) |
| `rosetta-source/src/main/resources/codelist/` | XML/JSON code lists |
| `tests/` | Cross-cutting test module — ingestion, functions, scheme import |
| `examples/` | Runnable Java samples + legal-agreement samples |
| `python/` | Python distribution — `finos-cdm` on PyPI, Pydantic v2 |
| `docs/` | 47 markdown/mdx docs — the authoritative narrative |
| `website/` | Docusaurus site behind cdm.finos.org |
| `pom.xml` | Modules: `rosetta-source`, `tests`, `examples` |

## The model, layer by layer

Namespaces are organised inner → outer; each layer may import the layers outside it and
must remain usable without its inner layers.

| Layer | Namespace | Types | Enums | Funcs | Lines | Contents |
|---|---|---:|---:|---:|---:|---|
| Base | `cdm.base.*` | 116 | 75 | 90 | 4,478 | date/time, day count, math, static data (party, asset, identifier, code lists) |
| Observable | `cdm.observable.*` | 78 | 37 | 29 | 1,830 | market data, floating rate options (FRO), calculated rates, observation events |
| Product | `cdm.product.*` | 213 | 56 | 188 | 7,093 | economic terms, payouts, schedules, settlement, collateral, product qualification |
| Event | `cdm.event.*` | 105 | 35 | 152 | 5,278 | trade state, business events, primitive instructions, workflow, positions |
| Legal Doc | `cdm.legaldocumentation.*` | 245 | 74 | 5 | 4,038 | master agreements (ISDA/ISLA/ICMA), CSA, transaction supplements |
| Margin | `cdm.margin.schedule` | 3 | 2 | 23 | 878 | margin schedule |
| Ingest | `cdm.ingest.fpml.confirmation.*` | 0 | 0 | 817 | 20,136 | FpML 5.x → CDM translation, function-based |

**Ingest is 46% of the model by line count.** It is a per-FpML-product family of
mapping functions — 44 files, one per product type (swap, swaption, CDS, FX option,
commodity swap, equity option, variance swap, …) plus shared datetime/party/payment/
price-quantity mappers.

## Central abstractions

- **`TradeState`** (`cdm.event.common`) — root type. A trade at a point in its
  lifecycle: the `Trade`, its `State`, `resets`, `transferHistory`, `valuationHistory`.
- **`Trade` extends `TradableProduct`** — product + price + quantity + parties +
  identifiers + `ExecutionDetails` + `ContractDetails`.
- **`EconomicTerms`** (`cdm.product.template`) — the price-forming features: payouts,
  effective/termination dates, provisions (cancelable, extendible, early termination).
- **Payouts** — composable and asset-class-neutral: `InterestRatePayout`,
  `OptionPayout`, `PerformancePayout`, `SettlementPayout`, `FixedPricePayout`,
  `AssetPayout`. There is no `Swaption` type; a swaption is an `OptionPayout` over an
  `InterestRatePayout`.
- **`BusinessEvent`** — a lifecycle event composed from **primitive instructions**
  (`QuantityChangeInstruction`, `PartyChangeInstruction`, `SplitInstruction`,
  `TermsChangeInstruction`, `ContractFormationInstruction`, `ResetInstruction`,
  `TransferInstruction`, …). A partial novation *is* a quantity change plus a contract
  formation — it is not its own type.
- **`WorkflowStep`** (`cdm.event.workflow`) — an event wrapped with timestamps,
  identifiers, message info, proposed/next-event links. This is what DRR consumes.
- **Qualification** — 80 `[qualification Product]` functions and 35
  `[qualification BusinessEvent]` functions infer *what* an object is from *how it is
  populated*, rather than from a declared type tag.

## Embedded logic

The model is not a schema. It carries executable behaviour:

- **666 validation conditions** attached to types.
- **1,304 functions** — day count fractions, schedule generation, business-day
  adjustment, equity performance, cashflow calculation, state transitions.
- **115 qualification functions** for product and event classification.
- **817 ingestion functions** for FpML translation.

All of it is generated into the target languages, so validation and lifecycle logic ship
with the model rather than being re-implemented per firm.

## Generated distributions

| Target | Notes |
|---|---|
| Java | Primary. `org.finos.cdm:cdm-java`, consumed by DRR and all demos |
| Python | `finos-cdm` on PyPI, Python ≥3.11, Pydantic v2 models, `rune.runtime` base |
| TypeScript | Maven profile |
| JSON Schema | Maven profile |
| Excel | Maven profile |

Python function generation is still in progress — the 2026 Technology Architecture WG
roadmap lists "Python generator upgrade to handle functions" for Q1–Q2 2026, so the
Python distribution is currently types-only in practice.

## Release model

Semantic versioning with a published support window (`SCHEDULE26.md`): at most one
Development, one Production and one Maintenance version at a time.

- CDM 5 — Maintenance through Jun 2026, then unsupported
- CDM 6 — Production through Jun 2026, then Maintenance
- CDM 7 — Development through Jun 2026, Production from Jul 2026
- CDM 8 — Development from Jul 2026 ← **this checkout**

The workspace therefore holds a pre-release development line. Anything built on it
should assume the model will still move.

## Toolchain

| Component | Version |
|---|---|
| JDK | 21 required (`[21,22)`), bytecode release 11 |
| Rune DSL | 10.3.0 |
| Rosetta bundle / code generators | 12.6.1 |
| rune-fpml | 3.2.0 |
| Xtext | 2.38.0 |
| Jackson | 2.18.8 |
| Guava | 33.3.1-jre |
| OpenGamma Strata | 1.7.0 (day count / date math) |
| Saxon | 10.6 (code-list transformation) |
| JUnit | 5.9.1 |

CI runs on Codefresh (`codefresh.yml`); the docs site deploys via Netlify.
