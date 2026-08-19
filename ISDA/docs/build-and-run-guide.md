# CDM/DRR Swap Trade Mapper — Build and Run Guide

## Overview

This project takes internal swap trade data in a JSON format, models it using the FINOS Common Domain Model (CDM 5.29.0), and generates regulatory reports via ISDA's Digital Regulatory Reporting (DRR 5.20.1) for multiple regimes, then projects those reports to submission formats (ISO 20022 XML, DTCC RDS).

```mermaid
flowchart LR
    A[Internal JSON] --> B[CDM TradeState]
    B --> C[WorkflowStep]
    C --> D[ReportableEvent]
    D --> E[TransactionReportInstruction]
    E --> F[Regime Reports]
    F --> G[Submission XML/JSON]
```

---

## Phase Summary

| Phase | Goal | Input | Output | Key Class |
|-------|------|-------|--------|-----------|
| 1 | Define input format | — | JSON schema + sample files | `data/schema/swap-trade.json` |
| 2 | Map to CDM TradeState | `SwapTrade` JSON | CDM `TradeState` JSON | `TradeStateMapper` |
| 3 | Wrap in WorkflowStep | `TradeState` + metadata | CDM `WorkflowStep` JSON | `WorkflowStepMapper` |
| 4 | Create ReportableEvent | `WorkflowStep` + reporting info | DRR `ReportableEvent` JSON | `ReportableEventMapper` |
| 5 | Create report instruction | `ReportableEvent` | DRR `TransactionReportInstruction` JSON | `ReportInstructionMapper` |
| 6 | Generate regime reports | `TransactionReportInstruction` | Per-regime report JSON | `ReportGenerator` |
| 7 | Project to submission format | Regime reports | ISO 20022 XML / DTCC RDS JSON | `ProjectionMapper` |

---

## Phase Details

### Phase 1 — Input Data Model

**Goal**: Define a JSON schema that captures all internal swap trade fields and create sample input files covering the key product types and lifecycle events.

**Process**: The schema defines 23 product types, 6 action types (NEWT, MODI, CORR, EROR, TERM, REVI), and 5 event types (TRAD, NOVA, ETRM, ALOC, COMP). Each trade carries party information (LEI + name), notional, rate, frequency, dates, and optional sections for FX, options, cap/floor, inflation, and novation.

**Files produced**:

| File | Description |
|------|-------------|
| `data/schema/swap-trade.json` | JSON Schema for the internal format |
| `data/schema/field-mapping.md` | Field-by-field mapping to CDM paths |
| `data/input/vanilla-swap-new.json` | NEWT/TRAD — USD 50M, 3.25% vs SOFR 3M |
| `data/input/vanilla-swap-modi.json` | MODI/TRAD — notional amended to 75M |
| `data/input/vanilla-swap-novation.json` | NEWT/NOVA — stepping in Zeta Partners |
| `data/input/vanilla-swap-etrm.json` | NEWT/ETRM — early termination |
| `data/input/ois-new.json` | NEWT/TRAD — USD 100M, 4.10% vs SOFR 1D |
| `data/input/fra-new.json` | NEWT/TRAD — EUR 25M, 2.85% vs EURIBOR 6M |
| `data/input/swaption-new.json` | NEWT/TRAD — USD 30M, European swaption |
| `data/input/fx-swap-new.json` | NEWT/TRAD — EUR/USD near/far |
| `data/input/cap-floor-new.json` | NEWT/TRAD — USD 20M, 5.00% cap on SOFR 3M |

### Phase 2 — CDM TradeState Mapping

**Goal**: Parse internal JSON into a `SwapTrade` POJO, then build a CDM 5.29.0 `TradeState` with the correct product structure.

**Process**:
1. `SwapTradeReader` deserialises the input JSON using Jackson (with `JavaTimeModule`).
2. `TradeStateMapper.map()` dispatches on `productType` to a product-specific mapper (currently `VanillaSwapMapper` for all types as a baseline).
3. The mapper builds:
   - `ContractualProduct` with ISDA taxonomy and `EconomicTerms` containing fixed + floating `InterestRatePayout` legs inside a `Payout` object.
   - `TradeLot` with `PriceQuantity` for the notional.
   - `Counterparty` list (PARTY_1, PARTY_2).
   - `Trade` with `tradeIdentifier` (UTI), `tradeDate`, `executionDetails`, `contractDetails`.
   - Wrapping `TradeState` with the `Trade`.

**Key CDM 5 path**: `tradeState.trade.tradableProduct.product.contractualProduct.economicTerms.payout.interestRatePayout[]`

**Input**: `SwapTrade` (in-memory POJO from Phase 1 JSON)

**Output**: `data/output/tradestate/{name}_TradeState.json`

### Phase 3 — WorkflowStep

**Goal**: Wrap the `TradeState` in a CDM `WorkflowStep` that carries the correct `ActionEnum`, `EventIntentEnum`, and lifecycle `PrimitiveInstruction`.

**Process**:
1. `actionType` → `ActionEnum`: NEWT→New, MODI/CORR/REVI→Correct, EROR→Cancel, TERM→New
2. `eventType` → `EventIntentEnum`: TRAD→ContractFormation, NOVA→Novation, ETRM→EarlyTerminationProvision, ALOC→Allocation, COMP→Compression
3. `buildInstruction()` creates the appropriate `PrimitiveInstruction`:
   - ContractFormation: `ContractFormationInstruction` + `execution` (the TradableProduct)
   - Novation: `SplitInstruction` with quantity-to-zero + party change
   - Early Termination / Compression: `QuantityChangeInstruction` with REPLACE to zero
   - Allocation: `SplitInstruction` with ContractFormation breakdown

**Input**: `SwapTrade` + `TradeState`

**Output**: `data/output/workflowstep/{name}_WorkflowStep.json`

### Phase 4 — ReportableEvent

**Goal**: Create a DRR `ReportableEvent` that enriches the `WorkflowStep` with reporting-specific metadata that CDM does not carry.

**Process**:
1. Sets `originatingWorkflowStep`, `reportableTrade`, and `reportableInformation`.
2. `ReportableInformation` includes:
   - `confirmationMethod` (ELECTRONIC / NON_ELECTRONIC)
   - `executionVenueType` (OFF_FACILITY / SEF)
   - `largeSizeTrade` (false)
   - Two `PartyInformation` entries (Party1 as REPORTING_PARTY, Party2 as AS_COUNTERPARTY)
   - `ReportingRegime` with supervisory body (CFTC) and mandatorily-clearable status

**Input**: `SwapTrade` + `WorkflowStep` + `TradeState`

**Output**: `data/output/reportableevent/{name}_ReportableEvent.json`

### Phase 5 — TransactionReportInstruction

**Goal**: Use DRR's `Create_TransactionReportInstruction` function to enrich the report instruction with regulatory static data (UPI, UTI lookup, LEI validation).

**Process**:
1. `ReportInstructionMapper` is Guice-injected with DRR's `Create_TransactionReportInstruction` and `ExtractTradeCounterparty` functions.
2. Builds a `ReportingSide` (Party1 = reporting party, Party2 = counterparty).
3. Calls `createInstruction.evaluate(reportableEvent, reportingSide)` — the DRR engine applies its translate + enrich steps.

**Input**: `ReportableEvent`

**Output**: `data/output/instruction/{name}_TransactionReportInstruction.json`

### Phase 6 — Regime Report Generation

**Goal**: Run DRR report functions for each regulatory regime against the enriched instruction.

**Process**: `ReportGenerator` obtains these Guice-injected report functions and calls `evaluate()` on each:

| Regime | Report Function | Output Type |
|--------|----------------|-------------|
| CFTC Part 45 | `CFTCPart45ReportFunction` | `CFTCPart45TransactionReport` |
| CFTC Part 43 | `CFTCPart43ReportFunction` | `CFTCPart43TransactionReport` |
| ESMA EMIR | `ESMAEMIRTradeReportFunction` | `ESMAEMIRTransactionReport` |
| FCA UK EMIR | `FCAUKEMIRTradeReportFunction` | `FCAUKEMIRTransactionReport` |

Each report is serialised to JSON using `RosettaObjectMapper`.

**Input**: `TransactionReportInstruction`

**Output**: `data/output/reports/{name}_{regime}_Report.json`

### Phase 7 — Projection to Submission Format

**Goal**: Project regime reports to the format expected by trade repositories — ISO 20022 XML for European regimes, DTCC RDS Harmonized for US.

**Process**: `ProjectionMapper` calls DRR projection functions:

| Regime | Projection Function | Output Format |
|--------|---------------------|---------------|
| ESMA EMIR | `Project_EsmaEmirTradeReportToIso20022` | ISO 20022 Auth030 XML |
| FCA UK EMIR | `Project_FcaUkEmirTradeReportToIso20022` | ISO 20022 Auth030 XML |
| CFTC Part 45 | `Project_CftcPart45TradeReportToDtccRdsHarmonized` | DTCC RDS JSON |
| CFTC Part 43 | `Project_CftcPart43TradeReportToDtccRdsHarmonized` | DTCC RDS JSON |

ISO 20022 output uses `RosettaObjectMapperCreator.forXML()` with the regime-specific Auth030 model config. DTCC RDS output is serialised via `RosettaObjectMapper` to JSON.

**Input**: Map of regime → report object

**Output**: `data/output/projections/{name}_{regime}_Projection.xml` (or `.json`)

---

## Prerequisites

### System Requirements

| Requirement | Version | Notes |
|-------------|---------|-------|
| JDK | 21+ | Required by DRR runtime; bytecode targets Java 11 |
| Apache Maven | 3.8+ | Build tool |
| Google Cloud CLI (`gcloud`) | latest | For ISDA artifact registry authentication |
| Git | 2.x | For submodule management |

### Install JDK 21

```bash
brew install openjdk@21
export JAVA_HOME=$(/usr/libexec/java_home -v 21)
```

Verify:

```bash
java -version
```

### Install Maven

```bash
brew install maven
```

### Install Google Cloud CLI

```bash
brew install google-cloud-sdk
```

### Authenticate with ISDA Artifact Registry

DRR artifacts are hosted on Google Artifact Registry. You need credentials to resolve Maven dependencies.

```bash
gcloud auth application-default login
```

This stores Application Default Credentials (ADC) that the `artifactregistry-maven-wagon` extension reads automatically.

If you have a service account key instead:

```bash
export GOOGLE_APPLICATION_CREDENTIALS=/path/to/service-account-key.json
```

---

## Project Structure

| Path | Description |
|------|-------------|
| `data/schema/swap-trade.json` | JSON Schema for internal trade format |
| `data/schema/field-mapping.md` | Field mapping table (internal → CDM) |
| `data/input/*.json` | Sample input trade files |
| `data/output/` | All generated output (created at runtime) |
| `isda-cdm-trade-mapper/pom.xml` | Maven project descriptor |
| `isda-cdm-trade-mapper/src/main/java/org/isda/mapper/` | All mapper source code |

### Source Files

| File | Phase | Purpose |
|------|-------|---------|
| `SwapTrade.java` | 1 | Internal trade POJO |
| `SwapTradeReader.java` | 1 | JSON deserialiser |
| `TradeStateMapper.java` | 2 | Dispatches to product mappers, builds CDM TradeState |
| `product/VanillaSwapMapper.java` | 2 | Builds CDM ContractualProduct for IRS |
| `util/CdmBuilderUtil.java` | 2 | Shared CDM builder helpers |
| `WorkflowStepMapper.java` | 3 | Creates WorkflowStep with action/intent/instruction |
| `ReportableEventMapper.java` | 4 | Adds DRR reporting metadata |
| `ReportInstructionMapper.java` | 5 | DRR enrichment via Guice-injected functions |
| `ReportGenerator.java` | 6 | Runs regime-specific report functions |
| `ProjectionMapper.java` | 7 | Projects reports to ISO 20022 / DTCC RDS |
| `MapperMain.java` | all | CLI entry point chaining all 7 phases |

---

## Build

```bash
cd isda-cdm-trade-mapper
mvn clean compile
```

This will:
1. Download DRR 5.20.1 and its transitive dependency CDM 5.29.0 from ISDA's Artifact Registry.
2. Download the ISO 20022 model JAR (`org.iso20022:rosetta-source`).
3. Compile all mapper source files.

If you see authentication errors, ensure `gcloud auth application-default login` has been run.

### Package

```bash
mvn clean package -DskipTests
```

This creates `target/isda-cdm-trade-mapper-1.0-SNAPSHOT.jar`.

---

## Run

### From Maven

```bash
mvn exec:java -Dexec.mainClass=org.isda.mapper.MapperMain
```

### From JAR

```bash
java -cp "target/isda-cdm-trade-mapper-1.0-SNAPSHOT.jar:target/dependency/*" \
     org.isda.mapper.MapperMain
```

To include all dependencies in the classpath, first run:

```bash
mvn dependency:copy-dependencies -DoutputDirectory=target/dependency
```

---

## Viewing Results

After a successful run, output is organised under `data/output/`:

```
data/output/
├── tradestate/          # Phase 2 — CDM TradeState JSON
├── workflowstep/        # Phase 3 — CDM WorkflowStep JSON
├── reportableevent/     # Phase 4 — DRR ReportableEvent JSON
├── instruction/         # Phase 5 — TransactionReportInstruction JSON
├── reports/             # Phase 6 — Regime-specific report JSON
└── projections/         # Phase 7 — ISO 20022 XML / DTCC RDS JSON
```

### Example output for `vanilla-swap-new.json`

| File | Format | Contents |
|------|--------|----------|
| `tradestate/vanilla-swap-new_TradeState.json` | JSON | CDM TradeState with fixed/float payout, parties, identifiers |
| `workflowstep/vanilla-swap-new_WorkflowStep.json` | JSON | WorkflowStep with ACTION=NEW, INTENT=CONTRACT_FORMATION |
| `reportableevent/vanilla-swap-new_ReportableEvent.json` | JSON | ReportableEvent with CFTC regime, party roles |
| `instruction/vanilla-swap-new_TransactionReportInstruction.json` | JSON | Enriched instruction with UPI, validated LEIs |
| `reports/vanilla-swap-new_CFTCPart45_Report.json` | JSON | CFTC Part 45 transaction report fields |
| `reports/vanilla-swap-new_ESMA_EMIR_Report.json` | JSON | ESMA EMIR REFIT report fields |
| `projections/vanilla-swap-new_ESMA_EMIR_Projection.xml` | XML | ISO 20022 Auth.030 submission-ready XML |
| `projections/vanilla-swap-new_CFTCPart45_Projection.json` | JSON | DTCC RDS Harmonized submission format |

### Inspecting JSON output

All JSON output uses the Rosetta serialisation format (CDM-canonical). Open with any JSON viewer or use `jq`:

```bash
jq '.trade.tradableProduct.product.contractualProduct.economicTerms.payout' \
   data/output/tradestate/vanilla-swap-new_TradeState.json
```

### Inspecting XML output

ISO 20022 projections are standard Auth.030 XML. Open in any XML editor or browser:

```bash
xmllint --format data/output/projections/vanilla-swap-new_ESMA_EMIR_Projection.xml
```

---

## Adding New Trades

1. Create a new JSON file in `data/input/` following the schema in `data/schema/swap-trade.json`.
2. Re-run the pipeline — the new file is picked up automatically.

Required fields: `tradeId`, `tradeVersion`, `actionType`, `eventType`, `productType`, `tradeDate`, `effectiveDate`, `maturityDate`, `notionalAmount`, `notionalCurrency`, `party1`, `party2`.

---

## Extending

### New product types

1. Create a new mapper in `src/main/java/org/isda/mapper/product/` (e.g., `SwaptionMapper.java`).
2. Update the `switch` in `TradeStateMapper.mapProduct()` to route the product type.

### New regimes

1. Add the report function to `ReportGenerator` (inject + evaluate).
2. Add the projection function to `ProjectionMapper`.

### Multi-regime ReportableEvent

Currently `ReportableEventMapper` hardcodes `SupervisoryBodyEnum.CFTC`. To support multiple regimes per trade, parameterise `buildRegimeInfo()` to accept a list of supervisory bodies.

---

## Dependencies

| Artifact | Version | Source |
|----------|---------|--------|
| `com.regnosys.drr:rosetta-source` | 5.20.1 | ISDA Artifact Registry |
| CDM (transitive) | 5.29.0 | via DRR |
| `org.iso20022:rosetta-source` (transitive) | 1.32.0 | via DRR |
| Jackson Databind | 2.17.1 | Maven Central |
| Jackson JSR310 | 2.17.1 | Maven Central |
| Google Guice (transitive) | via DRR | — |
| JUnit Jupiter | 5.9.1 | Maven Central (test only) |

---

## Troubleshooting

| Problem | Fix |
|---------|-----|
| `401 Unauthorized` on Maven build | Run `gcloud auth application-default login` |
| `ClassNotFoundException: DrrRuntimeModule` | Ensure `rosetta-source:5.20.1` resolved; check `mvn dependency:tree` |
| `NoSuchMethodError` at runtime | Verify JDK 21+; DRR bytecode requires it |
| Empty `data/output/` directories | Ensure `data/input/` has `.json` files and you run from the project root |
| Regime report `evaluate()` throws | Check that `ReportableEvent` has correct `reportableInformation` (party roles, supervisory body) |
