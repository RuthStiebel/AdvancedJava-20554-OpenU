import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ControllerClass {

    @FXML
    void startProgramPressed(ActionEvent event) {
      Alert inform = new Alert(Alert.AlertType.NONE);
      inform.setTitle(null); // Set the title of the alert
      inform.setHeaderText("hey");
      inform.getButtonTypes().add(ButtonType.OK);
      inform.showAndWait();
    }

}

