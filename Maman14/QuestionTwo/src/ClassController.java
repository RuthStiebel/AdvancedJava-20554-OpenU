import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ClassController {

    @FXML
    void SearchPressed(ActionEvent event) {

    }

    @FXML
    void addPressed(ActionEvent event) {

    }

    @FXML
    void closePressed(ActionEvent event) {
        // close the window

    }

    @FXML
    void removePressed(ActionEvent event) {
        
        

    }

    public static void showAlert(String title, String header, String content, boolean flag) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        if (!flag) {
            alert.setAlertType(AlertType.ERROR);
        }
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

}
