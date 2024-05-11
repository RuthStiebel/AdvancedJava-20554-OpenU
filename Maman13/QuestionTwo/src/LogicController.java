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
        clear();
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
                    logic.handleButtonClicked(event);
                }
            });
        }
    }

    public void drawCircle(int row, int column, Boolean player) {
        System.out.println("HOLA");
        Color color;
        if (player) {
            color = new Color(255, 0, 0, 1);
        } else {
            color = new Color(0, 0, 255, 1);
        }
        double cellWidth = canv.getWidth() / CLMN;
        double cellHeight = canv.getHeight() / 5;
        double radius = Math.min(cellWidth, cellHeight) / 2 * 0.8; // Adjust the radius to fit within the cell

        double centerX = (column + 0.5) * cellWidth; // Calculate the x-coordinate of the center of the cell
        double centerY = (row + 0.5) * cellHeight; // Calculate the y-coordinate of the center of the cell

        gc.setFill(color); // Set the fill color
        gc.fillOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius); // Draw the circle
    }

    private void addButtonToGrid(GridPane grid, Button btn, int row, int column) {
        btn.setPrefSize(grid.getPrefWidth() / CLMN,
                (grid.getPrefHeight() / CLMN) * 3);
        grid.add(btn, row, column);
    }

    public void clear() {
        // Clear the canvas by filling it with white color
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canv.getWidth(), canv.getHeight());
    }

    public static void showAlert(String title, String header, String content, boolean flag) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        if (!flag) {
            alert.setAlertType(AlertType.ERROR);
            ;
        }
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
