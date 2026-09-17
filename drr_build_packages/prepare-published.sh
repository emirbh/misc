#!/usr/bin/env bash
# Create the source directories that have no git repository, from each project's
# published POMs and sources jar: src/cdm, src/rune-fpml, src/iso20022, src/DRR and
# src/rune-dsl-9.83.0-xtend-gen. Run from the directory that contains src/.
#
# The published files are read from published/. Any that are missing there are
# fetched with Maven, through your Maven settings (e.g. an Artifactory mirror), and
# kept in published/ for next time. Existing directories are left untouched; delete
# one to recreate it.
set -euo pipefail

ROOT="$(pwd)"
SRC="$ROOT/src"
PUBLISHED="$ROOT/published"
FETCH_REPO="$ROOT/temp/m2"
# DRR and ISO 20022 are published to ISDA's repository, not Maven Central.
ISDA_REPO="isda-maven::default::https://europe-west1-maven.pkg.dev/production-208613/isda-maven"
mkdir -p "$SRC" "$PUBLISHED"
FAILED=0

# Make sure a published file is in published/: group:artifact:version:type[:classifier]
published_file() {
  IFS=: read -r g a v t c <<<"$1"
  local name="$a-$v${c:+-$c}.$t"
  if [ ! -f "$PUBLISHED/$name" ]; then
    echo "  fetching $1" >&2
    if mvn -B -q "-Dmaven.repo.local=$FETCH_REPO" dependency:get "-Dartifact=$g:$a:$v:$t${c:+:$c}" \
         -Dtransitive=false "-DremoteRepositories=$ISDA_REPO" >&2; then
      cp "$FETCH_REPO/${g//.//}/$a/$v/$name" "$PUBLISHED/$name"
    else
      echo "  could not fetch $1 — place $name in published/ and re-run" >&2
      return 1
    fi
  fi
  echo "$PUBLISHED/$name"
}

# A Rosetta model project: parent POM, and a rosetta-source module holding the
# sources jar split into Java, Rosetta model files and resources.
model() { # dir parent-coordinate module-coordinate sources-coordinate
  local dir="$SRC/$1" parent module sources
  if [ -f "$dir/pom.xml" ]; then echo "==> src/$1 exists, left as is"; return; fi
  echo "==> src/$1"
  parent=$(published_file "$2") && module=$(published_file "$3") && sources=$(published_file "$4") \
    || { FAILED=$((FAILED + 1)); return; }
  local m="$dir/rosetta-source"
  mkdir -p "$m/src/main/java" "$m/src/main/rosetta" "$m/src/main/resources"
  cp "$parent" "$dir/pom.xml"
  cp "$module" "$m/pom.xml"
  unzip -q -o "$sources" '*.java' -d "$m/src/main/java"
  unzip -q -o "$sources" '*.rosetta' -d "$m/src/main/rosetta" 2>/dev/null || true
  unzip -q -o "$sources" -x '*.java' '*.rosetta' 'META-INF/*' -d "$m/src/main/resources" 2>/dev/null || true
  find "$m/src/main" -type d -empty -delete
  mkdir -p "$m/src/main/java" "$m/src/main/rosetta" "$m/src/main/resources"
}

model cdm       org.finos.cdm:cdm-parent:6.23.0:pom                org.finos.cdm:cdm-java:6.23.0:pom                org.finos.cdm:cdm-java:6.23.0:jar:sources
model rune-fpml com.regnosys.rune-fpml:parent:2.1.1:pom            com.regnosys.rune-fpml:rosetta-source:2.1.1:pom  com.regnosys.rune-fpml:rosetta-source:2.1.1:jar:sources
model iso20022  org.iso20022:parent:1.42.0:pom                     org.iso20022:rosetta-source:1.42.0:pom           org.iso20022:rosetta-source:1.42.0:jar:sources
model DRR       com.regnosys:drr:7.7.0:pom                         com.regnosys.drr:rosetta-source:7.7.0:pom        com.regnosys.drr:rosetta-source:7.7.0:jar:sources

# rune-runtime 9.83.0 has one class written in Xtend; its Xtend-generated Java comes
# from the published sources jar, so the build needs no Xtend compiler.
GEN="src/rune-dsl-9.83.0-xtend-gen/rune-runtime/src/main/java"
CLASS="com/rosetta/model/lib/expression/MapperMaths.java"
if [ -f "$ROOT/$GEN/$CLASS" ]; then
  echo "==> src/rune-dsl-9.83.0-xtend-gen exists, left as is"
else
  echo "==> src/rune-dsl-9.83.0-xtend-gen"
  if sources=$(published_file org.finos.rune:rune-runtime:9.83.0:jar:sources); then
    mkdir -p "$ROOT/$GEN" && unzip -q -o "$sources" "$CLASS" -d "$ROOT/$GEN"
  else
    FAILED=$((FAILED + 1))
  fi
fi

echo
if [ "$FAILED" -gt 0 ]; then echo "$FAILED directories could not be created."; exit 1; fi
echo "All published-source directories present."
