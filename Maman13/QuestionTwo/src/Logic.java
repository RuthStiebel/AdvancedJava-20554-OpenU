import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Logic extends Application {
    private int[][] board; // every time that a circle is added then the board is updated
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

    /**
     * Initializes the game board with the given number of rows and columns.
     *
     * @param rows    The number of rows in the game board.
     * @param columns The number of columns in the game board.
     */
    public void initializeBoard(int rows, int columns) {
        board = new int[rows][columns];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                board[i][j] = -1;
    }

    /**
     * Updates the game board with the player's move.
     *
     * @param row     The row where the player's piece is placed.
     * @param column  The column where the player's piece is placed.
     * @param blueRed True if the player is blue, false if red.
     * @return The row index where the piece was placed.
     */
    public int updateBoard(int row, int column, boolean blueRed) {
        int i = 1;
        while (i < board.length && board[(board.length - row - i)][column] != -1) {
            i++;
        }
        if (blueRed) // Red's turn - 0
            board[(board.length - row - i)][column] = 0;
        else
            board[(board.length - row - i)][column] = 1;
        return (board.length - row - i);
    }

    /**
     * Checks if the specified position on the board is valid for placing a piece.
     *
     * @param row    The row index.
     * @param column The column index.
     * @return True if the position is valid, false otherwise.
     */
    public boolean isValid(int row, int column) {
        if (board[row][column] == -1)
            return true;
        return false;
    }

    /**
     * Checks if the game board is full.
     * 
     * @return True if the board is full, false otherwise.
     */
    public boolean boardFull() {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (board[i][j] == -1)
                    return false;
        return true;
    }

    /**
     * Checks if there are four pieces of the same color in a row, column, or
     * diagonal starting from the specified position.
     *
     * @param row    The row index.
     * @param column The column index.
     * @return True if there are four in a row, false otherwise.
     */
    public boolean isFourInARow(int row, int column) {
        print();
        int player = board[row][column]; // Gets the player's ID (0 or 1)
        int fourInARow = 0;

        // Checks vertically
        for (int r = 0; r < board.length; r++) {
            if (board[r][column] == player) {
                fourInARow++;
                if (fourInARow == 4)
                    return true;
            } else
                fourInARow = 0;
        }
        // Checks horizontally
        fourInARow = 0;
        for (int c = 0; c < board[0].length; c++) {
            if (board[row][c] == player) {
                fourInARow++;
                if (fourInARow == 4)
                    return true;
            } else
                fourInARow = 0;
        }

        // Checks diagonally (right)
        fourInARow = 0;
        for (int c = column, r = row; c < board[0].length && r < board.length; c++, r++) {
            if (board[r][c] == player) {
                fourInARow++;
                if (fourInARow == 4)
                    return true;
            } else
                fourInARow = 0;
        }

        // Checks diagonally (left)
        fourInARow = 0;
        System.out.println("R"+ row +"\t"+"C"+ column);
        for (int c = column, r = row; c >= 0 && r >= 0; c--, r--) {
            System.out.println("BEFORE IF - R"+ r +"\t"+"C"+ c + "\n"+board[r][c]);

            if (board[r][c] == player) {
                System.out.println("IN IF - R"+ r +"\t"+"C"+ c);
                fourInARow++;
                if (fourInARow == 4)
                    return true;
            } else
                fourInARow = 0;
        }
        return false;
    }

    public void print () {
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++)
                System.out.print(board[i][j] + "\t");
            System.out.println();
        }
    }
}
