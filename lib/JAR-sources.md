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
| `rosetta-source-2.1.1.jar` (`com.regnosys.rune-fpml`) | No git repo. Source = `rosetta-source-2.1.1-sources.jar` on Maven Central | not declared |
| `ingest-test-framework-11.121.2.jar` (`com.regnosys`) | No git repo — not a module of rune-common 11.121.2. Source = `ingest-test-framework-11.121.2-sources.jar` on Maven Central | Rosetta Licence |

## Clone commands

Tag conventions differ: FINOS repos tag bare (`9.83.0`), Joda and OpenGamma prefix
with `v` (`v2.10.14`), Jackson repeats the artifact name (`jackson-core-2.17.1`).

| Artifact(s) produced | Clone command |
|---|---|
| rune-lang, rune-runtime, rune-generator-api, com.regnosys.rosetta | `git clone --depth 1 --branch 9.85.1 https://github.com/finos/rune-dsl.git rune-dsl-9.85.1` |
| rune-maven-plugin, rune-xcore-plugin-dependencies, com.regnosys.rosetta.lib, rosetta-maven-plugin | `git clone --depth 1 --branch 9.83.0 https://github.com/finos/rune-dsl.git rune-dsl-9.83.0` |
| rosetta-common, serialization | `git clone --depth 1 --branch 11.121.2 https://github.com/finos/rune-common.git` |
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
| org.eclipse.emf.codegen 2.23.0 | `git clone --depth 1 --branch R2_33_0 https://github.com/eclipse-emf/org.eclipse.emf.git emf-R2_33_0` |
| org.eclipse.emf.codegen.ecore 2.46.0, org.eclipse.emf.codegen.ecore.xtext 1.8.0 | `git clone --depth 1 --branch R2_46_0 https://github.com/eclipse-emf/org.eclipse.emf.git emf-R2_46_0` |
| ingest-test-framework 11.121.2 | sources jar: `https://repo1.maven.org/maven2/com/regnosys/ingest-test-framework/11.121.2/ingest-test-framework-11.121.2-sources.jar` |
| rune-fpml rosetta-source 2.1.1 | sources jar: `https://repo1.maven.org/maven2/com/regnosys/rune-fpml/rosetta-source/2.1.1/rosetta-source-2.1.1-sources.jar` |

### Clone everything

[`clone-all.sh`](clone-all.sh) / [`clone-all.ps1`](clone-all.ps1) — run from the directory
that will hold `src/`.

## Build commands and order

Build only. No deploy — publishing is a separate task.

```bash
export JAVA_HOME=$(/usr/libexec/java_home -v 21)
MVN="mvn -B -ntp -DskipTests"
```

### 1. Eclipse EMF (no dependencies — build first)

Two clones, because the three bundles are at different tags. Tag mapping verified
by reading `Bundle-Version` from each tag's MANIFEST.

```bash
cd emf-R2_33_0 && $MVN clean install -pl plugins/org.eclipse.emf.codegen -am
cd ../emf-R2_46_0 && $MVN clean install \
  -pl plugins/org.eclipse.emf.codegen.ecore,plugins/org.eclipse.emf.codegen.ecore.xtext -am
```

EMF builds with Tycho, which stamps `-SNAPSHOT` into the produced Maven metadata.
To land them at the release coordinates the rest of the tree resolves:

```bash
mvn install:install-file -Dfile=<built>.jar -DgroupId=org.eclipse.emf \
  -DartifactId=org.eclipse.emf.codegen -Dversion=2.23.0 -Dpackaging=jar
```

### 2. Joda and Strata

```bash
cd ../joda-convert && $MVN clean install
cd ../joda-beans   && $MVN clean install
cd ../joda-time    && $MVN clean install
cd ../strata       && $MVN clean install -pl modules/basics,modules/collect -am
```

### 3. Jackson

```bash
cd ../jackson-annotations      && $MVN clean install
cd ../jackson-core             && $MVN clean install
cd ../jackson-databind         && $MVN clean install
cd ../jackson-dataformat-xml   && $MVN clean install
cd ../jackson-dataformats-text && $MVN clean install -pl csv -am
cd ../jackson-modules-java8    && $MVN clean install -pl datetime -am
```

### 4. Rune DSL — both tags, sequential

```bash
cd ../rune-dsl-9.83.0 && $MVN clean install \
  -Dnode.download.root=$ARTIFACTORY_URL/artifactory/nodejs-dist-remote/ \
  -Dnpm.download.root=$ARTIFACTORY_URL/artifactory/npm-remote/npm/-/
cd ../rune-dsl-9.85.1 && $MVN clean install \
  -Dnode.download.root=$ARTIFACTORY_URL/artifactory/nodejs-dist-remote/ \
  -Dnpm.download.root=$ARTIFACTORY_URL/artifactory/npm-remote/npm/-/
```

### 5. Rune Common — requires step 4

```bash
cd ../rune-common && $MVN clean install
```

### 6. Sources-jar builds — requires step 5

`src/ingest-test-framework` and `src/rune-fpml` are produced by the clone script from
the Central `-sources.jar` plus the published POM.

```bash
cd ../ingest-test-framework && $MVN clean install -Dcheckstyle.skip
cd ../rune-fpml             && $MVN clean install -Dcheckstyle.skip
```

### 7. CDM — requires step 6

```bash
cd ../common-domain-model && $MVN clean install -pl rosetta-source -am
```

### 8. DRR — requires step 7

DRR 7.7.0 source is copied into `src/DRR`.

```bash
cd ../DRR && $MVN clean install -pl rosetta-source -am
```

### Still unbuildable

| Artifact | Reason |
|---|---|
| `org.iso20022:rosetta-source:1.42.0` | no source tree; `isda-maven` only |

DRR depends on it, so step 8 fails at resolution until it is present in the local repo.

### Build everything

Run from the directory that contains `src/`. Builds every library in the order above
and collects the JARs into `build/`, with per-library logs in `build/logs/`. Uses a
dedicated local repository at `build/.m2`; a JAR is collected only if Maven recorded
it as installed locally, never if it was resolved from a remote repository. DRR source
is `src/DRR`.

[`build-all.sh`](build-all.sh) / [`build-all.ps1`](build-all.ps1)

## Notes

- **28 of 29 have source**: 24 in public git repositories, DRR 7.7.0 copied into
  `src/DRR`, rune-fpml and ingest-test-framework as `-sources.jar` on Maven Central.
- **1 has no source**: `org.iso20022:rosetta-source:1.42.0` (isda-maven only). DRR
  depends on it.
- **The three EMF JARs report `-SNAPSHOT`** in their embedded `pom.properties` because
  Eclipse builds them with Tycho, which stamps the build-time version. The real
  identity is the OSGi `Bundle-Version`. The build scripts re-install each built bundle
  at its release version with `install:install-file`, so nothing lands as a SNAPSHOT.
- **`finos/rune-dsl` must be built at two tags** — `9.85.1` and `9.83.0` — since the
  JARs are split across both.
- **Java 21 is mandatory.** `org.finos.rune.parent` and `cdm-parent` both declare
  `<java.enforced.version>[21,22)</java.enforced.version>` with maven-enforcer.
