package hust.soict.hedspi.javafx.fxml;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label statusLabel;

    @FXML
    private void handleClick() {
        statusLabel.setText("FXML + Controller is working.");
    }
}
