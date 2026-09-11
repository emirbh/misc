#!/usr/bin/env bash
# Check out every library's source into src/. Run from the directory that will hold src/.
set -euo pipefail
SOURCES_REPO="${SOURCES_REPO:-https://repo1.maven.org/maven2}"
mkdir -p src && cd src

clone() { # url tag dir
  echo "==> $3 @ $2"
  git clone --depth 1 --branch "$2" "$1" "$3"
}

# No git repository exists for these; the source is published as a -sources.jar
# next to the POM. Unpack it into a Maven project layout. .rosetta files are left
# out so the POM's code-generation step does not regenerate the unpacked Java.
fetch_sources() { # group-path artifact version dir
  local base="$SOURCES_REPO/$1/$2/$3"
  echo "==> $4 @ $3 (sources jar)"
  mkdir -p "$4/src/main/java" "$4/src/main/resources"
  curl -fsSL "$base/$2-$3.pom"         -o "$4/pom.xml"
  curl -fsSL "$base/$2-$3-sources.jar" -o "$4/sources.jar"
  unzip -q -o "$4/sources.jar" '*.java' -d "$4/src/main/java"
  unzip -q -o "$4/sources.jar" -x '*.java' '*.rosetta' 'META-INF/*' -d "$4/src/main/resources" || true
}

clone https://github.com/eclipse-emf/org.eclipse.emf.git           R2_33_0                         emf-R2_33_0
clone https://github.com/eclipse-emf/org.eclipse.emf.git           R2_46_0                         emf-R2_46_0
clone https://github.com/JodaOrg/joda-convert.git                  v2.0                            joda-convert
clone https://github.com/JodaOrg/joda-beans.git                    v2.1                            joda-beans
clone https://github.com/JodaOrg/joda-time.git                     v2.10.14                        joda-time
clone https://github.com/OpenGamma/Strata.git                      v1.7.0                          strata
clone https://github.com/FasterXML/jackson-annotations.git         jackson-annotations-2.17.1      jackson-annotations
clone https://github.com/FasterXML/jackson-core.git                jackson-core-2.17.1             jackson-core
clone https://github.com/FasterXML/jackson-databind.git            jackson-databind-2.17.1         jackson-databind
clone https://github.com/FasterXML/jackson-dataformat-xml.git      jackson-dataformat-xml-2.17.1   jackson-dataformat-xml
clone https://github.com/FasterXML/jackson-dataformats-text.git    jackson-dataformats-text-2.17.1 jackson-dataformats-text
clone https://github.com/FasterXML/jackson-modules-java8.git       jackson-modules-java8-2.17.1    jackson-modules-java8
clone https://github.com/finos/rune-dsl.git                        9.83.0                          rune-dsl-9.83.0
clone https://github.com/finos/rune-dsl.git                        9.85.1                          rune-dsl-9.85.1
clone https://github.com/finos/rune-common.git                     11.121.2                        rune-common
clone https://github.com/finos/common-domain-model.git             6.23.0                          common-domain-model
fetch_sources com/regnosys           ingest-test-framework 11.121.2 ingest-test-framework
fetch_sources com/regnosys/rune-fpml rosetta-source        2.1.1    rune-fpml
