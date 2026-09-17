#!/usr/bin/env bash
# Check out every library's source into src/. Run from the directory that will hold src/.
set -euo pipefail
mkdir -p src && cd src

clone() { # url tag dir
  echo "==> $3 @ $2"
  git clone --depth 1 --branch "$2" "$1" "$3"
}

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
clone https://github.com/finos/rune-common.git                     11.124.2                        rune-common-11.124.2

# Published sources, not git: copy them into src/ (see build-all's preflight check).
#   src/cdm                         CDM 6.23.0 (cdm-parent, cdm-java POMs + cdm-java-6.23.0-sources.jar)
#   src/rune-fpml                   rune-fpml 2.1.1
#   src/iso20022                    iso20022 1.42.0
#   src/DRR                         DRR 7.7.0
#   src/rune-dsl-9.83.0-xtend-gen   MapperMaths.java from rune-runtime-9.83.0-sources.jar
