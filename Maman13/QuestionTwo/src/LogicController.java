import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class LogicController {

    @FXML
    private Canvas canv;

    @FXML
    private GridPane grid;

    private GraphicsContext gc; // Graphics context for drawing on the canvas

    private final int CLMNS = 7;
    private final int ROWS = 5;
    private Button buttons[];
    private Logic logic = new Logic();
    private int column;
    private boolean endGame = false;
    private int clmns[] = new int[CLMNS]; // each index hold the index of the last mark in that column
    private boolean blueRed = false; // red starts

    /**
     * Initializes the controller class.
     */
    public void initialize() {
        gc = canv.getGraphicsContext2D();
        drawTable();
        initializeButtons();
        logic.initializeBoard(ROWS, CLMNS);
    }

    private void drawTable() {
        // Drawing black lines for the grid
        for (int i = 0; i <= CLMNS; i++) {
            double x = i * canv.getWidth() / CLMNS;
            gc.strokeLine(x, 0, x, canv.getHeight()); // Vertical lines
        }

        for (int i = 0; i <= ROWS; i++) {
            double y = i * canv.getHeight() / ROWS;
            gc.strokeLine(0, y, canv.getWidth(), y); // Horizontal lines
        }
    }

    private void initializeButtons() {
        buttons = new Button[CLMNS + 1];
        for (int i = 0; i < CLMNS + 1; i++) {
            if (i == CLMNS) {
                buttons[i] = new Button("Clear");
                addButtonToGrid(grid, buttons[i], CLMNS / 2, 1);
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

    private void addButtonToGrid(GridPane grid, Button btn, int row, int column) {
        btn.setPrefSize(grid.getPrefWidth() / CLMNS,
                (grid.getPrefHeight() / CLMNS) * 3);
        grid.add(btn, row, column);
    }

    private void buttonLogic(Button clickedButton) {
        column = Integer.parseInt(clickedButton.getText()) - 1;
        int row;
        if (logic.isValid(clmns[column], column)) { // check if the column is full
            // if not then draw correct circle
            row = logic.updateBoard(clmns[column], column, blueRed);
            drawCircle(row, column, blueRed); // row, column, colour
            endGame = logic.isFourInARow(row, column);
            if (endGame) { // the game finished
                showAlert("Game Over", "Congradulations!", blueRed ? "The blue player won" : "The red player won", true);
            }
            if (blueRed) // switch turn
                blueRed = false;
            else
                blueRed = true;
        } else {
            showAlert("ERROR", "Column pressed is full",
                    "All the rows in the column pressed, column no' " + column + " , are full.\nTry again.", false);
        }
    }

    private void handleButtonClicked(ActionEvent event) {
        // Get the source button from the event
        Button clickedButton = (Button) event.getSource();

        // Check if the clicked button is the clear button
        if (clickedButton.getText().equals("Clear")) {
            handleClearButtonClicked();
        } else {
            buttonLogic(clickedButton);
        }
    }

    private void handleClearButtonClicked() {
        clear(); // clear grid
        showAlert("Board cleared", null, "You may begin another game or close it if you so wish.",
                true);

    }

    private void drawCircle(int row, int column, Boolean player) {
        Color color;
        if (player) {
            color = Color.RED; // red
        } else {
            color = Color.BLUE; // blue
        }

        double centerX = (column + 0.5) * canv.getWidth() / CLMNS; // Calculate the x-coordinate of the center of the cell
        double centerY = (row + 0.5) * canv.getHeight() / ROWS; // Calculate the y-coordinate of the center of the cell
        double radius = Math.min(canv.getWidth() / CLMNS, canv.getHeight() / ROWS) / 2 * 0.8;

        gc.setFill(color); // Set the fill color
        gc.fillOval(centerX - radius, centerY - radius, radius * 2, radius * 2); // Draw the circle

    }

    private void clear() {
        gc.clearRect(0, 0, canv.getWidth(), canv.getHeight()); // Clear the canvas
        drawTable();
        logic.initializeBoard(ROWS, CLMNS);
    }

    private static void showAlert(String title, String header, String content, boolean flag) {
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
