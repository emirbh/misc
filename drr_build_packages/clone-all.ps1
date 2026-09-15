# Check out every library's source into src\. Run from the directory that will hold src\.
#Requires -Version 5.1
$ErrorActionPreference = 'Stop'
New-Item -ItemType Directory -Force -Path src | Out-Null
Set-Location src

function Invoke-Clone([string]$Url, [string]$Tag, [string]$Dir) {
    Write-Host "==> $Dir @ $Tag"
    # EMF and CDM exceed the 260-character Windows path limit.
    git -c core.longpaths=true clone --depth 1 --branch $Tag $Url $Dir
    if ($LASTEXITCODE -ne 0) { throw "git clone failed: $Dir" }
}

Invoke-Clone https://github.com/eclipse-emf/org.eclipse.emf.git         R2_33_0                         emf-R2_33_0
Invoke-Clone https://github.com/eclipse-emf/org.eclipse.emf.git         R2_46_0                         emf-R2_46_0
Invoke-Clone https://github.com/JodaOrg/joda-convert.git                v2.0                            joda-convert
Invoke-Clone https://github.com/JodaOrg/joda-beans.git                  v2.1                            joda-beans
Invoke-Clone https://github.com/JodaOrg/joda-time.git                   v2.10.14                        joda-time
Invoke-Clone https://github.com/OpenGamma/Strata.git                    v1.7.0                          strata
Invoke-Clone https://github.com/FasterXML/jackson-annotations.git       jackson-annotations-2.17.1      jackson-annotations
Invoke-Clone https://github.com/FasterXML/jackson-core.git              jackson-core-2.17.1             jackson-core
Invoke-Clone https://github.com/FasterXML/jackson-databind.git          jackson-databind-2.17.1         jackson-databind
Invoke-Clone https://github.com/FasterXML/jackson-dataformat-xml.git    jackson-dataformat-xml-2.17.1   jackson-dataformat-xml
Invoke-Clone https://github.com/FasterXML/jackson-dataformats-text.git  jackson-dataformats-text-2.17.1 jackson-dataformats-text
Invoke-Clone https://github.com/FasterXML/jackson-modules-java8.git     jackson-modules-java8-2.17.1    jackson-modules-java8
Invoke-Clone https://github.com/finos/rune-dsl.git                      9.83.0                          rune-dsl-9.83.0
Invoke-Clone https://github.com/finos/rune-dsl.git                      9.85.1                          rune-dsl-9.85.1
Invoke-Clone https://github.com/finos/rune-common.git                   11.121.2                        rune-common
Invoke-Clone https://github.com/finos/rune-common.git                   11.124.2                        rune-common-11.124.2
Invoke-Clone https://github.com/finos/common-domain-model.git           6.23.0                          common-domain-model

# rune-fpml, iso20022 and DRR have no public git repository:
# copy their sources into src\rune-fpml, src\iso20022 and src\DRR.
