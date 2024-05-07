import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class DrawOptionsController {

    @FXML
    private ToggleGroup Colour;

    @FXML
    private ToggleGroup Fill;

    @FXML
    private ToggleGroup Shape;

    @FXML
    private RadioButton blackColour;

    @FXML
    private RadioButton blueColour;

    @FXML
    private RadioButton circleShape;

    @FXML
    private RadioButton emptyFill;

    @FXML
    private RadioButton fullFill;

    @FXML
    private RadioButton greenColour;

    @FXML
    private RadioButton lineShape;

    @FXML
    private RadioButton redColour;

    @FXML
    private RadioButton squareShape;

    @FXML
    private RadioButton starShape;

    @FXML
    private RadioButton triangleShape;

    @FXML
    private RadioButton yellowColour;

    private boolean confirmPressed = false;
    private String selectedShape;
    private String selectedColor;
    private boolean isFilled;

    @FXML
    void confirmPressed(ActionEvent event) {
        // Get selected shape
        RadioButton selectedShapeRadioButton = (RadioButton) Shape.getSelectedToggle();
        selectedShape = selectedShapeRadioButton.getText();

        // Get selected color
        RadioButton selectedColorRadioButton = (RadioButton) Colour.getSelectedToggle();
        selectedColor = selectedColorRadioButton.getText();

        // Get selected fill option
        isFilled = Fill.getSelectedToggle() == fullFill;

        // Set confirmPressed flag to true
        confirmPressed = true;

        // Close the window
        Stage stage = (Stage) circleShape.getScene().getWindow();
        stage.close();
    }

    public boolean isDrawRequested() {
        return confirmPressed;
    }

    public String getSelectedShape() {
        return selectedShape;
    }

    public String getSelectedColor() {
        return selectedColor;
    }

    public boolean isFilled() {
        return isFilled;
    }
}
