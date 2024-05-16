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

    public void initializeBoard(int rows, int columns) {
        board = new int[rows][columns];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                board[i][j] = -1;
        print();
    }

    public int updateBoard(int row, int column, boolean blueRed) {
        int i = 1;
        while (i < board.length && board[(board.length - row - i)][column] != -1) {
            i++;
        }
        if (blueRed) // red's turn - 0
            board[(board.length - row - i)][column] = 0;
        else
            board[(board.length - row - i)][column] = 1;
        return (board.length - row - i);
    }

    public boolean isValid(int row, int column) {
        if (board[row][column] == -1)
            return true;
        return false;
    }

    public boolean isFourInARow(int row, int column) {
        int player = board[row][column]; // Get the player's ID (0 or 1)
        int fourInARow = 0;

        // check vertically
        for (int r = 0; r < board.length; r++) {
            if (board[r][column] == player) {
                fourInARow++;
            }
        }

        if (fourInARow == 4) {
            return true;
        }
        // check horizontally
        fourInARow = 0;
        for (int c = 0; c < board[0].length; c++) {
            if (board[row][c] == player) {
                fourInARow++;
            }
        }
        if (fourInARow == 4) {
            return true;
        }
        // check diagonally (left)
        fourInARow = 0;
        //up
        for (int c = column, r = row; c < board[0].length && r >= 0; c++, r--) {
            if (board[r][c] == player) {
                fourInARow++;
            }
        }
        //down
        fourInARow--;
        for (int c = column, r = row; c >=0 && r < board.length; c--, r++) {
            if (board[r][c] == player) {
                fourInARow++;
            }
        }

        if (fourInARow == 4) {
            return true;
        }
        // check diagonally (right)
        fourInARow = 0;
        //up
        for (int c = column, r = row; c < board[0].length && r < board.length; c++, r++) {
            if (board[r][c] == player) {
                fourInARow++;
            }
        }
        //down
        fourInARow--;
        for (int c = column, r = row; c >=0 && r >=0; c--, r--) {
            if (board[r][c] == player) {
                fourInARow++;
            }
        }

        if (fourInARow == 4) {
            return true;
        }

        return false;
    }

    public void print() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++)
                System.out.print(board[i][j] + "\t");
            System.out.println();
        }
    }
}
