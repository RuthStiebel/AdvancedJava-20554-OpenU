import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.canvas.Canvas;

public class LogicController {

    @FXML
    private Canvas canv;

    @FXML
    private GridPane grid;

    private final int SIZE = 7;

    private Button buttons[];
    private int column;

    public void initialize() {
        buttons = new Button[SIZE + 1];

        for (int i = 0; i < SIZE + 1; i++) {
            if (i == SIZE) {
                buttons[i] = new Button("Clear");
                addButtonToGrid(grid, buttons[i], SIZE / 2, 1);
            } else {
                buttons[i] = new Button((i + 1) + "");
                addButtonToGrid(grid, buttons[i], i, 0);
            }
            buttons[i].setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    handleButtonClicked(event);
                }
            });

        }
    }

    private void handleButtonClicked(ActionEvent event) {
        // Get the source button from the event
        Button clickedButton = (Button) event.getSource();

        // Check if the clicked button is the clear button
        if (clickedButton.getText().equals("Clear")) {
            handleClearButtonClicked();
        } else {
            // Place circle or handle other relevant logic
            // Extract the column from the clicked button's ID or other means
            column = Integer.parseInt(clickedButton.getText()) - 1;
            // Call a method to place a circle or handle the game logic
            // For example:
            // placeCircle(column); // Method to place a circle at the specified column
            // or
            // handleOtherLogic(column); // Method to handle other game logic
        }
    }

    private void addButtonToGrid(GridPane grid, Button btn, int row, int column) {
        btn.setPrefSize(grid.getPrefWidth() / SIZE,
                grid.getPrefHeight() / SIZE);
        grid.add(btn, row, column);
    }

    private static void handleClearButtonClicked() {
        // clear grid
        LogicController.showAlert("Board cleared", null, "You may begin another game or close it if you so wish.");

    }

    protected static void showAlert(String title, String header, String content) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}

// here we build the board, colour the circles and print messages to the user
