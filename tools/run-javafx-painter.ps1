$ErrorActionPreference = "Stop"

$scriptDir = Split-Path -Parent $MyInvocation.MyCommand.Path
$projectRoot = Split-Path -Parent $scriptDir
$sdkLib = Join-Path $projectRoot "tools\javafx-sdk\lib"
$outputDir = Join-Path $projectRoot "GUIProject\out-javafx"
$mainClass = "hust.soict.hedspi.javafx.Painter"

& (Join-Path $scriptDir "compile-javafx.ps1")

java --module-path $sdkLib --add-modules javafx.controls,javafx.fxml --enable-native-access=javafx.graphics -cp $outputDir $mainClass
