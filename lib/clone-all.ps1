# Check out every library's source into src\. Run from the directory that will hold src\.
#Requires -Version 5.1
$ErrorActionPreference = 'Stop'
$ProgressPreference = 'SilentlyContinue'
[Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12
$SourcesRepo = if ($env:SOURCES_REPO) { $env:SOURCES_REPO } else { 'https://repo1.maven.org/maven2' }
New-Item -ItemType Directory -Force -Path src | Out-Null
Set-Location src

function Invoke-Clone([string]$Url, [string]$Tag, [string]$Dir) {
    Write-Host "==> $Dir @ $Tag"
    # EMF and CDM exceed the 260-character Windows path limit.
    git -c core.longpaths=true clone --depth 1 --branch $Tag $Url $Dir
    if ($LASTEXITCODE -ne 0) { throw "git clone failed: $Dir" }
}

# No git repository exists for these; the source is published as a -sources.jar
# next to the POM. Unpack it into a Maven project layout. .rosetta files are left
# out so the POM's code-generation step does not regenerate the unpacked Java.
function Get-SourcesJar([string]$GroupPath, [string]$Artifact, [string]$Version, [string]$Dir) {
    $base = "$SourcesRepo/$GroupPath/$Artifact/$Version"
    Write-Host "==> $Dir @ $Version (sources jar)"
    New-Item -ItemType Directory -Force -Path "$Dir/src/main/java", "$Dir/src/main/resources" | Out-Null
    Invoke-WebRequest "$base/$Artifact-$Version.pom"         -OutFile "$Dir/pom.xml"     -UseBasicParsing
    Invoke-WebRequest "$base/$Artifact-$Version-sources.jar" -OutFile "$Dir/sources.jar" -UseBasicParsing
    Add-Type -AssemblyName System.IO.Compression.FileSystem
    $dirPath = (Resolve-Path $Dir).Path
    $zip = [IO.Compression.ZipFile]::OpenRead((Join-Path $dirPath 'sources.jar'))
    try {
        foreach ($e in $zip.Entries) {
            $name = $e.FullName
            if ($name.EndsWith('/') -or $name -like '*.rosetta' -or $name -like 'META-INF/*') { continue }
            $root = if ($name -like '*.java') { 'src/main/java' } else { 'src/main/resources' }
            $target = Join-Path $dirPath (Join-Path $root $name)
            New-Item -ItemType Directory -Force -Path (Split-Path $target) | Out-Null
            [IO.Compression.ZipFileExtensions]::ExtractToFile($e, $target, $true)
        }
    } finally { $zip.Dispose() }
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
Invoke-Clone https://github.com/finos/common-domain-model.git           6.23.0                          common-domain-model
Get-SourcesJar com/regnosys           ingest-test-framework 11.121.2 ingest-test-framework
Get-SourcesJar com/regnosys/rune-fpml rosetta-source        2.1.1    rune-fpml
