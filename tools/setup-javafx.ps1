$ErrorActionPreference = "Stop"

$scriptDir = Split-Path -Parent $MyInvocation.MyCommand.Path
$projectRoot = Split-Path -Parent $scriptDir
$toolsDir = Join-Path $projectRoot "tools"
$zipPath = Join-Path $toolsDir "javafx-sdk.zip"
$tempDir = Join-Path $toolsDir "javafx-extract"
$sdkDir = Join-Path $toolsDir "javafx-sdk"
$downloadUrl = "https://download.oracle.com/java/21/latest/javafx-21_windows-x64_bin-sdk.zip"

New-Item -ItemType Directory -Force -Path $toolsDir | Out-Null

if (Test-Path $sdkDir) {
    Write-Output "JavaFX SDK already exists at $sdkDir"
    exit 0
}

Invoke-WebRequest -Uri $downloadUrl -OutFile $zipPath
Expand-Archive -Path $zipPath -DestinationPath $tempDir -Force

$extractedDir = Get-ChildItem -Path $tempDir -Directory | Select-Object -First 1
Move-Item -Path $extractedDir.FullName -Destination $sdkDir
Remove-Item -Recurse -Force $tempDir

Write-Output "JavaFX SDK downloaded to $sdkDir"
