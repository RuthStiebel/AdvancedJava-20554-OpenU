import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ClassController {
    private Dictionary myDict = new Dictionary();

    @FXML
    private TextField text;

    @FXML
    void SearchPressed(ActionEvent event) {

    }

    @FXML
    void addPressed(ActionEvent event) {

    }

    @FXML
    void closePressed(ActionEvent event) {

    }

    @FXML
    void removePressed(ActionEvent event) {
        String str = myDict.removeWord(text.getText());
        if (str == null)
            showAlert("Success", "Yay!", "Word removed successfully.", true);
        else
            showAlert("Error", "Oops!", str, false);

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
