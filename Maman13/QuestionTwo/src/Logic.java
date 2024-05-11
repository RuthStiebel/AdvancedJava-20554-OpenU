import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Logic extends Application {
    private int column;
    private final int CLMN = 7;
    private final int ROW = 5;
    private int clmns[] = new int[CLMN]; // each index hold the index of the last mark in that column
    private LogicController logicController;
    private boolean blueRed = false; // red starts
    private boolean endGame = false;
    private int[][] board = new int[ROW][CLMN]; // every time that a circle is added then the borad is updated
                                                // accordingly - 0
    // is red, 1 is blue

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
        for (int i = 0; i < ROW; i++)
            for (int j = 0; j < CLMN; j++)
                board[i][j] = -1;
        logicController = new LogicController();
    }

    private void buttonLogic(Button clickedButton) {
        column = Integer.parseInt(clickedButton.getText()) - 1;
        System.out.println("HERE1 ..." + column);
        if (clmns[column] < ROW - 1) {
            System.out.println("HERE2");
            // then draw correct circle
            logicController.drawCircle(clmns[column], column, blueRed); // row, column, colour
            System.out.println("HERE3");
            endGame = isFourInARow(clmns[column], column);
            if (endGame) { // meaning the game finished
                LogicController.showAlert("Game Over", "X", "WON", true);
            }
            if (blueRed) // switch turn
                blueRed = false;
            else
                blueRed = true;
        } else {
            LogicController.showAlert("ERROR", "Column pressed is full",
                    "All the rows in the column pressed, column no' " + column + " , are full.\nTry again.", false);
        }
    }

    private static void handleClearButtonClicked() {
        // clear grid
        LogicController.showAlert("Board cleared", null, "You may begin another game or close it if you so wish.",
                true);

    }

    public void handleButtonClicked(ActionEvent event) {
        // Get the source button from the event
        Button clickedButton = (Button) event.getSource();

        // Check if the clicked button is the clear button
        if (clickedButton.getText().equals("Clear")) {
            handleClearButtonClicked();
        } else {
            buttonLogic(clickedButton);
        }
    }

    private void updateBoard(int row, int collumn) {
        if (blueRed) // red's turn - 0
            board[row][column] = 0;
        else
            board[row][column] = 1;
    }

    private boolean isFourInARow(int row, int column) {
        int player = board[row][column]; // Get the player's ID (0 or 1)

        // Check horizontally
        for (int c = column - 3; c <= column; c++) {
            if (c >= 0 && c + 3 < CLMN) { // Ensure the range is within the board
                boolean found = true;
                for (int k = 0; k < 4; k++) {
                    if (board[row][c + k] != player) {
                        found = false;
                        break;
                    }
                }
                if (found)
                    return true;
            }
        }

        // Check vertically
        for (int r = row - 3; r <= row; r++) {
            if (r >= 0 && r + 3 < 5) { // Ensure the range is within the board
                boolean found = true;
                for (int k = 0; k < 4; k++) {
                    if (board[r + k][column] != player) {
                        found = false;
                        break;
                    }
                }
                if (found)
                    return true;
            }
        }

        // Check diagonally (from top-left to bottom-right)
        for (int r = row - 3, c = column - 3; r <= row && c <= column; r++, c++) {
            if (r >= 0 && c >= 0 && r + 3 < 5 && c + 3 < CLMN) { // Ensure the range is within the board
                boolean found = true;
                for (int k = 0; k < 4; k++) {
                    if (board[r + k][c + k] != player) {
                        found = false;
                        break;
                    }
                }
                if (found)
                    return true;
            }
        }

        // Check diagonally (from top-right to bottom-left)
        for (int r = row - 3, c = column + 3; r <= row && c >= column; r++, c--) {
            if (r >= 0 && c >= 0 && r + 3 < 5 && c - 3 >= 0) { // Ensure the range is within the board
                boolean found = true;
                for (int k = 0; k < 4; k++) {
                    if (board[r + k][c - k] != player) {
                        found = false;
                        break;
                    }
                }
                if (found)
                    return true;
            }
        }

        return false;
    }
}
