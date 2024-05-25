import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class LinkedListController {

    @FXML
    private TextField fiveString;

    @FXML
    private TextField fourString;

    @FXML
    private TextField oneString;

    @FXML
    private TextField sixString;

    @FXML
    private TextField threeString;

    @FXML
    private TextField twoString;

    @FXML
    void cancelPressed(ActionEvent event) {

    }

    @FXML
    void okPressed(ActionEvent event) {

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
