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

    /**
     * Handles the action when the "OK" button is pressed.
     * Validates input text fields, creates a linked list of strings, and performs
     * actions accordingly.
     * If any input field is empty, shows an error alert and resets the linked list.
     * Otherwise, displays the input list, flips it, and shows the flipped list.
     * Additionally, generates a linked list of persons, displays it, and shows the
     * oldest person in the list.
     * 
     * @param event The action event triggered by pressing the "OK" button.
     */
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
                showAlert = true; // Sets flag to true if an alert is shown
                break; // Exits the loop if an alert is shown
            } else {
                Node<String> newNode = new Node<String>(textField.getText());
                myList.addNode(newNode);
            }
        }

        // Resets linked list if an alert was shown
        if (showAlert) {
            myList = null;
        } else {
            // Shows list, flisp it, and then shows the flipped list
            showAlert(null, "The list inputted is:", myList.toString(), true);
            myList = myList.flipList();
            showAlert(null, "The list after flipping is:", myList.toString(), true);
        }

        // Creates a person list, shows it, and shows the oldest person in the list
        LinkedList<Person> personLinkedList = LinkedListTester.personList();
        showAlert(null, "The person list is:", personLinkedList.toString(), true);
        Person oldestPerson = Max.max(personLinkedList).getContent();
        showAlert(null, "The oldest person on the list is:", oldestPerson.toString(), true);
    }

    /**
     * Displays an alert dialog with the specified title, header, and content.
     * 
     * @param title   The title of the alert dialog.
     * @param header  The header text of the alert dialog.
     * @param content The content text of the alert dialog.
     * @param flag    A flag indicating whether the alert type is informational
     *                (true) or an error (false).
     */
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
