package hust.soict.hedspi.javafx.fxml;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FXMLHelloApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        URL fxmlLocation = resolveFxmlLocation();
        FXMLLoader loader = new FXMLLoader(fxmlLocation);
        VBox root = loader.load();

        stage.setTitle("FXML HelloFX");
        stage.setScene(new Scene(root));
        stage.show();
    }

    private URL resolveFxmlLocation() {
        URL packageRelative = FXMLHelloApp.class.getResource("hello-view.fxml");
        if (packageRelative != null) {
            return packageRelative;
        }

        // IntelliJ currently treats GUIProject as the source root, so resources from
        // GUIProject/src may be copied under /src/... at runtime instead of beside the class.
        URL sourceRootRelative = FXMLHelloApp.class.getResource("/src/hust/soict/hedspi/javafx/fxml/hello-view.fxml");
        if (sourceRootRelative != null) {
            return sourceRootRelative;
        }

        throw new IllegalStateException("Cannot find hello-view.fxml on the runtime classpath.");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
