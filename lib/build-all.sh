#!/usr/bin/env bash
# Build every library in src/ and collect the JARs into build/.
# Run from the directory that contains src/. Requires JDK 21 and Maven 3.9+.
# Build only — nothing is deployed.
set -euo pipefail

ROOT="$(pwd)"
SRC="$ROOT/src"
OUT="$ROOT/build"
LOGS="$OUT/logs"
M2="$OUT/.m2"                     # dedicated local repo, so a collected JAR can be proven built here
DRR_SRC="${DRR_SRC:-$SRC/DRR}"

# ---- Preflight: every source directory must exist before anything is built ----
# A directory counts only if it contains pom.xml. For each missing one, print the
# commands that create it, then stop. Re-run once they are all in place.
#   git|<url>|<tag>    jar|<group-path>|<artifact>|<version>    copy|<what>
SOURCES_REPO="${SOURCES_REPO:-https://repo1.maven.org/maven2}"
REQUIRED=(
  "emf-R2_33_0|git|https://github.com/eclipse-emf/org.eclipse.emf.git|R2_33_0"
  "emf-R2_46_0|git|https://github.com/eclipse-emf/org.eclipse.emf.git|R2_46_0"
  "joda-convert|git|https://github.com/JodaOrg/joda-convert.git|v2.0"
  "joda-beans|git|https://github.com/JodaOrg/joda-beans.git|v2.1"
  "joda-time|git|https://github.com/JodaOrg/joda-time.git|v2.10.14"
  "strata|git|https://github.com/OpenGamma/Strata.git|v1.7.0"
  "jackson-annotations|git|https://github.com/FasterXML/jackson-annotations.git|jackson-annotations-2.17.1"
  "jackson-core|git|https://github.com/FasterXML/jackson-core.git|jackson-core-2.17.1"
  "jackson-databind|git|https://github.com/FasterXML/jackson-databind.git|jackson-databind-2.17.1"
  "jackson-dataformat-xml|git|https://github.com/FasterXML/jackson-dataformat-xml.git|jackson-dataformat-xml-2.17.1"
  "jackson-dataformats-text|git|https://github.com/FasterXML/jackson-dataformats-text.git|jackson-dataformats-text-2.17.1"
  "jackson-modules-java8|git|https://github.com/FasterXML/jackson-modules-java8.git|jackson-modules-java8-2.17.1"
  "rune-dsl-9.83.0|git|https://github.com/finos/rune-dsl.git|9.83.0"
  "rune-dsl-9.85.1|git|https://github.com/finos/rune-dsl.git|9.85.1"
  "rune-common|git|https://github.com/finos/rune-common.git|11.121.2"
  "common-domain-model|git|https://github.com/finos/common-domain-model.git|6.23.0"
  "ingest-test-framework|jar|com/regnosys|ingest-test-framework|11.121.2"
  "rune-fpml|jar|com/regnosys/rune-fpml|rosetta-source|2.1.1"
  "DRR|copy|DRR 7.7.0 source tree"
)
MISSING_SRC=0
for entry in "${REQUIRED[@]}"; do
  IFS='|' read -r dir kind a b c <<<"$entry"
  path="$SRC/$dir"; [ "$dir" = DRR ] && path="$DRR_SRC"
  [ -f "$path/pom.xml" ] && continue
  show="${path#"$ROOT"/}"
  MISSING_SRC=$((MISSING_SRC + 1))
  echo "MISSING: $show"
  case $kind in
    git)  echo "  git clone --depth 1 --branch $b $a \"$show\"" ;;
    jar)  base="$SOURCES_REPO/$a/$b/$c"
          echo "  mkdir -p \"$show/src/main/java\" \"$show/src/main/resources\""
          echo "  curl -fsSL $base/$b-$c.pom -o \"$show/pom.xml\""
          echo "  curl -fsSL $base/$b-$c-sources.jar -o \"$show/sources.jar\""
          echo "  unzip -q -o \"$show/sources.jar\" '*.java' -d \"$show/src/main/java\""
          echo "  unzip -q -o \"$show/sources.jar\" -x '*.java' '*.rosetta' 'META-INF/*' -d \"$show/src/main/resources\"" ;;
    copy) echo "  copy the $a into \"$show\"" ;;
  esac
  echo
done
if [ "$MISSING_SRC" -gt 0 ]; then
  echo "Missing source directories: $MISSING_SRC of ${#REQUIRED[@]}."
  echo "Create them with the commands above, then re-run this script."
  exit 1
fi
echo "All ${#REQUIRED[@]} source directories present."

java -version 2>&1 | grep 'version "21' >/dev/null || { echo "JDK 21 required" >&2; exit 1; }
mkdir -p "$OUT" "$LOGS"
rm -f "$OUT"/*.jar

MVN=(mvn -B -ntp -DskipTests "-Dmaven.repo.local=$M2")
NODE_ARGS=()
if [ -n "${ARTIFACTORY_URL:-}" ]; then
  NODE_ARGS=("-Dnode.download.root=$ARTIFACTORY_URL/artifactory/nodejs-dist-remote/"
             "-Dnpm.download.root=$ARTIFACTORY_URL/artifactory/npm-remote/npm/-/")
fi
FAILED=()

build() { # name dir [mvn args...]
  local name=$1 dir=$2; shift 2
  echo "==> $name"
  if [ ! -d "$dir" ]; then echo "FAILED: $name — $dir not found" >&2; FAILED+=("$name"); return 0; fi
  if ! (cd "$dir" && "${MVN[@]}" clean install "$@") >"$LOGS/$name.log" 2>&1; then
    echo "FAILED: $name — see $LOGS/$name.log" >&2; FAILED+=("$name")
  fi
}

# Tycho stamps -SNAPSHOT on EMF bundles; re-install each at its release version.
emf_release() { # repo-dir bundle version
  local jar
  jar=$(ls "$SRC/$1/plugins/$2/target/$2-"*.jar 2>/dev/null | grep -v -- '-sources' | head -1 || true)
  if [ -z "$jar" ]; then echo "FAILED: $2 — no built jar" >&2; FAILED+=("$2"); return 0; fi
  "${MVN[@]}" install:install-file "-Dfile=$jar" -DgroupId=org.eclipse.emf \
    "-DartifactId=$2" "-Dversion=$3" -Dpackaging=jar >>"$LOGS/emf-install.log" 2>&1 \
    || { echo "FAILED: $2 install-file" >&2; FAILED+=("$2"); }
}

# 1. Eclipse EMF
build emf-R2_33_0 "$SRC/emf-R2_33_0" -pl plugins/org.eclipse.emf.codegen -am
build emf-R2_46_0 "$SRC/emf-R2_46_0" -pl plugins/org.eclipse.emf.codegen.ecore,plugins/org.eclipse.emf.codegen.ecore.xtext -am
emf_release emf-R2_33_0 org.eclipse.emf.codegen             2.23.0
emf_release emf-R2_46_0 org.eclipse.emf.codegen.ecore       2.46.0
emf_release emf-R2_46_0 org.eclipse.emf.codegen.ecore.xtext 1.8.0

# 2. Joda and Strata
build joda-convert "$SRC/joda-convert"
build joda-beans   "$SRC/joda-beans"
build joda-time    "$SRC/joda-time"
build strata       "$SRC/strata" -pl modules/basics,modules/collect -am

# 3. Jackson
build jackson-annotations     "$SRC/jackson-annotations"
build jackson-core            "$SRC/jackson-core"
build jackson-databind        "$SRC/jackson-databind"
build jackson-dataformat-xml  "$SRC/jackson-dataformat-xml"
build jackson-dataformat-csv  "$SRC/jackson-dataformats-text" -pl csv -am
build jackson-datatype-jsr310 "$SRC/jackson-modules-java8"    -pl datetime -am

# 4. Rune DSL
build rune-dsl-9.83.0 "$SRC/rune-dsl-9.83.0" ${NODE_ARGS[@]+"${NODE_ARGS[@]}"}
build rune-dsl-9.85.1 "$SRC/rune-dsl-9.85.1" ${NODE_ARGS[@]+"${NODE_ARGS[@]}"}

# 5. Rune Common
build rune-common "$SRC/rune-common"

# 6. Sources-jar builds
build ingest-test-framework "$SRC/ingest-test-framework" -Dcheckstyle.skip
build rune-fpml             "$SRC/rune-fpml"             -Dcheckstyle.skip

# 7. CDM
build cdm "$SRC/common-domain-model" -pl rosetta-source -am

# 8. DRR — needs org.iso20022:rosetta-source:1.42.0, which has no source
build drr "$DRR_SRC" -pl rosetta-source -am
DRR_VERSION=$(sed -n 's:.*<version>\(.*\)</version>.*:\1:p' "$DRR_SRC/pom.xml" 2>/dev/null | head -1)

# Collect. A JAR is taken only if _remote.repositories records a local install —
# anything resolved from a remote repository is reported, not copied.
ARTIFACTS=(
  org.eclipse.emf:org.eclipse.emf.codegen:2.23.0
  org.eclipse.emf:org.eclipse.emf.codegen.ecore:2.46.0
  org.eclipse.emf:org.eclipse.emf.codegen.ecore.xtext:1.8.0
  org.joda:joda-convert:2.0
  org.joda:joda-beans:2.1
  joda-time:joda-time:2.10.14
  com.opengamma.strata:strata-basics:1.7.0
  com.opengamma.strata:strata-collect:1.7.0
  com.fasterxml.jackson.core:jackson-annotations:2.17.1
  com.fasterxml.jackson.core:jackson-core:2.17.1
  com.fasterxml.jackson.core:jackson-databind:2.17.1
  com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.17.1
  com.fasterxml.jackson.dataformat:jackson-dataformat-csv:2.17.1
  com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.17.1
  org.finos.rune:rune-maven-plugin:9.83.0
  org.finos.rune:rune-xcore-plugin-dependencies:9.83.0
  com.regnosys.rosetta:com.regnosys.rosetta.lib:9.83.0
  com.regnosys.rosetta:rosetta-maven-plugin:9.83.0
  org.finos.rune:rune-lang:9.85.1
  org.finos.rune:rune-runtime:9.85.1
  org.finos.rune:rune-generator-api:9.85.1
  com.regnosys.rosetta:com.regnosys.rosetta:9.85.1
  com.regnosys:rosetta-common:11.121.2
  com.regnosys:serialization:11.121.2
  com.regnosys:ingest-test-framework:11.121.2
  com.regnosys.rune-fpml:rosetta-source:2.1.1
  org.finos.cdm:cdm-java:6.23.0
  org.iso20022:rosetta-source:1.42.0
  "com.regnosys.drr:rosetta-source:${DRR_VERSION:-unknown}"
)
MISSING=()
for coord in "${ARTIFACTS[@]}"; do
  IFS=: read -r g a v <<<"$coord"
  dir="$M2/${g//.//}/$a/$v"
  if [ -f "$dir/$a-$v.jar" ] && grep -qxF "$a-$v.jar>=" "$dir/_remote.repositories" 2>/dev/null; then
    cp "$dir/$a-$v.jar" "$OUT/"
  else
    MISSING+=("$coord")
  fi
done

echo
echo "Collected $(( ${#ARTIFACTS[@]} - ${#MISSING[@]} )) of ${#ARTIFACTS[@]} JARs into $OUT"
for m in ${MISSING[@]+"${MISSING[@]}"}; do echo "  missing: $m"; done
for f in ${FAILED[@]+"${FAILED[@]}"};   do echo "  failed build: $f"; done
[ ${#MISSING[@]} -eq 0 ]
