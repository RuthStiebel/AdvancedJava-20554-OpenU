import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.canvas.Canvas;
public class LogicController {

    @FXML
    private Canvas canv;

    @FXML
    private GridPane grid;

    private final int SIZE = 7;

    private Button buttons[];
    private Button clearButton;

    public void initialize() {
        buttons = new Button[SIZE];
        clearButton = new Button("Clear");
        addButtonToGrid(grid, clearButton, 1, SIZE/2);

        for (int i = 0; i < SIZE; i++) {
                buttons[i] = new Button(i+"");
                addButtonToGrid(grid, buttons[i], 0, i);

                buttons[i].setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {

                    }
                });

            }
        }

    private void addButtonToGrid(GridPane grid, Button btn, int row, int column) {
        btn.setPrefSize(grid.getPrefWidth() / SIZE,
                grid.getPrefHeight() / SIZE);
        grid.add(btn, row, column);
    }

    private static void handleButtonClicked (int row, int column) {

    }

    private static void handleClearButtonClicked () {
        //clear grid
        showAlert("Board cleared", null, "You may begin another game or exit the consule.");

    }

    private static void showAlert (String title, String header, String content) {

    }
}

// here we build the board, colour the circles and print messages to the user
