# JavaFX support

JavaFX was added without changing the existing source layout or converting the project to Maven/Gradle.

## Files added

- `tools/javafx-sdk`: local JavaFX SDK used by IntelliJ and command-line scripts
- `GUIProject/src/hust/soict/hedspi/javafx/HelloFX.java`: minimal JavaFX entry point
- `GUIProject/src/hust/soict/hedspi/javafx/JavaFXSmokeTest.java`: quick runtime check for window + button handling
- `tools/setup-javafx.ps1`: downloads the JavaFX SDK if it is missing
- `tools/compile-javafx.ps1`: compiles JavaFX sources to `GUIProject/out-javafx`
- `tools/run-javafx-hellofx.ps1`: compiles and launches the sample JavaFX application

## IntelliJ

The module file now includes a project library named `JavaFX SDK` pointing to `tools/javafx-sdk/lib`.

If IntelliJ is already open, reload the project so it picks up `.idea/libraries/JavaFX_SDK.xml`.

Shared run configurations were added in `.idea/runConfigurations`:

- `HelloFX`
- `JavaFX Smoke Test`

## Command line

```powershell
powershell -ExecutionPolicy Bypass -File .\tools\compile-javafx.ps1
powershell -ExecutionPolicy Bypass -File .\tools\run-javafx-hellofx.ps1
```
