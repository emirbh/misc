Write-Host '--- rune-fpml build result'; Select-String -Path temp\logs\rune-fpml.log -Pattern 'BUILD SUCCESS|BUILD FAILURE|ERROR' | Select-Object -Last 5
Write-Host '--- source class present'; Test-Path src\rune-fpml\rosetta-source\src\main\java\com\regnosys\runefpml\RuneFpmlRuntimeModule.java
Write-Host '--- java files in rune-fpml source'; (Get-ChildItem src\rune-fpml\rosetta-source\src\main\java -Recurse -Filter *.java).Count
Write-Host '--- jar in local repo'; Get-ChildItem temp\m2\com\regnosys\rune-fpml\rosetta-source\2.1.1 | Select-Object Name, Length
Write-Host '--- built here or downloaded'; Get-Content temp\m2\com\regnosys\rune-fpml\rosetta-source\2.1.1\_remote.repositories
Write-Host '--- class inside that jar'; & "$env:JAVA_HOME\bin\jar.exe" tf temp\m2\com\regnosys\rune-fpml\rosetta-source\2.1.1\rosetta-source-2.1.1.jar | Select-String 'runefpml/'
