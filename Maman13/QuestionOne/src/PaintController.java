import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class PaintController {

    @FXML
    private Pane pane;

    @FXML
    void clearAction(ActionEvent event) {

    }

    @FXML
    void drawAction(ActionEvent event) {
        // the idea is that when "draw" is clicked then a screen pops up and the user
        // chooses the shape(radio button), color (raio button) and fill

    }

    @FXML
    void undoAction(ActionEvent event) {

    }

}
/*
 *   @FXML
    private Canvas canv;

    @FXML
    private GridPane grid;

    GraphicsContext gc = canv.getGraphicsContext2D();
    private Button[] buttons;
    private final int NUM_OF_SHAPES = 8;
    private final int SIZE = 5;

    private void createButtons() {
        buttons = new Button[SIZE * SIZE];
        for (int i = 0; i < SIZE * SIZE; i++) {
            buttons[i] = new Button();
            buttons[i].setPrefSize(grid.getPrefWidth() / SIZE, grid.getPrefHeight() / SIZE);
            buttons[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    handleButton(e);
                }
            });
            grid.add(buttons[i], i % SIZE, i / SIZE);
        }
    }

    private void handleButton(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleButton'");

 */