import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Logic extends Application {
    private int[][] board; // every time that a circle is added then the borad is updated
                           // accordingly - 0 is red, 1 is blue

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
    public void game(int rows, int columns) {
        board = new int[rows][columns];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                board[i][j] = -1;
    }

    public void updateBoard(int row, int column, boolean blueRed) {
        if (blueRed) // red's turn - 0
            board[row][column] = 0;
        else
            board[row][column] = 1;
    }

    public boolean isValid(int row, int column) {
        if (board[row][column] == -1)
            return true;
        return false;
    }

    public boolean isFourInARow(int row, int column) {
        int player = board[row][column]; // Get the player's ID (0 or 1)

        // Check horizontally
        for (int c = column - 3; c <= column; c++) {
            if (c >= 0 && c + 3 < board[row].length) { // Ensure the range is within the board
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
            if (r >= 0 && c >= 0 && r + 3 < 5 && c + 3 < board[row].length) { // Ensure the range is within the board
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
