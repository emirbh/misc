# JAR sources

Source-code origin for every JAR used by the pilot: the 23 in `vendor/misc/lib/`
plus the 6 Jackson JARs in `vendor/jars/`. 29 total.

Coordinates were read from each JAR's embedded `META-INF/maven/.../pom.properties`.
Repository URLs marked unverified could not be confirmed from the artifact or upstream.

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
| `strata-basics-1.7.0.jar` | https://github.com/OpenGamma/Strata — `modules/basics` | Apache 2.0 |
| `strata-collect-1.7.0.jar` | https://github.com/OpenGamma/Strata — `modules/collect` | Apache 2.0 |
| `joda-time-2.10.14.jar` | https://github.com/JodaOrg/joda-time | Apache 2.0 |
| `joda-beans-2.1.jar` | https://github.com/JodaOrg/joda-beans | Apache 2.0 |
| `joda-convert-2.0.jar` | https://github.com/JodaOrg/joda-convert | Apache 2.0 |
| `org.eclipse.emf.codegen-2.23.0.jar` | https://github.com/eclipse-emf/org.eclipse.emf | EPL 2.0 |
| `org.eclipse.emf.codegen.ecore-2.46.0.jar` | https://github.com/eclipse-emf/org.eclipse.emf | EPL 2.0 |
| `org.eclipse.emf.codegen.ecore.xtext-1.8.0.jar` | Eclipse Xtext/Xcore — not the EMF repo, unverified | EPL 2.0 |
| `jackson-annotations-2.17.1.jar` | https://github.com/FasterXML/jackson-annotations @ `jackson-annotations-2.17.1` | Apache 2.0 |
| `jackson-core-2.17.1.jar` | https://github.com/FasterXML/jackson-core @ `jackson-core-2.17.1` | Apache 2.0 |
| `jackson-databind-2.17.1.jar` | https://github.com/FasterXML/jackson-databind @ `jackson-databind-2.17.1` | Apache 2.0 |
| `jackson-dataformat-csv-2.17.1.jar` | https://github.com/FasterXML/jackson-dataformats-text — `csv/` | Apache 2.0 |
| `jackson-dataformat-xml-2.17.1.jar` | https://github.com/FasterXML/jackson-dataformat-xml @ `jackson-dataformat-xml-2.17.1` | Apache 2.0 |
| `jackson-datatype-jsr310-2.17.1.jar` | https://github.com/FasterXML/jackson-modules-java8 — `datetime/` | Apache 2.0 |

## No public source — ISDA distribution only

| JAR | Source code | License |
|---|---|---|
| `rosetta-source-7.7.0.jar` (`com.regnosys.drr`) | No public repo. `REGnosys/drr` and `finos/drr` both 404. Source = `rosetta-source-<ver>-sources.jar` in the ISDA DRR distribution | ISDA DRR License |
| `rosetta-source-1.42.0.jar` (`org.iso20022`) | No public repo. Its `parent-1.32.0.pom` declares no `<scm>`, no `<licenses>`, and publishes only to `isda-maven` | not declared |
| `rosetta-source-2.1.1.jar` (`com.regnosys.rune-fpml`) | No public repo found — FpML Rune model, same ISDA registry pattern | not declared |

## Notes

- **26 of 29 are buildable internally** from public repos under permissive licences
  (Apache 2.0 / EPL 2.0 / Community Specification 1.0).
- **3 are blocked.** DRR source is available as `rosetta-source-6.42.0-sources.jar` in
  `vendor/misc/drr/drr-distribution-6.42.0/`, but is governed by the ISDA DRR License
  PDFs shipped alongside it. ISO 20022 and rune-fpml ship no sources JAR at all.
- **The three EMF JARs report `-SNAPSHOT`** in their embedded `pom.properties` because
  Eclipse builds them with Tycho, which stamps the build-time version. The real identity
  is the OSGi `Bundle-Version`, and all three are published to Maven Central as clean
  releases at the versions in their filenames. Do not install them as SNAPSHOTs.
- **`finos/rune-dsl` must be built at two tags** — `9.85.1` and `9.83.0` — since the
  JARs are split across both.
