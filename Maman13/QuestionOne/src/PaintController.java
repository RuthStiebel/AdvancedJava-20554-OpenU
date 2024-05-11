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

public class PaintController {
    private double startX;
    private double startY;
    private double endX;
    private double endY;
    private Stack<Shape> paintStack = new Stack<Shape>();

    @FXML
    private Pane pane;

    @FXML
    void drawAction(ActionEvent event) {

        try {

            // Load the draw options pop-up window
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Draw.fxml"));
            stage.setScene(new Scene(loader.load()));
            stage.setTitle("Draw");
            stage.showAndWait();

            // Get the controller instance
            DrawController controller = loader.getController();

            // Check if draw is requested and get selected options
            if (controller.isDrawRequested()) {
                String selectedShape = controller.getSelectedShape();
                Color selectedColor = controller.getSelectedColor();
                boolean isFilled = controller.isFilled();
                // Draw selected shape according to parameters
                Shape shape = null; // Initialize shape variable
                switch (selectedShape) {
                    case "Line":
                        shape = new Line(startX, startY, endX, endY);
                        break;
                    case "Rectangle":
                        shape = new Rectangle(startX, startY, endX - startX, endY - startY);
                        break;
                    case "Triangle":
                        // Calculate the midpoint between the start and end points
                        double midX = (startX + endX) / 2;
                        double midY = (startY + endY) / 2;

                        // Calculate the height of the triangle (distance from midpoint to end point)
                        double height = Math.sqrt(Math.pow(endX - startX, 2) + Math.pow(endY - startY, 2));

                        // Calculate the distance from the midpoint to each vertex of the triangle (use
                        // trigonometry)
                        double angle = Math.atan2(endY - startY, endX - startX); // Angle of the line from start to end
                        double angle1 = angle + Math.toRadians(150); // Angle for the first vertex
                        double angle2 = angle + Math.toRadians(210); // Angle for the second vertex

                        // Calculate the coordinates of the vertices based on the angles and height
                        double x1 = midX + height * Math.cos(angle1);
                        double y1 = midY + height * Math.sin(angle1);
                        double x2 = midX + height * Math.cos(angle2);
                        double y2 = midY + height * Math.sin(angle2);

                        // Create the triangle shape
                        shape = new Polygon(startX, startY, x1, y1, x2, y2);
                        break;
                    case "Circle":
                        shape = new Circle(startX, startY,
                                Math.sqrt(Math.pow(endX - startX, 2) + Math.pow(endY - startY, 2)));
                        break;
                }
                Color javafxColor = Color.rgb((int) selectedColor.getRed(), (int) selectedColor.getGreen(),
                        (int) selectedColor.getBlue());

                shape.setFill(javafxColor);
                if (!isFilled) {
                    shape.setStroke(selectedColor); // Set the stroke color
                    shape.setStrokeWidth(2); // Set the stroke width
                }
                pane.getChildren().add(shape); // Add the shape to the pane
                paintStack.push(shape); // Push the shape to the stack
            }
        } catch (Exception e) {
            e.printStackTrace();
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
    }

    @FXML
    void undoAction(ActionEvent event) {
        paintStack.pop();
    }

    @FXML
    void clearAction(ActionEvent event) {

    }
}