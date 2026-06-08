$ErrorActionPreference = "Stop"

$scriptDir = Split-Path -Parent $MyInvocation.MyCommand.Path
$projectRoot = Split-Path -Parent $scriptDir
$sdkLib = Join-Path $projectRoot "tools\javafx-sdk\lib"
$sourceRoot = Join-Path $projectRoot "GUIProject\src"
$outputDir = Join-Path $projectRoot "GUIProject\out-javafx"

if (-not (Test-Path $sdkLib)) {
    throw "JavaFX SDK not found. Run tools\\setup-javafx.ps1 first."
}

New-Item -ItemType Directory -Force -Path $outputDir | Out-Null

$javaFiles = Get-ChildItem -Path (Join-Path $sourceRoot "hust\\soict\\hedspi\\javafx") -Filter *.java -Recurse |
    Select-Object -ExpandProperty FullName

if (-not $javaFiles) {
    throw "No JavaFX source files found under GUIProject\\src\\hust\\soict\\hedspi\\javafx."
}

javac --module-path $sdkLib --add-modules javafx.controls,javafx.fxml -d $outputDir $javaFiles

Get-ChildItem -Path (Join-Path $sourceRoot "hust\\soict\\hedspi\\javafx") -Filter *.fxml -Recurse |
    ForEach-Object {
        $relativePath = $_.FullName.Substring($sourceRoot.Length + 1)
        $destination = Join-Path $outputDir $relativePath
        $destinationDir = Split-Path -Parent $destination
        New-Item -ItemType Directory -Force -Path $destinationDir | Out-Null
        Copy-Item -Path $_.FullName -Destination $destination -Force
    }

Write-Output "Compiled JavaFX sources to $outputDir"
