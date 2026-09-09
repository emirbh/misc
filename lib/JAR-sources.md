# JAR sources

Source-code origin for every JAR used by the pilot: the 23 in `misc/lib/` plus the
6 Jackson JARs in `vendor/jars/`. 29 total.

Coordinates were read from each JAR's embedded `META-INF/maven/.../pom.properties`.
Every git tag below was verified against the GitHub refs API
(`/repos/{owner}/{repo}/git/ref/tags/{tag}`) — all 14 return 200.

## Buildable from public source

| JAR | Source code | License |
|---|---|---|
| `cdm-java-6.23.0.jar` | https://github.com/finos/common-domain-model @ `6.23.0` | Community Specification 1.0 |
| `rune-lang-9.85.1.jar` | https://github.com/finos/rune-dsl @ `9.85.1` | Apache 2.0 |
| `rune-runtime-9.85.1.jar` | https://github.com/finos/rune-dsl @ `9.85.1` | Apache 2.0 |
| `rune-generator-api-9.85.1.jar` | https://github.com/finos/rune-dsl @ `9.85.1` | Apache 2.0 |
| `rune-maven-plugin-9.83.0.jar` | https://github.com/finos/rune-dsl @ `9.83.0` | Apache 2.0 |
| `rune-xcore-plugin-dependencies-9.83.0.jar` | https://github.com/finos/rune-dsl @ `9.83.0` | Apache 2.0 |
| `com.regnosys.rosetta-9.85.1.jar` | https://github.com/finos/rune-dsl @ `9.85.1` — pre-rename coordinate | Apache 2.0 |
| `com.regnosys.rosetta.lib-9.83.0.jar` | https://github.com/finos/rune-dsl @ `9.83.0` — pre-rename | Apache 2.0 |
| `rosetta-maven-plugin-9.83.0.jar` | https://github.com/finos/rune-dsl @ `9.83.0` — pre-rename | Apache 2.0 |
| `rosetta-common-11.121.2.jar` | https://github.com/finos/rune-common @ `11.121.2` | Apache 2.0 |
| `serialization-11.121.2.jar` | https://github.com/finos/rune-common @ `11.121.2` | Apache 2.0 |
| `ingest-test-framework-11.121.2.jar` | https://github.com/finos/rune-common @ `11.121.2` | Apache 2.0 |
| `strata-basics-1.7.0.jar` | https://github.com/OpenGamma/Strata @ `v1.7.0` — `modules/basics` | Apache 2.0 |
| `strata-collect-1.7.0.jar` | https://github.com/OpenGamma/Strata @ `v1.7.0` — `modules/collect` | Apache 2.0 |
| `joda-time-2.10.14.jar` | https://github.com/JodaOrg/joda-time @ `v2.10.14` | Apache 2.0 |
| `joda-beans-2.1.jar` | https://github.com/JodaOrg/joda-beans @ `v2.1` | Apache 2.0 |
| `joda-convert-2.0.jar` | https://github.com/JodaOrg/joda-convert @ `v2.0` | Apache 2.0 |
| `org.eclipse.emf.codegen-2.23.0.jar` | https://github.com/eclipse-emf/org.eclipse.emf | EPL 2.0 |
| `org.eclipse.emf.codegen.ecore-2.46.0.jar` | https://github.com/eclipse-emf/org.eclipse.emf | EPL 2.0 |
| `org.eclipse.emf.codegen.ecore.xtext-1.8.0.jar` | Eclipse Xtext/Xcore — not the EMF repo, unverified | EPL 2.0 |
| `jackson-annotations-2.17.1.jar` | https://github.com/FasterXML/jackson-annotations @ `jackson-annotations-2.17.1` | Apache 2.0 |
| `jackson-core-2.17.1.jar` | https://github.com/FasterXML/jackson-core @ `jackson-core-2.17.1` | Apache 2.0 |
| `jackson-databind-2.17.1.jar` | https://github.com/FasterXML/jackson-databind @ `jackson-databind-2.17.1` | Apache 2.0 |
| `jackson-dataformat-csv-2.17.1.jar` | https://github.com/FasterXML/jackson-dataformats-text @ `jackson-dataformats-text-2.17.1` — `csv/` | Apache 2.0 |
| `jackson-dataformat-xml-2.17.1.jar` | https://github.com/FasterXML/jackson-dataformat-xml @ `jackson-dataformat-xml-2.17.1` | Apache 2.0 |
| `jackson-datatype-jsr310-2.17.1.jar` | https://github.com/FasterXML/jackson-modules-java8 @ `jackson-modules-java8-2.17.1` — `datetime/` | Apache 2.0 |

## No public source — ISDA distribution only

| JAR | Source code | License |
|---|---|---|
| `rosetta-source-7.7.0.jar` (`com.regnosys.drr`) | No public repo. `REGnosys/drr` and `finos/drr` both 404. Source = `rosetta-source-<ver>-sources.jar` in the ISDA DRR distribution | ISDA DRR License |
| `rosetta-source-1.42.0.jar` (`org.iso20022`) | No public repo. Its `parent-1.32.0.pom` declares no `<scm>`, no `<licenses>`, and publishes only to `isda-maven` | not declared |
| `rosetta-source-2.1.1.jar` (`com.regnosys.rune-fpml`) | No public repo found — FpML Rune model, same ISDA registry pattern | not declared |

## Clone commands

Tag conventions differ: FINOS repos tag bare (`9.83.0`), Joda and OpenGamma prefix
with `v` (`v2.10.14`), Jackson repeats the artifact name (`jackson-core-2.17.1`).

| Artifact(s) produced | Clone command |
|---|---|
| rune-lang, rune-runtime, rune-generator-api, com.regnosys.rosetta | `git clone --depth 1 --branch 9.85.1 https://github.com/finos/rune-dsl.git rune-dsl-9.85.1` |
| rune-maven-plugin, rune-xcore-plugin-dependencies, com.regnosys.rosetta.lib, rosetta-maven-plugin | `git clone --depth 1 --branch 9.83.0 https://github.com/finos/rune-dsl.git rune-dsl-9.83.0` |
| rosetta-common, serialization, ingest-test-framework | `git clone --depth 1 --branch 11.121.2 https://github.com/finos/rune-common.git` |
| cdm-java | `git clone --depth 1 --branch 6.23.0 https://github.com/finos/common-domain-model.git` |
| jackson-core | `git clone --depth 1 --branch jackson-core-2.17.1 https://github.com/FasterXML/jackson-core.git` |
| jackson-annotations | `git clone --depth 1 --branch jackson-annotations-2.17.1 https://github.com/FasterXML/jackson-annotations.git` |
| jackson-databind | `git clone --depth 1 --branch jackson-databind-2.17.1 https://github.com/FasterXML/jackson-databind.git` |
| jackson-dataformat-xml | `git clone --depth 1 --branch jackson-dataformat-xml-2.17.1 https://github.com/FasterXML/jackson-dataformat-xml.git` |
| jackson-dataformat-csv (module `csv`) | `git clone --depth 1 --branch jackson-dataformats-text-2.17.1 https://github.com/FasterXML/jackson-dataformats-text.git` |
| jackson-datatype-jsr310 (module `datetime`) | `git clone --depth 1 --branch jackson-modules-java8-2.17.1 https://github.com/FasterXML/jackson-modules-java8.git` |
| joda-time | `git clone --depth 1 --branch v2.10.14 https://github.com/JodaOrg/joda-time.git` |
| joda-convert | `git clone --depth 1 --branch v2.0 https://github.com/JodaOrg/joda-convert.git` |
| joda-beans | `git clone --depth 1 --branch v2.1 https://github.com/JodaOrg/joda-beans.git` |
| strata-basics, strata-collect (modules `modules/basics`, `modules/collect`) | `git clone --depth 1 --branch v1.7.0 https://github.com/OpenGamma/Strata.git` |

### Clone everything

```bash
#!/usr/bin/env bash
set -euo pipefail
mkdir -p src && cd src

clone() { # url tag dir
  echo "==> $3 @ $2"
  git clone --depth 1 --branch "$2" "$1" "$3"
}

clone https://github.com/finos/rune-dsl.git                        9.83.0                          rune-dsl-9.83.0
clone https://github.com/finos/rune-dsl.git                        9.85.1                          rune-dsl-9.85.1
clone https://github.com/finos/rune-common.git                     11.121.2                        rune-common
clone https://github.com/finos/common-domain-model.git             6.23.0                          common-domain-model
clone https://github.com/FasterXML/jackson-core.git                jackson-core-2.17.1             jackson-core
clone https://github.com/FasterXML/jackson-annotations.git         jackson-annotations-2.17.1      jackson-annotations
clone https://github.com/FasterXML/jackson-databind.git            jackson-databind-2.17.1         jackson-databind
clone https://github.com/FasterXML/jackson-dataformat-xml.git      jackson-dataformat-xml-2.17.1   jackson-dataformat-xml
clone https://github.com/FasterXML/jackson-dataformats-text.git    jackson-dataformats-text-2.17.1 jackson-dataformats-text
clone https://github.com/FasterXML/jackson-modules-java8.git       jackson-modules-java8-2.17.1    jackson-modules-java8
clone https://github.com/JodaOrg/joda-time.git                     v2.10.14                        joda-time
clone https://github.com/JodaOrg/joda-convert.git                  v2.0                            joda-convert
clone https://github.com/JodaOrg/joda-beans.git                    v2.1                            joda-beans
clone https://github.com/OpenGamma/Strata.git                      v1.7.0                          strata
```

## Notes

- **26 of 29 are buildable internally** under Apache 2.0 / EPL 2.0 / Community
  Specification 1.0.
- **3 are blocked.** DRR source ships as `rosetta-source-<ver>-sources.jar` in the
  ISDA DRR distribution, governed by the ISDA DRR License PDFs beside it. ISO 20022
  and rune-fpml ship no sources JAR at all. rune-fpml is a CDM dependency, so it
  blocks the CDM build too.
- **The three EMF JARs report `-SNAPSHOT`** in their embedded `pom.properties` because
  Eclipse builds them with Tycho, which stamps the build-time version. The real
  identity is the OSGi `Bundle-Version`, and all three are published to Maven Central
  as clean releases at the versions in their filenames. Proxy them; do not rebuild,
  and do not install them as SNAPSHOTs.
- **`finos/rune-dsl` must be built at two tags** — `9.85.1` and `9.83.0` — since the
  JARs are split across both.
- **Java 21 is mandatory.** `org.finos.rune.parent` and `cdm-parent` both declare
  `<java.enforced.version>[21,22)</java.enforced.version>` with maven-enforcer.
