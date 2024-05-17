import java.util.Stack;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.control.ColorPicker;

public class PaintController {
    private double startX;
    private double startY;
    private double endX;
    private double endY;
    private Stack<Shape> paintStack = new Stack<Shape>();
    private String selectedShape;
    private Color selectedColor;
    private boolean isFilled;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private Pane pane;

    @FXML
    void drawPressed(ActionEvent event) {

        try {
            // Draws the selected shape according to parameters
            Shape shape = null; // Initializes shape variable
            switch (selectedShape) {
                case "Circle":
                    shape = new Circle(startX, startY,
                            Math.sqrt(Math.pow(endX - startX, 2) + Math.pow(endY - startY, 2)));
                    break;
                case "Line":
                    shape = new Line(startX, startY, endX, endY);
                    break;
                case "Rectangle":
                    shape = new Rectangle(Math.min(startX, endX), Math.min(startY, endY), Math.abs(endX - startX),
                            Math.abs(endY - startY));
                    break;
            }
            shape.setStroke(selectedColor); // Sets the stroke color
            shape.setStrokeWidth(2); // Sets the stroke width
            if (isFilled) {
                shape.setFill(selectedColor);
            } else {
                shape.setFill(null); // Sets the fill color with transparency
            }
            pane.getChildren().add(shape); // Adds the shape to the pane
            paintStack.push(shape); // Pushes the shape to the stack
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void colorPicked(ActionEvent event) {
        selectedColor = colorPicker.getValue();
    }

    @FXML
    void emptyChosen(ActionEvent event) {
        isFilled = false;
    }

    @FXML
    void solidChosen(ActionEvent event) {
        isFilled = true;
    }

    @FXML
    void circleChosen(ActionEvent event) {
        selectedShape = "Circle";
    }

    @FXML
    void lineChosen(ActionEvent event) {
        selectedShape = "Line";
    }

    @FXML
    void rectangleChosen(ActionEvent event) {
        selectedShape = "Rectangle";
    }

    // Gets the starting coordinates for the shape
    @FXML
    void mousePressed(MouseEvent e) {
        startX = e.getX();
        startY = e.getY();

    }

    // Gets the ending coordinates for the shape
    @FXML
    void mouseReleased(MouseEvent e) {
        endX = e.getX();
        endY = e.getY();
    }

    @FXML
    void undoPressed(ActionEvent event) {
        if (!paintStack.isEmpty()) {
            Shape lastShape = paintStack.pop(); // Pops the last added shape from the stack
            pane.getChildren().remove(lastShape); // Removes the shape from the pane
        }
    }

    @FXML
    void clearPressed(ActionEvent event) {
        pane.getChildren().clear(); // Removes all children from the pane
    }

}
