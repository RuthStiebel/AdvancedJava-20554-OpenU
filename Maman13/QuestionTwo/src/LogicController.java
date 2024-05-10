import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class LogicController {

    @FXML
    private Canvas canv;

    @FXML
    private GridPane grid;

    private GraphicsContext gc; // Graphics context for drawing on the canvas

    private final int SIZE = 7;

    private Button buttons[];
    private int column;
    private int squares[]; //each index hold the index of the last mark in that column

    /**
     * Initializes the controller class.
     */
    public void initialize() {
        gc = canv.getGraphicsContext2D();
        drawTable();
        initializeButtons();
    }
    
    private void drawTable() {
        // Drawing black lines for the grid
        int rows = 5; // Number of rows
        int columns = 7; // Number of columns
        double cellWidth = canv.getWidth() / columns;
        double cellHeight = canv.getHeight() / rows;
    
        for (int i = 0; i <= columns; i++) {
            double x = i * cellWidth;
            gc.strokeLine(x, 0, x, canv.getHeight()); // Vertical lines
        }
    
        for (int i = 0; i <= rows; i++) {
            double y = i * cellHeight;
            gc.strokeLine(0, y, canv.getWidth(), y); // Horizontal lines
        }
    }
    
    private void initializeButtons() {
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
                grid.getPrefHeight() / SIZE*1.5);
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
