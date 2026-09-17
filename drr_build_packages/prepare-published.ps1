# Create the source directories that have no git repository, from each project's
# published POMs and sources jar: src\cdm, src\rune-fpml, src\iso20022, src\DRR and
# src\rune-dsl-9.83.0-xtend-gen. Run from the directory that contains src\.
#
# The published files are read from published\. Any that are missing there are
# fetched with Maven, through your Maven settings (e.g. an Artifactory mirror), and
# kept in published\ for next time. Existing directories are left untouched; delete
# one to recreate it.
#
# The DRR sources contain paths longer than 260 characters, which Windows PowerShell
# cannot handle, so jars are unpacked with the JDK's jar tool and files are moved
# with robocopy.
#Requires -Version 5.1
$ErrorActionPreference = 'Stop'

$Root      = (Get-Location).Path
$Src       = Join-Path $Root 'src'
$Published = Join-Path $Root 'published'
$FetchRepo = Join-Path $Root 'temp\m2'
$Unpack    = Join-Path $Root 'temp\unpack'
# DRR and ISO 20022 are published to ISDA's repository, not Maven Central.
$IsdaRepo  = 'isda-maven::default::https://europe-west1-maven.pkg.dev/production-208613/isda-maven'
$Jar       = if ($env:JAVA_HOME -and (Test-Path (Join-Path $env:JAVA_HOME 'bin\jar.exe'))) { Join-Path $env:JAVA_HOME 'bin\jar.exe' } else { 'jar' }
New-Item -ItemType Directory -Force -Path $Src, $Published | Out-Null
$Failed = 0

# Make sure a published file is in published\: group:artifact:version:type[:classifier].
# Returns its path, or $null when it could not be fetched.
function Get-PublishedFile([string]$Coordinate) {
    $g, $a, $v, $t, $c = $Coordinate -split ':'
    $name = if ($c) { "$a-$v-$c.$t" } else { "$a-$v.$t" }
    $file = Join-Path $Published $name
    if (-not (Test-Path -LiteralPath $file)) {
        Write-Host "  fetching $Coordinate"
        $ErrorActionPreference = 'Continue'
        & mvn -B -q "-Dmaven.repo.local=$FetchRepo" dependency:get "-Dartifact=$Coordinate" '-Dtransitive=false' "-DremoteRepositories=$IsdaRepo" 2>&1 | Out-Host
        $ok = $LASTEXITCODE -eq 0
        $ErrorActionPreference = 'Stop'
        if (-not $ok) { Write-Host "  could not fetch $Coordinate - place $name in published\ and re-run"; return $null }
        $cached = Join-Path $FetchRepo ((($g -replace '\.', '\') + "\$a\$v\$name"))
        Copy-Item -LiteralPath $cached -Destination $file -Force
    }
    return $file
}

# Move files whose name matches a pattern from one tree to another, keeping
# relative paths. Directories named in ExcludeDirs are skipped.
function Move-Files([string]$From, [string]$To, [string[]]$Include, [string[]]$ExcludeDirs = @()) {
    New-Item -ItemType Directory -Force -Path $To | Out-Null
    if (Get-Command robocopy -ErrorAction SilentlyContinue) {
        # robocopy handles paths beyond 260 characters; exit codes below 8 mean success.
        $rcArgs = @($From, $To) + $Include + @('/S', '/MOV', '/NFL', '/NDL', '/NJH', '/NJS', '/NP', '/R:1', '/W:1')
        if ($ExcludeDirs.Count) { $rcArgs += @('/XD') + $ExcludeDirs }
        $ErrorActionPreference = 'Continue'
        & robocopy @rcArgs | Out-Null
        $code = $LASTEXITCODE
        $ErrorActionPreference = 'Stop'
        if ($code -ge 8) { throw "robocopy failed ($code): $From -> $To" }
    } else {
        $fromFull = (Resolve-Path -LiteralPath $From).Path
        Get-ChildItem -LiteralPath $fromFull -Recurse -File | ForEach-Object {
            $rel  = $_.FullName.Substring($fromFull.Length + 1)
            $dirs = @(($rel -split '[\\/]') | Select-Object -SkipLast 1)
            $name = $_.Name
            $wanted   = @($Include | Where-Object { $name -like $_ }).Count -gt 0
            $excluded = @($dirs | Where-Object { $ExcludeDirs -contains $_ }).Count -gt 0
            if ($wanted -and -not $excluded) {
                $dest = Join-Path $To $rel
                New-Item -ItemType Directory -Force -Path (Split-Path $dest) | Out-Null
                Move-Item -LiteralPath $_.FullName -Destination $dest -Force
            }
        }
    }
}

# Unpack a jar into a fresh staging directory with the JDK's jar tool.
function Expand-Jar([string]$JarFile, [string]$Stage, [string[]]$Entries = @()) {
    Remove-Item -LiteralPath $Stage -Recurse -Force -ErrorAction SilentlyContinue
    New-Item -ItemType Directory -Force -Path $Stage | Out-Null
    Push-Location $Stage
    try {
        $ErrorActionPreference = 'Continue'
        & $Jar xf $JarFile @Entries 2>&1 | Out-Host
        if ($LASTEXITCODE -ne 0) { throw "jar xf failed: $JarFile" }
    } finally { $ErrorActionPreference = 'Stop'; Pop-Location }
}

# A Rosetta model project: parent POM, and a rosetta-source module holding the
# sources jar split into Java, Rosetta model files and resources.
function New-ModelProject([string]$Name, [string]$Parent, [string]$Module, [string]$Sources) {
    $dir = Join-Path $Src $Name
    if (Test-Path (Join-Path $dir 'pom.xml')) { Write-Host "==> src\$Name exists, left as is"; return }
    Write-Host "==> src\$Name"
    $parentFile = Get-PublishedFile $Parent; $moduleFile = Get-PublishedFile $Module; $sourcesFile = Get-PublishedFile $Sources
    if (-not ($parentFile -and $moduleFile -and $sourcesFile)) { $script:Failed++; return }
    $m = Join-Path $dir 'rosetta-source'
    New-Item -ItemType Directory -Force -Path (Join-Path $m 'src\main\java'), (Join-Path $m 'src\main\rosetta'), (Join-Path $m 'src\main\resources') | Out-Null
    Copy-Item -LiteralPath $parentFile -Destination (Join-Path $dir 'pom.xml') -Force
    Copy-Item -LiteralPath $moduleFile -Destination (Join-Path $m 'pom.xml') -Force
    $stage = Join-Path $Unpack $Name
    Expand-Jar $sourcesFile $stage
    Move-Files $stage (Join-Path $m 'src\main\java') @('*.java')
    Move-Files $stage (Join-Path $m 'src\main\rosetta') @('*.rosetta')
    Move-Files $stage (Join-Path $m 'src\main\resources') @('*') -ExcludeDirs @('META-INF')
    Remove-Item -LiteralPath $stage -Recurse -Force -ErrorAction SilentlyContinue
}

New-ModelProject cdm       'org.finos.cdm:cdm-parent:6.23.0:pom'     'org.finos.cdm:cdm-java:6.23.0:pom'               'org.finos.cdm:cdm-java:6.23.0:jar:sources'
New-ModelProject rune-fpml 'com.regnosys.rune-fpml:parent:2.1.1:pom' 'com.regnosys.rune-fpml:rosetta-source:2.1.1:pom' 'com.regnosys.rune-fpml:rosetta-source:2.1.1:jar:sources'
New-ModelProject iso20022  'org.iso20022:parent:1.42.0:pom'          'org.iso20022:rosetta-source:1.42.0:pom'          'org.iso20022:rosetta-source:1.42.0:jar:sources'
New-ModelProject DRR       'com.regnosys:drr:7.7.0:pom'              'com.regnosys.drr:rosetta-source:7.7.0:pom'       'com.regnosys.drr:rosetta-source:7.7.0:jar:sources'

# rune-runtime 9.83.0 has one class written in Xtend; its Xtend-generated Java comes
# from the published sources jar, so the build needs no Xtend compiler.
$gen   = Join-Path $Src 'rune-dsl-9.83.0-xtend-gen\rune-runtime\src\main\java'
$class = 'com/rosetta/model/lib/expression/MapperMaths.java'
if (Test-Path (Join-Path $gen $class)) {
    Write-Host '==> src\rune-dsl-9.83.0-xtend-gen exists, left as is'
} else {
    Write-Host '==> src\rune-dsl-9.83.0-xtend-gen'
    $sourcesFile = Get-PublishedFile 'org.finos.rune:rune-runtime:9.83.0:jar:sources'
    if ($sourcesFile) {
        $stage = Join-Path $Unpack 'rune-runtime-9.83.0'
        Expand-Jar $sourcesFile $stage @($class)
        Move-Files $stage $gen @('*.java')
        Remove-Item -LiteralPath $stage -Recurse -Force -ErrorAction SilentlyContinue
    } else { $Failed++ }
}

Write-Host ''
if ($Failed -gt 0) { Write-Host "$Failed directories could not be created."; exit 1 }
Write-Host 'All published-source directories present.'
