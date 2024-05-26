import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class LinkedListController {
    private LinkedList<String> myList;

    @FXML
    private TextField string1;

    @FXML
    private TextField string2;

    @FXML
    private TextField string3;

    @FXML
    private TextField string4;

    @FXML
    private TextField string5;

    @FXML
    private TextField string6;

    @FXML
    void cancelPressed(ActionEvent event) {
        // just close the window

    }

    @FXML
    void okPressed(ActionEvent event) {
        myList = new LinkedList<String>();
        for (int i=0; i<LinkedListTester.MAX; i++) {
            if (string1.getText().trim().isEmpty()) {
                showAlert("ERROR", "Invalid input", "Please enter a non-empty string.", false);
            }
            else {
                Node<String> newNode = new Node<String> (string1.getText());
                myList.addNode(newNode);
            }
        }

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
