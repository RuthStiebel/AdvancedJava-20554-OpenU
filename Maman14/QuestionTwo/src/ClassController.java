import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
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
        String str = myDict.searchWord(text.getText());
        if (str.contains(":")) {
            showAlert(null, null, str, true);

        } else
            showAlert("Error", "Oops!", "Word not found.", false);
    }

    @FXML
    void addPressed(ActionEvent event) {
        TextInputDialog definition = new TextInputDialog();
        definition.setHeaderText("Enter word definition:");
    
        // Show the text input dialog and wait for user input
        definition.showAndWait().ifPresent(result -> {
            // After user input, try to add the word to the dictionary
            String str = myDict.addWord(text.getText(), result);
            if (str == null) {
                showAlert("Success", "Yay!", "Word added successfully.", true);
                str = myDict.toString();
                showAlert(null, "Dictionary after word addition:", str, true);
            } else {
                showAlert("Error", "Oops!", str, false);
            }
        });
    }
    
    @FXML
    void removePressed(ActionEvent event) {
        String str = myDict.removeWord(text.getText());
        if (str == null) {
            showAlert("Success", "Yay!", "Word removed successfully.", true);
            str = myDict.toString();
            showAlert(null, "Dictionary after word removal:", str, true);

        } else
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
