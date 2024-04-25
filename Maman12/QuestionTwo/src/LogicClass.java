import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

    // check if there is a slash
    // check if there are only two numbers - one on either side of the slash
    // send to Rational constructor
    // check if Rational number was created
    public static void saveNumbers(String rationalNum, Rational firstRationalNumber, Rational secondRationalNumber) {
        try {
            String[] rational = rationalNum.split(",");
            String[] rationalOne = rational[0].split("/");
            String[] rationalTwo = rational[1].split("/");
            firstRationalNumber.setNumerator(Integer.parseInt(rationalOne[0]));
            firstRationalNumber.setDenominator(Integer.parseInt(rationalOne[1]));
            secondRationalNumber.setNumerator(Integer.parseInt(rationalTwo[0]));
            secondRationalNumber.setDenominator(Integer.parseInt(rationalTwo[1]));
            System.out.println(firstRationalNumber + " and the seond is " + secondRationalNumber);
        } catch (Exception IllegalArgumentException) {
            System.out.println("Error with input.");
        }
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
        str.append("The first number is ").append(firstRationalNumber.greaterThan(secondRationalNumber) ? "larger" : "not larger")
                .append(" than the second number.\n");
    
        // testing equals
        str.append("The first number is ").append(firstRationalNumber.equals(secondRationalNumber) ? "equal" : "not equal")
                .append(" to the second number.\n");
    
        // testing plus
        str.append("Both numbers added together equal ").append(firstRationalNumber.plus(secondRationalNumber)).append(".\n");
    
        // testing minus
        str.append("The first number minus the second number is ").append(firstRationalNumber.minus(secondRationalNumber)).append(".\n");
    
        // testing multiply
        str.append("Both numbers multiplied together equal ").append(firstRationalNumber.multiply(secondRationalNumber)).append(".\n");
    
        // testing divide
        str.append("The first number divided by the second number is ").append(firstRationalNumber.divide(secondRationalNumber)).append(".\n");
    
        return str.toString();
    }
}    