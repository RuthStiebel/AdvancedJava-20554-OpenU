import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class PaintController {

    @FXML
    private Canvas canv;

    @FXML
    private GridPane grid;


    GraphicsContext gc = canv.getGraphicsContext2D();
    
    @FXML
    void mouseClicked(MouseEvent event) {

    }

}
