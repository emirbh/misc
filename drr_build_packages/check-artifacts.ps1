# Check that everything build-all downloads can be obtained on this machine:
# each Maven artifact from the local repository or through Artifactory, and each
# Eclipse p2 update site the EMF builds read. Reads required-artifacts.txt and
# required-p2-sites.txt from the directory this script is in, and can be run from
# anywhere. Nothing is downloaded or installed.
#
#   ARTIFACTORY_URL    Maven repository URL in Artifactory, e.g.
#                      https://artifactory.example.com/artifactory/maven-remote
#                      (unset: only the local repository is checked)
#   ARTIFACTORY_TOKEN  bearer token, or ARTIFACTORY_USER + ARTIFACTORY_PASSWORD
#   LOCAL_REPO         local Maven repository (default: temp\m2)
#   PARALLEL           concurrent Artifactory requests (default: 16)
#Requires -Version 5.1
$ErrorActionPreference = 'Stop'

$Root      = $PSScriptRoot
$List      = if ($env:ARTIFACT_LIST) { $env:ARTIFACT_LIST } else { Join-Path $Root 'required-artifacts.txt' }
$Sites     = Join-Path $Root 'required-p2-sites.txt'
$LocalRepo = if ($env:LOCAL_REPO) { $env:LOCAL_REPO } else { Join-Path $Root 'temp\m2' }
$Report    = Join-Path $Root 'temp\logs\artifact-check.txt'
$BaseUrl   = if ($env:ARTIFACTORY_URL) { $env:ARTIFACTORY_URL.TrimEnd('/') } else { '' }
$Parallel  = if ($env:PARALLEL) { [int]$env:PARALLEL } else { 16 }
foreach ($f in @($List, $Sites)) {
    if (-not (Test-Path -LiteralPath $f -PathType Leaf)) {
        Write-Host "Not found: $f"
        Write-Host 'Copy required-artifacts.txt and required-p2-sites.txt next to check-artifacts.ps1.'
        exit 2
    }
}
New-Item -ItemType Directory -Force -Path (Split-Path $Report) | Out-Null

Add-Type -AssemblyName System.Net.Http
[Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12

function New-HttpClient([bool]$WithAuth) {
    $client = New-Object System.Net.Http.HttpClient
    $client.Timeout = [TimeSpan]::FromSeconds(60)
    if ($WithAuth -and $env:ARTIFACTORY_TOKEN) {
        $client.DefaultRequestHeaders.Authorization = New-Object System.Net.Http.Headers.AuthenticationHeaderValue('Bearer', $env:ARTIFACTORY_TOKEN)
    } elseif ($WithAuth -and $env:ARTIFACTORY_USER) {
        $pair = [Convert]::ToBase64String([Text.Encoding]::UTF8.GetBytes("$($env:ARTIFACTORY_USER):$($env:ARTIFACTORY_PASSWORD)"))
        $client.DefaultRequestHeaders.Authorization = New-Object System.Net.Http.Headers.AuthenticationHeaderValue('Basic', $pair)
    }
    return $client
}

# HEAD each URL, $Parallel at a time. Returns url -> status (0 when no response).
function Get-HttpStatus($Client, [string[]]$Urls) {
    $status = @{}
    for ($i = 0; $i -lt $Urls.Count; $i += $Parallel) {
        $batch = $Urls[$i..([Math]::Min($i + $Parallel, $Urls.Count) - 1)]
        $tasks = @(foreach ($u in $batch) {
            $Client.SendAsync((New-Object System.Net.Http.HttpRequestMessage([System.Net.Http.HttpMethod]::Head, $u)))
        })
        try { [System.Threading.Tasks.Task]::WaitAll([System.Threading.Tasks.Task[]]$tasks) } catch { }
        for ($j = 0; $j -lt $batch.Count; $j++) {
            $t = $tasks[$j]
            $status[$batch[$j]] = if ($t.Status -eq 'RanToCompletion') { [int]$t.Result.StatusCode } else { 0 }
        }
    }
    return $status
}

# ---- Maven artifacts ----
$all = @(Get-Content $List | Where-Object { $_ -and -not $_.StartsWith('#') })
$local = New-Object System.Collections.Generic.List[string]
$remote = New-Object System.Collections.Generic.List[string]
foreach ($p in $all) {
    if (Test-Path -LiteralPath (Join-Path $LocalRepo $p) -PathType Leaf) { $local.Add($p) } else { $remote.Add($p) }
}

$lines = New-Object System.Collections.Generic.List[string]
foreach ($p in $local) { $lines.Add("LOCAL        $p") }
$missing = New-Object System.Collections.Generic.List[string]
if ($BaseUrl -and $remote.Count -gt 0) {
    Write-Host "Checking $($remote.Count) artifacts through $BaseUrl ..."
    $client = New-HttpClient $true
    $status = Get-HttpStatus $client @($remote | ForEach-Object { "$BaseUrl/$_" })
    foreach ($p in $remote) {
        $code = $status["$BaseUrl/$p"]
        if ($code -eq 200) { $lines.Add("ARTIFACTORY  $p") }
        else { $why = if ($code -eq 0) { 'no response' } else { "HTTP $code" }; $missing.Add("$p  ($why)") }
    }
} else {
    foreach ($p in $remote) { $missing.Add("$p  (not local, no ARTIFACTORY_URL)") }
}
foreach ($m in $missing) { $lines.Add("MISSING      $m") }
$lines | Sort-Object { ($_ -split '\s+', 2)[1] } | Set-Content -Path $Report -Encoding ascii

$remoteOk = @($lines | Where-Object { $_.StartsWith('ARTIFACTORY') }).Count
Write-Host ''
Write-Host "Maven artifacts: $($all.Count) required - $($local.Count) local, $remoteOk through Artifactory, $($missing.Count) missing"
$missing | Select-Object -First 20 | ForEach-Object { Write-Host "  missing: $_" }
if ($missing.Count -gt 20) { Write-Host "  ... and $($missing.Count - 20) more" }

# ---- Eclipse p2 update sites (not Maven; checked directly) ----
Write-Host ''
Write-Host 'Eclipse p2 update sites:'
$unreachable = 0
$siteClient = New-HttpClient $false
foreach ($site in @(Get-Content $Sites | Where-Object { $_ -and -not $_.StartsWith('#') })) {
    $probe = @('p2.index', 'compositeContent.jar', 'compositeContent.xml', 'content.jar', 'content.xml.xz', 'content.xml') | ForEach-Object { "$site/$_" }
    $status = Get-HttpStatus $siteClient $probe
    if (@($status.Values | Where-Object { $_ -eq 200 }).Count -gt 0) { Write-Host "  ok           $site" }
    else { Write-Host "  UNREACHABLE  $site"; $unreachable++ }
}
Add-Content -Path $Report -Value "`r`np2 sites unreachable: $unreachable"

Write-Host ''
Write-Host "Full report: $Report"
if ($missing.Count -gt 0 -or $unreachable -gt 0) { exit 1 }
