import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Logic extends Application {
    private int column;
    private final int CLMN = 7;
    private final int ROW = 5;
    private int clmns[]; // each index hold the index of the last mark in that column
    private LogicController logicController;
    private boolean blueRed = false; // red starts
    private boolean endGame = false;

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
    public void game() {
        logicController = new LogicController();
        clmns = new int[CLMN];

    }

    public void buttonLogic(Button clickedButton) {
        column = Integer.parseInt(clickedButton.getText()) - 1;
        if (clmns[column] < ROW - 1) {
            // then draw correct circle
            logicController.drawCircle(clmns[column], column, blueRed); // row, column, colour
            endGame = checkWinner(blueRed);
            if (blueRed) //switch turn
                blueRed = false;
            else
                blueRed = true;
        } else {
            LogicController.showAlert("ERROR", "Column pressed is full", "All the rows in the column pressed, column no' " + column + " , are full.\nTry again.", false);
        }
    }
    private boolean checkWinner (boolean blueRed) {

        return false;
    }
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
