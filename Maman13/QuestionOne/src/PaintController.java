import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PaintController {

    @FXML
    private Pane pane;

    
    @FXML
    void drawAction(ActionEvent event) {
        try {
            // Load the draw options pop-up window
            FXMLLoader loader = new FXMLLoader(getClass().getResource("drawOptions.fxml"));
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(loader.load()));
            stage.setTitle("Draw Options");
            stage.showAndWait();
            
            // Get the controller instance
            DrawOptionsController controller = loader.getController();
            
            // Check if draw is requested and get selected options
            if (controller.isDrawRequested()) {
                String selectedShape = controller.getSelectedShape();
                String selectedColor = controller.getSelectedColor();
                boolean isFilled = controller.isFilled();

                // Set mouse event handlers for drawing shapes on the original pane
                pane.setOnMousePressed(e -> {
                    double startX = e.getX();
                    double startY = e.getY();

                    // Draw shape according to selected options
                    // You can implement this part based on the selected options
                    // For demonstration, let's just print the shape and its properties
                    System.out.println("Drawing " + selectedShape + " at (" + startX + ", " + startY + ")");
                    System.out.println("Color: " + selectedColor);
                    System.out.println("Filled: " + isFilled);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void undoAction(ActionEvent event) {
        
    }
    
    @FXML
    void clearAction(ActionEvent event) {

    }
}