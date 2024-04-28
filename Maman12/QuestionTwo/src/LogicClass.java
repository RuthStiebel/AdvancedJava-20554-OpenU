import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class LogicClass extends Application {

    /**
     * The main method to launch the application.
     */
    public static void main(String[] args) {
        launch(args);
        System.out.println();
    }

    /**
     * Starts the JavaFX application by loading the FXML file and setting up the
     * stage.
     * 
     * @param stage The primary stage of the application.
     * @throws Exception If an error occurs while loading the FXML file.
     */
    public void start(Stage stage) throws Exception {
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("LogicClass.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("LogicClass");
        stage.setScene(scene);
        stage.show();
    }

    public static String testAllFunctions(Rational firstRationalNumber, Rational secondRationalNumber) {
        StringBuilder str = new StringBuilder();

        // testing getters
        str.append("The first number's numerator is ").append(firstRationalNumber.getNumerator())
                .append(" and its denominator is ").append(firstRationalNumber.getDenominator()).append(".\n");
        str.append("The second number's numerator is ").append(secondRationalNumber.getNumerator())
                .append(" and its denominator is ").append(secondRationalNumber.getDenominator()).append(".\n");

        // testing reduce function and toString
        str.append("The first number after reduction is ").append(firstRationalNumber.reduce()).append(".\n");
        str.append("The second number after reduction is ").append(secondRationalNumber.reduce()).append(".\n");

        // testing greaterThan
        str.append("The first number is ")
                .append(firstRationalNumber.greaterThan(secondRationalNumber) ? "larger" : "not larger")
                .append(" than the second number.\n");

        // testing equals
        str.append("The first number is ")
                .append(firstRationalNumber.equals(secondRationalNumber) ? "equal" : "not equal")
                .append(" to the second number.\n");

        // testing plus
        str.append("Both numbers added together equal ").append(firstRationalNumber.plus(secondRationalNumber))
                .append(".\n");

        // testing minus
        str.append("The first number minus the second number is ")
                .append(firstRationalNumber.minus(secondRationalNumber)).append(".\n");

        // testing multiply
        str.append("Both numbers multiplied together equal ").append(firstRationalNumber.multiply(secondRationalNumber))
                .append(".\n");
        try {
            // testing divide
            str.append("The first number divided by the second number is ")
                    .append(firstRationalNumber.divide(secondRationalNumber)).append(".\n");
        } catch (ArithmeticException e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Error");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Cannot divide by zero.");
            errorAlert.showAndWait();
        }

        return str.toString();
    }
}