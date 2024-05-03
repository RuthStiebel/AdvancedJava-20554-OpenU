import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class PaintController {

    @FXML
    private Canvas canv;

    @FXML
    private GridPane grid;


    GraphicsContext gc = canv.getGraphicsContext2D();
    private Button[] buttons;
    private final int NUM_OF_SHAPES = 8;

    private void createButtons () {
        
    }
    @FXML
    void mouseClicked(MouseEvent event) {

    }

}
