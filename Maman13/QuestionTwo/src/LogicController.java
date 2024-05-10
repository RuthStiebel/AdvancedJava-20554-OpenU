import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class LogicController {

    @FXML
    private Canvas canv;

    @FXML
    private GridPane grid;

    private GraphicsContext gc; // Graphics context for drawing on the canvas

    private final int CLMN = 7;
    private Button buttons[];
    private Logic logic;

    /**
     * Initializes the controller class.
     */
    public void initialize() {
        logic = new Logic();
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
        buttons = new Button[CLMN + 1];

        for (int i = 0; i < CLMN + 1; i++) {
            if (i == CLMN) {
                buttons[i] = new Button("Clear");
                addButtonToGrid(grid, buttons[i], CLMN / 2, 1);
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
            logic.buttonLogic(clickedButton);
        }
    }

    private void addButtonToGrid(GridPane grid, Button btn, int row, int column) {
        btn.setPrefSize(grid.getPrefWidth() / CLMN,
                (grid.getPrefHeight() / CLMN) * 3);
        grid.add(btn, row, column);
    }

    public void drawCircle(int row, int column, Color color) {
        double radius = canv.getWidth() / CLMN / 2; // Calculate radius based on canvas size and number of columns
        double x = clmns[column] - radius; // Calculate x-coordinate
        double y = rows[row] - radius; // Calculate y-coordinate

        Circle circle = new Circle(x, y, radius, color); // Create a new circle with specified color
        canv.getChildren().add(circle); // Add the circle to the canvas
    }

    private static void handleClearButtonClicked() {
        // clear grid
        LogicController.showAlert("Board cleared", null, "You may begin another game or close it if you so wish.",
                true);

    }

    protected static void showAlert(String title, String header, String content, boolean flag) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        if (!flag) {
            alert.setAlertType(AlertType.ERROR);;
        } 
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}

// here we build the board, colour the circles and print messages to the user
