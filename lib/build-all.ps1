# Build every library in src\ and collect the JARs into build\.
# Run from the directory that contains src\. Requires JDK 21 and Maven 3.9+.
# Build only - nothing is deployed.
#Requires -Version 5.1
$ErrorActionPreference = 'Stop'

$Root   = (Get-Location).Path
$Src    = Join-Path $Root 'src'
$Out    = Join-Path $Root 'build'
$Logs   = Join-Path $Out 'logs'
$M2     = Join-Path $Out '.m2'    # dedicated local repo, so a collected JAR can be proven built here
$DrrSrc = if ($env:DRR_SRC) { $env:DRR_SRC } else { Join-Path $Src 'DRR' }

# ---- Preflight: every source directory must exist before anything is built ----
# A directory counts only if it contains pom.xml. For each missing one, print the
# commands that create it, then stop. Re-run once they are all in place.
$SourcesRepo = if ($env:SOURCES_REPO) { $env:SOURCES_REPO } else { 'https://repo1.maven.org/maven2' }
$Required = @(
    @{ Dir = 'emf-R2_33_0';              Kind = 'git'; Url = 'https://github.com/eclipse-emf/org.eclipse.emf.git';        Tag = 'R2_33_0' }
    @{ Dir = 'emf-R2_46_0';              Kind = 'git'; Url = 'https://github.com/eclipse-emf/org.eclipse.emf.git';        Tag = 'R2_46_0' }
    @{ Dir = 'joda-convert';             Kind = 'git'; Url = 'https://github.com/JodaOrg/joda-convert.git';               Tag = 'v2.0' }
    @{ Dir = 'joda-beans';               Kind = 'git'; Url = 'https://github.com/JodaOrg/joda-beans.git';                 Tag = 'v2.1' }
    @{ Dir = 'joda-time';                Kind = 'git'; Url = 'https://github.com/JodaOrg/joda-time.git';                  Tag = 'v2.10.14' }
    @{ Dir = 'strata';                   Kind = 'git'; Url = 'https://github.com/OpenGamma/Strata.git';                   Tag = 'v1.7.0' }
    @{ Dir = 'jackson-annotations';      Kind = 'git'; Url = 'https://github.com/FasterXML/jackson-annotations.git';      Tag = 'jackson-annotations-2.17.1' }
    @{ Dir = 'jackson-core';             Kind = 'git'; Url = 'https://github.com/FasterXML/jackson-core.git';             Tag = 'jackson-core-2.17.1' }
    @{ Dir = 'jackson-databind';         Kind = 'git'; Url = 'https://github.com/FasterXML/jackson-databind.git';         Tag = 'jackson-databind-2.17.1' }
    @{ Dir = 'jackson-dataformat-xml';   Kind = 'git'; Url = 'https://github.com/FasterXML/jackson-dataformat-xml.git';   Tag = 'jackson-dataformat-xml-2.17.1' }
    @{ Dir = 'jackson-dataformats-text'; Kind = 'git'; Url = 'https://github.com/FasterXML/jackson-dataformats-text.git'; Tag = 'jackson-dataformats-text-2.17.1' }
    @{ Dir = 'jackson-modules-java8';    Kind = 'git'; Url = 'https://github.com/FasterXML/jackson-modules-java8.git';    Tag = 'jackson-modules-java8-2.17.1' }
    @{ Dir = 'rune-dsl-9.83.0';          Kind = 'git'; Url = 'https://github.com/finos/rune-dsl.git';                     Tag = '9.83.0' }
    @{ Dir = 'rune-dsl-9.85.1';          Kind = 'git'; Url = 'https://github.com/finos/rune-dsl.git';                     Tag = '9.85.1' }
    @{ Dir = 'rune-common';              Kind = 'git'; Url = 'https://github.com/finos/rune-common.git';                  Tag = '11.121.2' }
    @{ Dir = 'common-domain-model';      Kind = 'git'; Url = 'https://github.com/finos/common-domain-model.git';          Tag = '6.23.0' }
    @{ Dir = 'ingest-test-framework';    Kind = 'jar'; Group = 'com/regnosys';           Artifact = 'ingest-test-framework'; Version = '11.121.2' }
    @{ Dir = 'rune-fpml';                Kind = 'jar'; Group = 'com/regnosys/rune-fpml'; Artifact = 'rosetta-source';        Version = '2.1.1' }
    @{ Dir = 'DRR';                      Kind = 'copy'; What = 'DRR 7.7.0 source tree' }
)
$missingSrc = 0
foreach ($r in $Required) {
    $path = if ($r.Dir -eq 'DRR') { $DrrSrc } else { Join-Path $Src $r.Dir }
    if (Test-Path (Join-Path $path 'pom.xml')) { continue }
    $show = if ($path.StartsWith($Root)) { $path.Substring($Root.Length + 1) } else { $path }
    $missingSrc++
    Write-Host "MISSING: $show"
    switch ($r.Kind) {
        'git' {
            Write-Host "  git -c core.longpaths=true clone --depth 1 --branch $($r.Tag) $($r.Url) `"$show`""
        }
        'jar' {
            $base = "$SourcesRepo/$($r.Group)/$($r.Artifact)/$($r.Version)"
            $java = Join-Path $show 'src\main\java'
            $res  = Join-Path $show 'src\main\resources'
            Write-Host "  New-Item -ItemType Directory -Force `"$java`", `"$res`" | Out-Null"
            Write-Host "  Invoke-WebRequest $base/$($r.Artifact)-$($r.Version).pom -OutFile `"$show\pom.xml`" -UseBasicParsing"
            Write-Host "  Invoke-WebRequest $base/$($r.Artifact)-$($r.Version)-sources.jar -OutFile `"$show\sources.jar`" -UseBasicParsing"
            Write-Host "  tar -xf `"$show\sources.jar`" -C `"$java`" '*.java'"
            Write-Host "  tar -xf `"$show\sources.jar`" -C `"$res`" --exclude '*.java' --exclude '*.rosetta' --exclude 'META-INF/*'"
        }
        'copy' {
            Write-Host "  copy the $($r.What) into `"$show`""
        }
    }
    Write-Host ''
}
if ($missingSrc -gt 0) {
    Write-Host "Missing source directories: $missingSrc of $($Required.Count)."
    Write-Host 'Create them with the commands above, then re-run this script.'
    exit 1
}
Write-Host "All $($Required.Count) source directories present."

# java and mvn write to stderr; under 'Stop', Windows PowerShell 5.1 turns that into
# a terminating error. Native calls run with 'Continue' and are checked by exit code.
$ErrorActionPreference = 'Continue'
$javaVersion = (& java -version 2>&1 | Out-String)
$ErrorActionPreference = 'Stop'
if ($javaVersion -notmatch 'version "21') { throw 'JDK 21 required' }

New-Item -ItemType Directory -Force -Path $Out, $Logs | Out-Null
Remove-Item (Join-Path $Out '*.jar') -ErrorAction SilentlyContinue

# Every -D argument is quoted: unquoted, PowerShell splits -Dmaven.repo.local=... at the dot.
$Mvn = @('-B', '-ntp', '-DskipTests', "-Dmaven.repo.local=$M2")
$NodeArgs = @()
if ($env:ARTIFACTORY_URL) {
    $NodeArgs = @("-Dnode.download.root=$($env:ARTIFACTORY_URL)/artifactory/nodejs-dist-remote/",
                  "-Dnpm.download.root=$($env:ARTIFACTORY_URL)/artifactory/npm-remote/npm/-/")
}
$Failed = New-Object System.Collections.Generic.List[string]

function Invoke-Build([string]$Name, [string]$Dir, [string[]]$Extra = @()) {
    Write-Host "==> $Name"
    if (-not (Test-Path $Dir)) { Write-Warning "FAILED: $Name - $Dir not found"; $Failed.Add($Name); return }
    $log = Join-Path $Logs "$Name.log"
    $ErrorActionPreference = 'Continue'
    Push-Location $Dir
    try { & mvn @Mvn clean install @Extra 2>&1 | Out-File -FilePath $log -Encoding utf8 }
    finally { Pop-Location }
    if ($LASTEXITCODE -ne 0) { Write-Warning "FAILED: $Name - see $log"; $Failed.Add($Name) }
}

# Tycho stamps -SNAPSHOT on EMF bundles; re-install each at its release version.
function Install-EmfRelease([string]$RepoDir, [string]$Bundle, [string]$Version) {
    $target = Join-Path $Src "$RepoDir/plugins/$Bundle/target"
    $jar = Get-ChildItem $target -Filter "$Bundle-*.jar" -ErrorAction SilentlyContinue |
           Where-Object { $_.Name -notlike '*-sources.jar' } | Select-Object -First 1
    if (-not $jar) { Write-Warning "FAILED: $Bundle - no built jar"; $Failed.Add($Bundle); return }
    $ErrorActionPreference = 'Continue'
    & mvn @Mvn install:install-file "-Dfile=$($jar.FullName)" '-DgroupId=org.eclipse.emf' `
        "-DartifactId=$Bundle" "-Dversion=$Version" '-Dpackaging=jar' 2>&1 |
        Out-File -FilePath (Join-Path $Logs 'emf-install.log') -Append -Encoding utf8
    if ($LASTEXITCODE -ne 0) { Write-Warning "FAILED: $Bundle install-file"; $Failed.Add($Bundle) }
}

# 1. Eclipse EMF
Invoke-Build emf-R2_33_0 (Join-Path $Src 'emf-R2_33_0') @('-pl', 'plugins/org.eclipse.emf.codegen', '-am')
Invoke-Build emf-R2_46_0 (Join-Path $Src 'emf-R2_46_0') @('-pl', 'plugins/org.eclipse.emf.codegen.ecore,plugins/org.eclipse.emf.codegen.ecore.xtext', '-am')
Install-EmfRelease emf-R2_33_0 org.eclipse.emf.codegen             2.23.0
Install-EmfRelease emf-R2_46_0 org.eclipse.emf.codegen.ecore       2.46.0
Install-EmfRelease emf-R2_46_0 org.eclipse.emf.codegen.ecore.xtext 1.8.0

# 2. Joda and Strata
Invoke-Build joda-convert (Join-Path $Src 'joda-convert')
Invoke-Build joda-beans   (Join-Path $Src 'joda-beans')
Invoke-Build joda-time    (Join-Path $Src 'joda-time')
Invoke-Build strata       (Join-Path $Src 'strata') @('-pl', 'modules/basics,modules/collect', '-am')

# 3. Jackson
Invoke-Build jackson-annotations     (Join-Path $Src 'jackson-annotations')
Invoke-Build jackson-core            (Join-Path $Src 'jackson-core')
Invoke-Build jackson-databind        (Join-Path $Src 'jackson-databind')
Invoke-Build jackson-dataformat-xml  (Join-Path $Src 'jackson-dataformat-xml')
Invoke-Build jackson-dataformat-csv  (Join-Path $Src 'jackson-dataformats-text') @('-pl', 'csv', '-am')
Invoke-Build jackson-datatype-jsr310 (Join-Path $Src 'jackson-modules-java8')    @('-pl', 'datetime', '-am')

# 4. Rune DSL
Invoke-Build rune-dsl-9.83.0 (Join-Path $Src 'rune-dsl-9.83.0') $NodeArgs
Invoke-Build rune-dsl-9.85.1 (Join-Path $Src 'rune-dsl-9.85.1') $NodeArgs

# 5. Rune Common
Invoke-Build rune-common (Join-Path $Src 'rune-common')

# 6. Sources-jar builds
Invoke-Build ingest-test-framework (Join-Path $Src 'ingest-test-framework') @('-Dcheckstyle.skip')
Invoke-Build rune-fpml             (Join-Path $Src 'rune-fpml')             @('-Dcheckstyle.skip')

# 7. CDM
Invoke-Build cdm (Join-Path $Src 'common-domain-model') @('-pl', 'rosetta-source', '-am')

# 8. DRR - needs org.iso20022:rosetta-source:1.42.0, which has no source
Invoke-Build drr $DrrSrc @('-pl', 'rosetta-source', '-am')
$DrrVersion = 'unknown'
$drrPom = Join-Path $DrrSrc 'pom.xml'
if (Test-Path $drrPom) { $DrrVersion = ([xml](Get-Content $drrPom -Raw)).project.version }

# Collect. A JAR is taken only if _remote.repositories records a local install -
# anything resolved from a remote repository is reported, not copied.
$Artifacts = @(
    'org.eclipse.emf:org.eclipse.emf.codegen:2.23.0'
    'org.eclipse.emf:org.eclipse.emf.codegen.ecore:2.46.0'
    'org.eclipse.emf:org.eclipse.emf.codegen.ecore.xtext:1.8.0'
    'org.joda:joda-convert:2.0'
    'org.joda:joda-beans:2.1'
    'joda-time:joda-time:2.10.14'
    'com.opengamma.strata:strata-basics:1.7.0'
    'com.opengamma.strata:strata-collect:1.7.0'
    'com.fasterxml.jackson.core:jackson-annotations:2.17.1'
    'com.fasterxml.jackson.core:jackson-core:2.17.1'
    'com.fasterxml.jackson.core:jackson-databind:2.17.1'
    'com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.17.1'
    'com.fasterxml.jackson.dataformat:jackson-dataformat-csv:2.17.1'
    'com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.17.1'
    'org.finos.rune:rune-maven-plugin:9.83.0'
    'org.finos.rune:rune-xcore-plugin-dependencies:9.83.0'
    'com.regnosys.rosetta:com.regnosys.rosetta.lib:9.83.0'
    'com.regnosys.rosetta:rosetta-maven-plugin:9.83.0'
    'org.finos.rune:rune-lang:9.85.1'
    'org.finos.rune:rune-runtime:9.85.1'
    'org.finos.rune:rune-generator-api:9.85.1'
    'com.regnosys.rosetta:com.regnosys.rosetta:9.85.1'
    'com.regnosys:rosetta-common:11.121.2'
    'com.regnosys:serialization:11.121.2'
    'com.regnosys:ingest-test-framework:11.121.2'
    'com.regnosys.rune-fpml:rosetta-source:2.1.1'
    'org.finos.cdm:cdm-java:6.23.0'
    'org.iso20022:rosetta-source:1.42.0'
    "com.regnosys.drr:rosetta-source:$DrrVersion"
)
$Missing = New-Object System.Collections.Generic.List[string]
foreach ($coord in $Artifacts) {
    $g, $a, $v = $coord -split ':'
    $dir    = Join-Path $M2 (($g -replace '\.', '/') + "/$a/$v")
    $jar    = Join-Path $dir "$a-$v.jar"
    $remote = Join-Path $dir '_remote.repositories'
    $local  = (Test-Path $remote) -and (Select-String -Path $remote -SimpleMatch "$a-$v.jar>=" -Quiet)
    if ((Test-Path $jar) -and $local) { Copy-Item $jar $Out -Force } else { $Missing.Add($coord) }
}

Write-Host ''
Write-Host "Collected $($Artifacts.Count - $Missing.Count) of $($Artifacts.Count) JARs into $Out"
foreach ($m in $Missing) { Write-Host "  missing: $m" }
foreach ($f in $Failed)  { Write-Host "  failed build: $f" }
if ($Missing.Count -gt 0) { exit 1 }
