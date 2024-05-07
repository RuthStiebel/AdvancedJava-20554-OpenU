import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class DrawOptionsController {

    @FXML
    private RadioButton circleRadioButton;

    @FXML
    private RadioButton rectangleRadioButton;

    @FXML
    private ToggleGroup shapeToggleGroup;

    @FXML
    private RadioButton redRadioButton;

    @FXML
    private RadioButton blueRadioButton;

    @FXML
    private ToggleGroup colorToggleGroup;

    @FXML
    private RadioButton fillRadioButton;

    @FXML
    private ToggleGroup fillToggleGroup;

    private boolean drawRequested = false;
    private String selectedShape;
    private String selectedColor;
    private boolean isFilled;

    @FXML
    void drawAction(ActionEvent event) {
        // Set selected options
        selectedShape = ((RadioButton) shapeToggleGroup.getSelectedToggle()).getText();
        selectedColor = ((RadioButton) colorToggleGroup.getSelectedToggle()).getText();
        isFilled = fillToggleGroup.getSelectedToggle() == fillRadioButton;

        // Indicate that draw is requested
        drawRequested = true;

        // Close the pop-up window
        Stage stage = (Stage) circleRadioButton.getScene().getWindow();
        stage.close();
    }

    public boolean isDrawRequested() {
        return drawRequested;
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
