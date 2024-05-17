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

    private GraphicsContext gc;
    private final int CLMNS = 7;
    private final int ROWS = 5;
    private Button buttons[];
    private Logic logic = new Logic();
    private int column;
    private boolean endGame = false;
    private int clmns[] = new int[CLMNS]; // Each index holds the index of the last mark in that column
    private boolean blueRed = false; // Blue starts

    // Initializes the controller class
    public void initialize() {
        gc = canv.getGraphicsContext2D();
        drawTable();
        initializeButtons();
        logic.initializeBoard(ROWS, CLMNS);
    }

    // Draws the game grid on the canvas.
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

    // Initializes the buttons used for column selection and assigns event handlers
    // to the buttons.
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

    // Adds a button to the specified grid cell.
    private void addButtonToGrid(GridPane grid, Button btn, int row, int column) {
        btn.setPrefSize(grid.getPrefWidth() / CLMNS,
                (grid.getPrefHeight() / CLMNS) * 3);
        grid.add(btn, row, column);
    }

    /**
     * Handles the logic when a column selection button is clicked.
     * Determines the validity of the selected column, updates the game board if
     * valid, draws the corresponding game piece, checks for a win condition, and
     * switches player turns.
     */
    private void buttonLogic(Button clickedButton) {
        column = Integer.parseInt(clickedButton.getText()) - 1; // Get the selected column index
        int row; // Variable to store the row index of the placed game piece

        if (endGame) // If game was won previously
            showAlert("Game Over", "The game finished last turn. What are you trying to do?",
                    "You must either close the window or clear the board for a new game.", false);
        else if (logic.boardFull()) { // If board if full
            showAlert("Game Over", "Neither player won",
                    "The board was filled without a winner.", false);
            endGame = true;
        }
        // Check if the selected column is valid (not full)
        else if (logic.isValid(clmns[column], column)) {
            // If the column is not full, updates the game board with the new move
            row = logic.updateBoard(clmns[column], column, blueRed);
            // Draws the corresponding game piece on the canvas
            drawCircle(row, column, blueRed); // Parameters: row, column, color
            // Checks if the game has been won
            endGame = logic.isFourInARow(row, column);
            if (endGame) {
                showAlert("Game Over", "Congratulations!",
                        blueRed ? "The red player won" : "The blue player won", true);
            }
            // Switches player turns
            blueRed = !blueRed;
        } else {
            // If the selected column is full, shows an error message
            showAlert("ERROR", "Column pressed is full",
                    "All the rows in the column pressed, column no' " + (column + 1) +
                            " , are full.\nTry choosing a different column.",
                    false);
        }
    }

    // Handles the logic when a button is clicked.
    private void handleButtonClicked(ActionEvent event) {
        // Gets the source button from the event
        Button clickedButton = (Button) event.getSource();

        // Checks if the clicked button is the clear button
        if (clickedButton.getText().equals("Clear")) {
            handleClearButtonClicked();
        } else {
            buttonLogic(clickedButton);
        }
    }

    // Handles the logic when the clear button is clicked.
    private void handleClearButtonClicked() {
        clear(); // Clears grid
        showAlert("Board cleared", null, "You may begin another game or close the window if so you wish.",
                true);

    }

    // Draws a circle representing a game piece on the canvas.
    private void drawCircle(int row, int column, Boolean player) {
        Color color;
        if (player) {
            color = Color.RED;
        } else {
            color = Color.BLUE;
        }

        double centerX = (column + 0.5) * canv.getWidth() / CLMNS; // Calculates the x-coordinate of the center of the
                                                                   // cell
        double centerY = (row + 0.5) * canv.getHeight() / ROWS; // Calculates the y-coordinate of the center of the cell
        double radius = Math.min(canv.getWidth() / CLMNS, canv.getHeight() / ROWS) / 2 * 0.8;

        gc.setFill(color); // Set the fill color
        gc.fillOval(centerX - radius, centerY - radius, radius * 2, radius * 2); // Draws the circle

    }

    // Clears the game grid and resets the game state.
    private void clear() {
        gc.clearRect(0, 0, canv.getWidth(), canv.getHeight());
        drawTable();
        logic.initializeBoard(ROWS, CLMNS);
        endGame = false;
        blueRed = false;
    }

    // Shows an alert dialog with the specified title, header, and content. The
    // alert type is indicated by the flag (true - confirmation, false - error)
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
