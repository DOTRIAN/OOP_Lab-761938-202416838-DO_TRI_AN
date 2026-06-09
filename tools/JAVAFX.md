# JavaFX support

JavaFX was added without converting the project to Maven or Gradle.

## Current lab files

- `GUIProject/src/hust/soict/hedspi/javafx/Painter.java`
- `GUIProject/src/hust/soict/hedspi/javafx/PainterController.java`
- `GUIProject/src/hust/soict/hedspi/javafx/Painter.fxml`
- `tools/setup-javafx.ps1`
- `tools/compile-javafx.ps1`
- `tools/run-javafx-painter.ps1`

## IntelliJ

The module includes a project library named `JavaFX SDK` pointing to `tools/javafx-sdk/lib`.

Shared run configuration:

- `Painter`

## Scene Builder

Set the IDE-wide Scene Builder path manually in:

- `File > Settings > Languages & Frameworks > JavaFX`
- `Path to SceneBuilder`:
  `C:\Users\Admin\AppData\Local\SceneBuilder\SceneBuilder.exe`

Then open:

- `GUIProject/src/hust/soict/hedspi/javafx/Painter.fxml`

## Command line

```powershell
powershell -ExecutionPolicy Bypass -File .\tools\compile-javafx.ps1
powershell -ExecutionPolicy Bypass -File .\tools\run-javafx-painter.ps1
```
