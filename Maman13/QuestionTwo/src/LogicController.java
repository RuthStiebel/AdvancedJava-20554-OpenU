import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class LogicController {

    @FXML
    private GridPane grid;
    
    private final int SIZE = 7;

    private Button buttons[];

    public void initialize() {
        buttons = new Button[SIZE * SIZE];

        for (int i = 0; i < SIZE * (SIZE - 1); i++) {
            if (i < 42 || i == 46) {
                if (i == 46) // the center of the bottom line is the clear button
                    buttons[i] = new Button("Clear");
                else
                    buttons[i] = new Button();
                buttons[i].setPrefSize(grid.getPrefWidth() / SIZE,
                        grid.getPrefHeight() / SIZE);
                grid.add(buttons[i], i % SIZE, i / SIZE);
                buttons[i].setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle (ActionEvent event) {

                    }
                });
            }
        }

    }

}

// here we build the board, colour the circles and print messages to the user
