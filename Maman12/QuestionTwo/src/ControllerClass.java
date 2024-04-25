import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ControllerClass {

    @FXML
    private void startPressed(ActionEvent event) {
        // Create an alert dialog
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setTitle(null); // Set the title of the alert
        alert.setHeaderText("Each column represents a rational number, "
                + " where the numerator is the number on top and the denominator is the lower number.\n"
                + "The numerator is a whole number and the denomantor is a positive number.\n\n");

        // Create a GridPane to organize the layout
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10); // Set horizontal gap between nodes
        gridPane.setVgap(10); // Set vertical gap between nodes

        // Create labels and text fields for each number
        Label[] labels = new Label[4]; // Array to store labels
        TextField[] textFields = new TextField[4]; // Array to store text fields

        String[] names = { "First number numerator:", "Second number numerator:", "First number denominator:",
                "Second number denominator:" }; // Names for the// numbers

        for (int i = 0; i < 4; i++) {
            // Create labels for each number
            labels[i] = new Label(names[i]);
            // Create text fields for user input
            textFields[i] = new TextField();
            // Add labels and text fields to the grid pane
            gridPane.add(labels[i], i % 2 == 0 ? 0 : 2, i / 2);
            gridPane.add(textFields[i], i % 2 == 0 ? 1 : 3, i / 2);
        }

        // Set the content of the alert dialog to the grid pane
        alert.getDialogPane().setContent(gridPane);

        // Add OK and Cancel buttons to the alert dialog
        alert.getButtonTypes().add(ButtonType.OK);
        alert.getButtonTypes().add(ButtonType.CANCEL);

        // Handle OK button click
        alert.showAndWait().ifPresent(result -> {
            if (result == ButtonType.OK) {
                int[] numbers = new int[4];
                try {
                    // Parse the numbers entered by the user
                    for (int i = 0; i < 4; i++) {
                        String input = textFields[i].getText();
                        if (!input.isEmpty()) {
                            numbers[i] = Integer.parseInt(input);
                        } else {
                            throw new NumberFormatException(); // Empty input is considered invalid
                        }
                    }
                    Rational firstRationalNumber = new Rational(numbers[0], numbers[2]);
                    Rational secondRationalNumber = new Rational(numbers[1], numbers[3]);
                    String message = LogicClass.testAllFunctions (firstRationalNumber, secondRationalNumber);
                    Alert inform = new Alert(Alert.AlertType.NONE);
                    inform.setTitle(null); // Set the title of the alert
                    inform.setHeaderText(message);
                    inform.getButtonTypes().add(ButtonType.OK);
                    inform.showAndWait();


                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    // Handle invalid input
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setTitle("Error");
                    errorAlert.setHeaderText(null);
                    errorAlert.setContentText("Please enter valid numbers.");
                    errorAlert.showAndWait();
                }
            }
        });
    }
}