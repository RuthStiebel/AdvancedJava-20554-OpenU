import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Logic extends Application {
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
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("Logic.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Logic");
        stage.setScene(scene);
        stage.show();
    }
    // here we check whos turn is it, did they win and if the board is full

}
/*
 * Logic Class:
 * 
 * isCircleDrawn(Button button): Checks if a circle is drawn in the specified
 * button.
 * isButtonsBelowHaveCircles(Button button, Button[][] board, int column):
 * Checks if all buttons below the specified button in the same column have
 * circles.
 * isFourInARow(Button[][] board, int row, int column): Checks if the placement
 * of a circle at the specified row and column results in four circles of the
 * same type (either horizontally, vertically, or diagonally) in a row,
 * indicating a win condition.
 * 
 * 
 */
