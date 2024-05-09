import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class LogicController {

    @FXML
    private GridPane topGrid;

    @FXML
    private GridPane buttonGrid;

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
                } else
                    buttons[i] = new Button();
                buttons[i].setPrefSize(grid.getPrefWidth() / SIZE,
                        grid.getPrefHeight() / SIZE);
                grid.add(buttons[i], i % SIZE, i / SIZE);
                /*
                 * buttons[i].setOnAction(new EventHandler<ActionEvent>() {
                 * 
                 * @Override
                 * public void handle (ActionEvent event) {
                 * 
                 * }
                 * });
                 */
            }
            if (i > 35 && i < 43) {
                int number = i - 35; // Numbers 1 to 7
                Text text = new Text(Integer.toString(number));
                text.setStyle("-fx-font-size: 20;"); // Set font size
                grid.add(text, (i - 36) % SIZE, SIZE);            
            }
        }
    }

}

// here we build the board, colour the circles and print messages to the user
