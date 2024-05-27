import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class LinkedListController {

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
    void okPressed(ActionEvent event) {
        LinkedList<String> myList = new LinkedList<String>();
        TextField[] textFields = { string1, string2, string3, string4, string5, string6 };
        boolean showAlert = false; // Flag to track if an alert has been shown

        for (int i = 0; i < textFields.length; i++) {
            TextField textField = textFields[i];
            if (textField.getText().trim().isEmpty()) {
                showAlert("ERROR", "Invalid input", "All fields must contain at least one non-whitespace character.",
                        false);
                showAlert = true; // Set flag to true if an alert is shown
                break; // Exit the loop if an alert is shown
            } else {
                Node<String> newNode = new Node<String>(textField.getText());
                myList.addNode(newNode);
            }
        }

        // Reset linked list if an alert was shown
        if (showAlert) {
            myList = null;
        } else {
            // show lsit, flip it and then show the flipped list
            showAlert(null, "The list inputted is:", myList.toString(), true);
            myList = myList.flipList();
            showAlert(null, "The list after traversing is:", myList.toString(), true);
        }
        //create person list, show it and show the oldest person in the list 
        LinkedList<Person> personLinkedList = LinkedListTester.personList();
        showAlert(null, "The person list is:", personLinkedList.toString(), true);
     //   showAlert(null, "The oldest person on the list is:", personLinkedList.toString(), true);
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
