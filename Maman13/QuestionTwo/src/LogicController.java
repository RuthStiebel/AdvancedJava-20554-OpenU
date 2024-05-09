import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;


public class LogicController {

    @FXML
    private GridPane topGrid;

    private final int SIZE = 7;

    private Button buttons[];

    public void initialize() {
        buttons = new Button[SIZE * SIZE];

        for (int i = 0; i < SIZE * SIZE; i++) {
            if (i < 35 ) {
                    buttons[i] = new Button();
                    addButtonToGrid(topGrid, buttons[i], i);

                
                 buttons[i].setOnAction(new EventHandler<ActionEvent>() {
                 
                 @Override
                 public void handle (ActionEvent event) {
                 
                 }
                 });
                
            }
            //TODO need to add numbers under the columns
            if (i == 45) // the center of the bottom line is the clear button
            {
                buttons[i] = new Button("Clear");
                addButtonToGrid(topGrid, buttons[i], i);
            }
        }
    }

    private void addButtonToGrid(GridPane grid, Button btn, int place) {
        btn.setPrefSize(grid.getPrefWidth() / SIZE,
                grid.getPrefHeight() / SIZE);
        grid.add(btn, place % SIZE, place / SIZE);
    }
}

// here we build the board, colour the circles and print messages to the user
