import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ControllerClass {

    @FXML
    public static void startProgramPressed(ActionEvent event) {
      //cast stringbuilder to string
      Alert inform = new Alert(Alert.AlertType.NONE);
      inform.setTitle(null); // Set the title of the alert
      inform.setHeaderText("hey");
      inform.getButtonTypes().add(ButtonType.OK);
      inform.showAndWait();
    }
}
