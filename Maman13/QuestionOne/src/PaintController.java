import java.util.Stack;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
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

            // Load the draw options pop-up window
        
            if (endX < startX) {
                double tmp = endX;
                endX = startX;
                startX = tmp;
                tmp = Math.max(startY, endY);
                endY = Math.min(startY, endY);
                startY = tmp;
            }
                // Draw selected shape according to parameters
                Shape shape = null; // Initialize shape variable
                switch (selectedShape) {
                    case "Line":
                        shape = new Line(startX, startY, endX, endY);
                        break;
                    case "Rectangle":
                        shape = new Rectangle(startX, startY, Math.abs(endX - startX), Math.abs(endY - startY));
                        break;
                    case "Circle":
                        shape = new Circle(startX, startY,
                                Math.sqrt(Math.pow(endX - startX, 2) + Math.pow(endY - startY, 2)));
                        break;
                }
                shape.setStroke(selectedColor); // Set the stroke color
                shape.setStrokeWidth(2); // Set the stroke width
                if (isFilled) {
                    shape.setFill(selectedColor);
                } else {
                    // Assuming selectedColor is a Color object
                    shape.setFill(selectedColor.deriveColor(0, 1, 1, 0)); // Set the fill color with transparency
                }
                pane.getChildren().add(shape); // Add the shape to the pane
                paintStack.push(shape); // Push the shape to the stack
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void colorPicked(ActionEvent event) {
    
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
    void lineChosen(ActionEvent event) {
    
    }
    
    @FXML
    void circleChosen(ActionEvent event) {
    
    }
    
    @FXML
    void rectangleChosen(ActionEvent event) {
    
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
    }

    @FXML
    void undoPressed(ActionEvent event) {
        if (!paintStack.isEmpty()) { // Check if the stack is not empty
            Shape lastShape = paintStack.pop(); // Pop the last added shape from the stack
            pane.getChildren().remove(lastShape); // Remove the shape from the Pane
        }
    }

    @FXML
    void clearPressed(ActionEvent event) {
        pane.getChildren().clear(); // Remove all children from the Pane
    }
    
}




