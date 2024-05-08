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

        for (int i = 0; i < SIZE * SIZE; i++) {
            if (i < 35 || i == 45) {
                if (i == 45) // the center of the bottom line is the clear button
                {
                    buttons[i] = new Button("Clear");
                    System.out.println("HERE");
                }
                else
                    buttons[i] = new Button();
                buttons[i].setPrefSize(grid.getPrefWidth() / SIZE,
                        grid.getPrefHeight() / SIZE);
                grid.add(buttons[i], i % SIZE, i / SIZE);
              /*  buttons[i].setOnAction(new EventHandler<ActionEvent>() {
                    
                    @Override
                    public void handle (ActionEvent event) {

                    }
                }); */
            }
            if (i>35 && i <43) {
                //new to add numbers not buttons
            }
        }

    }

}

// here we build the board, colour the circles and print messages to the user
