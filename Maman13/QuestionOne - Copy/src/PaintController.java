import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

import java.util.Stack;

public class PaintController {

    // Enum for shape type
    public enum ShapeType {
        CIRCLE,
        RECTANGLE,
        LINE
    }

    // Enum for shape fill
    public enum ShapeFill {
        SOLID,
        OUTLINE
    }

    private ShapeType type;
    private Color color; 
    private ShapeFill fill;

    @FXML
    private MenuItem circle;

    @FXML
    private Button clearButton;

    @FXML
    private Button colorButton;

    @FXML
    private MenuButton fillMenu;

    @FXML
    private MenuItem line;

    @FXML
    private MenuItem rectangle;

    @FXML
    private MenuButton typeButton;

    @FXML
    private Button undo;

    @FXML
    private Pane pane;

    private double startX;
    private double startY;
    private double endX;
    private double endY;
    private Stack<javafx.scene.shape.Shape> shapesStack = new Stack<>();

    @FXML
    void circleChosen(ActionEvent event) {
        setType(ShapeType.CIRCLE);
    }

    @FXML
    void clearPressed(ActionEvent event) {
        pane.getChildren().clear();
        shapesStack.clear();
    }

    @FXML
    void colorPressed(ActionEvent event) {
        // Implement color selection logic here
    }

    @FXML
    void emptyPressed(ActionEvent event) {
        setFill(ShapeFill.SOLID);
    }

    @FXML
    void lineAction(ActionEvent event) {
        setType(ShapeType.LINE);
    }

    @FXML
    void rectangle(ActionEvent event) {
        setType(ShapeType.RECTANGLE);
    }

    @FXML
    void solidPressed(ActionEvent event) {
        setFill(ShapeFill.SOLID);
    }

    @FXML
    void undoPressed(ActionEvent event) {
        if (!shapesStack.isEmpty()) {
            pane.getChildren().remove(shapesStack.pop());
        }
    }

    @FXML
    void mousePressed(MouseEvent e) {
        startX = e.getX();
        startY = e.getY();
    }

    @FXML
    void mouseReleased(MouseEvent e) {
        endX = e.getX();
        endY = e.getY();
        drawShape();
    }

    private void setType(ShapeType type) {
        this.type = type;
        typeButton.setText(type.toString());
    }

    private void setFill(ShapeFill fill) {
        this.fill = fill;
        fillMenu.setText(fill.toString());
    }

    private void drawShape() {
        javafx.scene.shape.Shape shape = null;
        switch (type) {
            case LINE:
                shape = new Line(startX, startY, endX, endY);
                break;
            case RECTANGLE:
                shape = new Rectangle(startX, startY, Math.abs(endX - startX), Math.abs(endY - startY));
                break;
            case CIRCLE:
                shape = new Circle(startX, startY, Math.sqrt(Math.pow(endX - startX, 2) + Math.pow(endY - startY, 2)));
                break;
        }

        shape.setStroke(Color.BLACK); // Set default stroke color
        shape.setStrokeWidth(2); // Set default stroke width

        if (fill == ShapeFill.SOLID) {
            shape.setFill(Color.TRANSPARENT); // Fill color will be set later
        } else {
            shape.setFill(Color.TRANSPARENT); // Outline shape, no fill
        }

        pane.getChildren().add(shape);
        shapesStack.push(shape);
    }
}
