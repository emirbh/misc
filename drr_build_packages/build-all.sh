#!/usr/bin/env bash
# Build every library in src/ and collect the JARs into build/.
# Run from the directory that contains src/. Requires JDK 21 and Maven 3.9+.
# Build only — nothing is deployed.
#
#   src/    source only; never written to by this script
#   temp/   everything the build regenerates: work/ (the copy of src/ that is
#           built), m2/ (local Maven repository), logs/, poms/, toolchains.xml.
#           Delete it to remove all build byproducts.
#   build/  the collected JARs
set -euo pipefail

ROOT="$(pwd)"
SRC="$ROOT/src"
OUT="$ROOT/build"
TEMP="$ROOT/temp"
WORK="$TEMP/work"
LOGS="$TEMP/logs"
M2="$TEMP/m2"                     # dedicated local repo, so a collected JAR can be proven built here
DRR_SRC="${DRR_SRC:-$SRC/DRR}"

# ---- Preflight: every source directory must exist before anything is built ----
# A directory counts only if it contains pom.xml. For each missing one, print the
# commands that create it, then stop. Re-run once they are all in place.
#   git|<url>|<tag>    copy|<what>
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
  "rune-common-11.124.2|git|https://github.com/finos/rune-common.git|11.124.2"
  "common-domain-model|git|https://github.com/finos/common-domain-model.git|6.23.0"
  "rune-fpml|copy|rune-fpml rosetta-source 2.1.1 source (pom.xml + sources)"
  "iso20022|copy|iso20022 rosetta-source 1.42.0 source (pom.xml + sources)"
  "DRR|copy|DRR 7.7.0 source tree"
)
MISSING_SRC=0
for entry in "${REQUIRED[@]}"; do
  IFS='|' read -r dir kind a b <<<"$entry"
  path="$SRC/$dir"; [ "$dir" = DRR ] && path="$DRR_SRC"
  [ -f "$path/pom.xml" ] && continue
  show="${path#"$ROOT"/}"
  MISSING_SRC=$((MISSING_SRC + 1))
  echo "MISSING: $show"
  case $kind in
    git)  echo "  git clone --depth 1 --branch $b $a \"$show\"" ;;
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

# Build a copy, so no build output, generated code or build-applied edit
# (versions, POM fixes) ever lands in src/. Mirrors src/ into temp/work/.
mirror() { # from to
  mkdir -p "$2"
  if command -v rsync >/dev/null 2>&1; then
    rsync -a --delete "$1"/ "$2"/
  else
    rm -rf "$2" && mkdir -p "$2" && cp -R "$1"/. "$2"/
  fi
}
echo "==> copying src/ to temp/work/"
mirror "$SRC" "$WORK"
if [ "$DRR_SRC" != "$SRC/DRR" ]; then mirror "$DRR_SRC" "$WORK/DRR"; fi
SRC="$WORK"
DRR_SRC="$WORK/DRR"

# Only JARs are built: no javadoc, sources or signature artifacts.
MVN=(mvn -B -ntp -DskipTests -Dmaven.javadoc.skip=true -Dmaven.source.skip=true -Dgpg.skip=true "-Dmaven.repo.local=$M2")
FAILED=()

# EMF compiles through a Maven toolchain; point it at the JDK running this build.
JDK_HOME=$(java -XshowSettings:properties -version 2>&1 | sed -n 's/^ *java.home = //p')
TOOLCHAINS="$TEMP/toolchains.xml"
cat > "$TOOLCHAINS" <<EOF
<?xml version="1.0" encoding="UTF-8"?>
<toolchains>
  <toolchain>
    <type>jdk</type>
    <provides><id>JavaSE-21</id><version>21</version></provides>
    <configuration><jdkHome>$JDK_HOME</jdkHome></configuration>
  </toolchain>
</toolchains>
EOF

build() { # name dir [mvn args...]
  local name=$1 dir=$2; shift 2
  echo "==> $name"
  if [ ! -d "$dir" ]; then echo "FAILED: $name — $dir not found" >&2; FAILED+=("$name"); return 0; fi
  if ! (cd "$dir" && "${MVN[@]}" clean install "$@") >"$LOGS/$name.log" 2>&1; then
    echo "FAILED: $name — see $LOGS/$name.log" >&2; FAILED+=("$name")
  fi
}

# rune-dsl, rune-common and CDM tags carry placeholder versions (e.g.
# 0.0.0.9.x.x-SNAPSHOT). Their release pipelines set the real version before
# building; so does this.
set_version() { # name dir version
  echo "==> $1: set version $3"
  (cd "$2" && "${MVN[@]}" versions:set -DgenerateBackupPoms=false -DallowSnapshots=true "-DnewVersion=$3") \
    >"$LOGS/$1-set-version.log" 2>&1 \
    || { echo "FAILED: $1 set version — see $LOGS/$1-set-version.log" >&2; FAILED+=("$1-set-version"); }
}

# Rosetta model projects rebuilt from their published sources (DRR, iso20022,
# rune-fpml): the published Java already includes the generated code, so code
# generation is skipped. Parent POM first, then the rosetta-source module.
# Checkstyle and license-header checks need config files that are not part of
# the published sources, so they are skipped.
model() { # name dir
  build "$1-parent" "$2" -N -Dcheckstyle.skip -Dlicense.skip=true
  build "$1" "$2/rosetta-source" -Dxtext.generator.skip=true -Dcheckstyle.skip -Dlicense.skip=true
}

# Tycho stamps -SNAPSHOT on EMF bundles; re-install each at its release version.
# The POM Tycho embeds in the jar lists OSGi runtime bundles as dependencies,
# which pulls banned artifacts (reload4j) into CDM and DRR; the POM Eclipse
# publishes for the release lists the real Maven dependencies, so that is used.
emf_release() { # repo-dir bundle version
  local jar
  jar=$(ls "$SRC/$1/plugins/$2/target/$2-"*.jar 2>/dev/null | grep -v -- '-sources' | head -1 || true)
  if [ -z "$jar" ]; then echo "FAILED: $2 — no built jar" >&2; FAILED+=("$2"); return 0; fi
  rm -rf "$M2/org/eclipse/emf/$2/$3"
  { "${MVN[@]}" dependency:copy "-Dartifact=org.eclipse.emf:$2:$3:pom" "-DoutputDirectory=$TEMP/poms" \
    && "${MVN[@]}" install:install-file "-Dfile=$jar" "-DpomFile=$TEMP/poms/$2-$3.pom" \
         -DgroupId=org.eclipse.emf "-DartifactId=$2" "-Dversion=$3" -Dpackaging=jar; } >>"$LOGS/emf-install.log" 2>&1 \
    || { echo "FAILED: $2 install-file" >&2; FAILED+=("$2"); }
}

# 1. Eclipse EMF
# R2_33_0 (codegen 2.23.0): its pinned Tycho 2.7.5 cannot run on JDK 21, so
# Tycho 3.0.5 is used. The 2022-12 target platform lists an update site that no
# longer exists (download.itemis.com 2.1.0); a copy points at its successor,
# the site EMF itself moved to in later releases. The original is not modified.
TP="$SRC/emf-R2_33_0/releng/org.eclipse.emf.parent/tp"
if [ -f "$TP/2022-12.target" ]; then
  sed 's#https://download.itemis.com/updates/releases/2.1.0#https://xtext.github.io/download/updates/releases/2.1.1#' \
    "$TP/2022-12.target" > "$TP/2022-12-local.target"
fi
# Tycho 3 moved tycho-buildtimestamp-jgit from org.eclipse.tycho.extras to
# org.eclipse.tycho; this is the one reference in the EMF 2.33 POMs to update.
EMF_PARENT="$SRC/emf-R2_33_0/releng/org.eclipse.emf.parent/pom.xml"
if [ -f "$EMF_PARENT" ]; then
  perl -0pi -e 's#<groupId>org\.eclipse\.tycho\.extras</groupId>(\s*<artifactId>tycho-buildtimestamp-jgit</artifactId>)#<groupId>org.eclipse.tycho</groupId>$1#' "$EMF_PARENT"
fi
build emf-R2_33_0 "$SRC/emf-R2_33_0" -t "$TOOLCHAINS" -DjavaVersion=21 -Dtarget-platform=2022-12-local -Dtycho-version=3.0.5 \
  -pl releng/org.eclipse.emf.parent/tp,plugins/org.eclipse.emf.common,plugins/org.eclipse.emf.codegen -am
# R2_46_0 (codegen.ecore 2.46.0, codegen.ecore.xtext 1.8.0): 2026-03 target
# platform, as 2026-06 lists a withdrawn integration-build site.
build emf-R2_46_0 "$SRC/emf-R2_46_0" -t "$TOOLCHAINS" -DjavaVersion=21 -Dtarget-platform=2026-03 \
  -pl releng/org.eclipse.emf.parent/tp,plugins/org.eclipse.emf.codegen.ecore,plugins/org.eclipse.emf.codegen.ecore.xtext -am
emf_release emf-R2_33_0 org.eclipse.emf.codegen             2.23.0
emf_release emf-R2_46_0 org.eclipse.emf.codegen.ecore       2.46.0
emf_release emf-R2_46_0 org.eclipse.emf.codegen.ecore.xtext 1.8.0

# 2. Joda and Strata. JDK 21 compiles no lower than Java 8; these target 5 and 6.
build joda-convert "$SRC/joda-convert" -Djoda.release.version=8
build joda-beans   "$SRC/joda-beans"   -Djoda.release.version=8
build joda-time    "$SRC/joda-time"    -Dmaven.compiler.source=8 -Dmaven.compiler.target=8
# Strata targets Java 8: compiled against the Java 8 API (--release 8), since
# JDK 21's List.addFirst/removeFirst clash with its own methods. Its test
# sources do not compile on JDK 21 at all, so they are not compiled.
build strata       "$SRC/strata" -Dmaven.test.skip=true -Dmaven.compiler.release=8 -pl modules/basics,modules/collect -am

# 3. Jackson
build jackson-annotations     "$SRC/jackson-annotations" -Djavac.src.version=1.8 -Djavac.target.version=1.8
build jackson-core            "$SRC/jackson-core"
# jackson-databind's java21 profile activates on JDK 21 and raises the main
# compile to release 21, which would make the jar require Java 21 at runtime;
# the published 2.17.1 is Java 8 bytecode. The profile is deactivated.
build jackson-databind        "$SRC/jackson-databind" -P '!java21'
build jackson-dataformat-xml  "$SRC/jackson-dataformat-xml"
build jackson-dataformat-csv  "$SRC/jackson-dataformats-text" -pl csv -am
build jackson-datatype-jsr310 "$SRC/jackson-modules-java8"    -pl datetime -am

# 4. Rune DSL
# Only the modules that produce JARs used here, plus rune-testing (a test-scope
# dependency of rune-common, which Maven resolves even with tests skipped).
# Not built: rune-ide (the VS Code extension, which needs Node.js and npm),
# rune-tools, rune-profiling and rune-integration-tests - nothing depends on them.
RUNE_MODULES=rune-xcore-plugin-dependencies,rune-runtime,rune-lang,rune-testing,rune-maven-plugin
BACKPORT_MODULES=rosetta-xcore-plugin-dependencies,rosetta-runtime,rosetta-lang,rosetta-testing,rosetta-maven-plugin
set_version rune-dsl-9.83.0 "$SRC/rune-dsl-9.83.0" 9.83.0
build rune-dsl-9.83.0 "$SRC/rune-dsl-9.83.0" -pl "$RUNE_MODULES" -am
# The com.regnosys.rosetta* compatibility artifacts are a separate build in
# rune-dsl's release, run after the main one against the same version.
set_version rune-dsl-9.83.0-backport "$SRC/rune-dsl-9.83.0/rosetta-backport" 9.83.0
build rune-dsl-9.83.0-backport "$SRC/rune-dsl-9.83.0/rosetta-backport" -pl "$BACKPORT_MODULES" -am
set_version rune-dsl-9.85.1 "$SRC/rune-dsl-9.85.1" 9.85.1
build rune-dsl-9.85.1 "$SRC/rune-dsl-9.85.1" -pl "$RUNE_MODULES,rune-generator-api" -am
set_version rune-dsl-9.85.1-backport "$SRC/rune-dsl-9.85.1/rosetta-backport" 9.85.1
build rune-dsl-9.85.1-backport "$SRC/rune-dsl-9.85.1/rosetta-backport" -pl "$BACKPORT_MODULES" -am

# 5. Rune Common: 11.121.2 for CDM and rune-fpml, 11.124.2 for iso20022 and DRR
set_version rune-common "$SRC/rune-common" 11.121.2
build rune-common "$SRC/rune-common"
set_version rune-common-11.124.2 "$SRC/rune-common-11.124.2" 11.124.2
build rune-common-11.124.2 "$SRC/rune-common-11.124.2"

# 6. Built from published sources
# ingest-test-framework 11.121.2 is not built: 8 of its 127 classes
# (IngestionTest, AssertIngestion, ExpectationManager, ...) have no published
# source, and the libraries it bundles (translate-lib, translate-code-gen)
# publish none. CDM resolves the published artifact; the summary reports it.
model rune-fpml "$SRC/rune-fpml"

# 7. CDM
set_version cdm "$SRC/common-domain-model" 6.23.0
build cdm "$SRC/common-domain-model" -pl rosetta-source -am

# 8. ISO 20022 and DRR
model iso20022 "$SRC/iso20022"
# A DRR tree rebuilt from the published sources already has the generated Java
# in src/main/java. DRR's rosetta-maven-plugin has no skip setting, so its
# generate execution is unbound instead. A real DRR git checkout (no generated
# code in src/main/java) is left untouched and generates as normal.
if [ -f "$DRR_SRC/rosetta-source/src/main/java/drr/regulation/cftc/rewrite/trade/CFTCPart45TransactionReport.java" ]; then
  perl -0pi -e 's#(<id>default-cli</id>\s*)<phase>generate-sources</phase>#$1<phase>none</phase>#' "$DRR_SRC/rosetta-source/pom.xml"
fi
model drr      "$DRR_SRC"
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
  com.regnosys:rosetta-common:11.124.2
  com.regnosys:serialization:11.124.2
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
