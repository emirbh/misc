# Building CDM & DRR Internally

The 23 JARs copied into `drr lib`, grouped into the six units that would be sourced
and built — and the one group where the obstacle is a licence rather than a build.

- **20 of 23 are open source** — Apache 2.0, EPL 2.0, CSL 1.0
- **2 are restricted** — DRR and ISO 20022
- **1 is undeclared** — FpML

---

## The 23, grouped by what you would clone and build

### Group A — Rune DSL toolchain
**8 jars · Apache 2.0 · `github.com/finos/rune-dsl`**

| Jar | Coordinate | Role |
|---|---|---|
| `rune-lang-9.85.1` | `org.finos.rune` | The Rosetta/Rune language itself |
| `rune-runtime-9.85.1` | `org.finos.rune` | Runtime the generated Java targets |
| `rune-generator-api-9.85.1` | `org.finos.rune` | Code-generator SPI |
| `rune-maven-plugin-9.83.0` | `org.finos.rune` | Drives generation in the build |
| `rune-xcore-plugin-dependencies-9.83.0` | `org.finos.rune` | Xcore plugin bundle |
| `com.regnosys.rosetta-9.85.1` | `com.regnosys.rosetta` | Xtext grammar and compiler |
| `com.regnosys.rosetta.lib-9.83.0` | `com.regnosys.rosetta` | Standard library |
| `rosetta-maven-plugin-9.83.0` | `com.regnosys.rosetta` | Legacy generation plugin |

### Group B — Rune Common runtime
**3 jars · Apache 2.0 · `github.com/finos/rune-common`**

| Jar | Coordinate | Role |
|---|---|---|
| `rosetta-common-11.121.2` | `com.regnosys` | Post-processing, validation, hashing — used directly by the pilot |
| `serialization-11.121.2` | `com.regnosys` | JSON and XML object mappers |
| `ingest-test-framework-11.121.2` | `com.regnosys` | Ingestion test harness |

### Group C — CDM
**1 jar · Community Specification License 1.0 · `github.com/finos/common-domain-model`**

| Jar | Coordinate | Role |
|---|---|---|
| `cdm-java-6.23.0` | `org.finos.cdm` | The trade model — 66 MB, generated from CDM's own `.rosetta` sources |

### Group D — Models
**3 jars · two restricted, one undeclared**

| Jar | Coordinate | Licence | Available from |
|---|---|---|---|
| `rosetta-source-7.7.0` | `com.regnosys.drr` | **none declared** | **isda-maven only** |
| `rosetta-source-1.42.0` | `org.iso20022` | **none declared** | **isda-maven only** |
| `rosetta-source-2.1.1` | `com.regnosys.rune-fpml` | none declared | Maven Central |

### Group E — Financial maths
**5 jars · Apache 2.0 · OpenGamma and JodaOrg**

| Jar | Coordinate | Role |
|---|---|---|
| `strata-basics-1.7.0` | `com.opengamma.strata` | Day counts, holiday calendars, schedules |
| `strata-collect-1.7.0` | `com.opengamma.strata` | Collections and result types Strata needs |
| `joda-beans-2.1` | `org.joda` | Bean framework Strata is built on |
| `joda-convert-2.0` | `org.joda` | String conversion for Joda beans |
| `joda-time-2.10.14` | `joda-time` | Date and time |

### Group F — Eclipse EMF code generation
**3 jars · EPL 2.0 · `git.eclipse.org/emf`**

| Jar | Coordinate | Role |
|---|---|---|
| `org.eclipse.emf.codegen-2.23.0` | `org.eclipse.emf` | EMF code generator |
| `org.eclipse.emf.codegen.ecore-2.46.0` | `org.eclipse.emf` | Ecore model to Java |
| `org.eclipse.emf.codegen.ecore.xtext-1.8.0` | `org.eclipse.emf` | Xtext bridge — required by Xcore |

> **Groups E and F are the instructive ones.** They are ordinary open-source artifacts
> on Maven Central, but they had to be copied because they were not already present —
> exactly the failure mode to expect on a curated internal registry. They are also the
> two groups *least* likely to be recognised as ISDA-related by whoever reviews the
> request.

These 23 sit on top of roughly 111 further third-party transitives — most of the 48
Eclipse artifacts, plus Jackson, Guava, Guice, SLF4J — that a Central proxy would
supply. `dependency-manifest.csv` lists all 134 for a bulk availability check.

---

## The finding that decides the plan

Groups A, B, C, E and F all carry explicit licences and public source repositories,
read from their **parent** POMs. The Rune DSL compiler, its runtime, CDM, Strata,
Joda and the EMF codegen jars can all be cloned, built and published to an internal
JFrog with no permission beyond honouring Apache 2.0, EPL 2.0 and the Community
Specification License.

Only **Group D** is a problem, and within it only two artifacts are genuinely blocked.

### The blocker: DRR and ISO 20022 declare no licence and no source

Neither artifact, nor either parent POM, contains a `<licenses>` or `<scm>` block, and
neither JAR carries a LICENSE file. The only URL any of them names is the private
Artifact Registry. They are also the only two of the 134 not on Maven Central.

The contrast with Group A — whose parent POM states Apache 2.0 and points at
`github.com/finos/rune-dsl` — is the point. This metadata is present everywhere it is
meant to be, and absent exactly here.

**Access is contractual, through ISDA DRR participation.** Whether the firm may obtain
source, build it and republish internally is a question for ISDA and Legal. No estimate
for Group D is meaningful until that is answered.

### Adjacent question: the FpML model is available but undeclared

`com.regnosys.rune-fpml:rosetta-source` is on Maven Central, so mirroring it is trivial
— but no POM in its chain names a licence or a repository. Building it from source is
not currently possible and its redistribution terms are unstated. Raise it with Regnosys
alongside DRR.

---

## Build sequence

Each group needs those above it.

### 1. Foundation: EMF codegen, Strata, Joda
*Groups F and E · no ecosystem dependencies*

- Mirror from Central if permitted — these are stock OSS and building them buys nothing.
- If a supply-chain policy forces source builds: Joda and Strata are plain Maven
  projects; EMF is an Eclipse build and considerably more involved.
- Get these approved early — they are the ones a reviewer is least likely to associate
  with the ISDA request.

### 2. Rune DSL toolchain
*Group A · Apache 2.0 · needs F*

- Clone `finos/rune-dsl` at 9.85.1; the Maven plugins sit at 9.83.0, so two tags may be
  needed.
- An Xtext language project — this is what drags in the 48 Eclipse artifacts. Confirm
  availability before starting.
- Everything downstream generates Java with this, so it is published first.

### 3. Rune Common runtime
*Group B · Apache 2.0 · needs A*

- Clone `finos/rune-common` at 11.121.2.
- Supplies `rosetta-common`, which the pilot calls directly for post-processing and
  report validation.

### 4. CDM
*Group C · CSL 1.0 · needs A and B*

- Clone `finos/common-domain-model` at 6.23.0.
- Generation produces most of the 66 MB jar — expect a long build and high memory.
- Reconcile against the Central artifact by comparing generated class inventories before
  trusting the result.

### 5. DRR and ISO 20022 — blocked pending ISDA
*Group D · licence unresolved · needs everything above*

- Source location unknown; not declared anywhere in the artifacts.
- DRR depends on CDM, ISO 20022, FpML and the Rune toolchain, so it builds last
  regardless of the licensing outcome.
- Its 506 `.rosetta` rule files ship inside the JAR — an observation about contents, not
  permission to use them that way.
- Budget for a standing maintainer: DRR releases track regulatory deadlines, so falling
  behind is a compliance exposure, not just technical drift.

---

## Recommendation: mirror what you can, build only what you must

### Do this — proxy Central, mirror Group D

- JFrog **remote** repo proxying Maven Central covers Groups A, B, C, E, F and all 111
  further transitives.
- JFrog **local** repo for the two restricted artifacts, plus FpML if you prefer to pin it.
- **Virtual** repo combining both; distribute a `settings.xml` mirror scoped
  `external:*` so a project-local `file://` repo is not swallowed.
- Days of work. No generation, no Xtext version risk, and the binaries match what ISDA
  tests against.

### Only if policy demands it — build Groups A–C from source

- All three are open with public repositories — genuinely achievable.
- Buys reproducibility and the ability to patch; costs a standing commitment across three
  repositories whose versions move together.
- Does nothing for Group D, which is the actual constraint.

---

## Open questions — need an answer from outside engineering

**Under what terms is `com.regnosys.drr` licensed to us?**
Not stated in any artifact. Request in writing from ISDA, along with whether source
access is available and at what cost.

**May we mirror ISDA's binaries into internal JFrog?**
The cheapest path by a wide margin. Worth asking before scoping any source build.

**What licence governs `com.regnosys.rune-fpml`?**
On Central, so available — but undeclared terms and no public repository. Ask Regnosys
with the DRR question.

**Does our JFrog proxy Central, or curate it?**
Decides whether Groups A, B, C, E and F are free or are 132 approval items. Groups E and
F had to be hand-copied already, which suggests curation.

---

## How this was verified

Licences and source locations were read from the artifacts' **parent** POMs in the local
Maven cache — the leaf POMs declare none of it, which is why a first look suggests the
whole stack is undocumented. Provenance came from each artifact's `_remote.repositories`
record; there is no `settings.xml` on this machine and no mirror configured, so "central"
means Maven Central itself rather than a proxy. The dependency set was confirmed with
`mvn dependency:list` and carries no SNAPSHOT versions on the compile classpath.

**Two corrections to earlier drafts of this document.** The grouping previously covered
only 17 artifacts, because it bucketed on the `com.regnosys`, `org.finos` and
`org.iso20022` group IDs and so omitted the Joda and Eclipse EMF codegen jars — they are
on the compile classpath and are part of the 23. And CDM is licensed under the Community
Specification License 1.0 per its parent POM, not the ISDA CDM License 2.0; the 2.0 text
inside the JAR at `documents/license-terms.md` is legacy content from an earlier release.
