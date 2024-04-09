import javafx.event.ActionEvent;
import javafx.fxml.*;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

/**
 * Controller class responsible for managing user interface.
 */
public class ControllerClass {

    /**
     * Initiates a new turn in the game.
     * 
     * @param event The ActionEvent triggered by pressing the new turn button.
     */
    @FXML
    void newTurnOnPressed(ActionEvent event) {
        LogicClass.warGame();
    }

    /**
     * Displays a game over message indicating the winner of the game.
     * 
     * @param firstPlayer The deck of cards belonging to the first player.
     * @param secondPlayer The deck of cards belonging to the second player.
     */
    public void gameOver(DeckOfCards firstPlayer, DeckOfCards secondPlayer) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("---GAME OVER---");
        alert.setHeaderText("Congratulations!");

        if (firstPlayer.isEmpty()) {
            alert.setContentText("The second player won.");
        } else {
            alert.setContentText("The first player won.");
        }

        alert.showAndWait();
    }

    /**
     * Displays the result of a turn, including the winner and the cards played.
     * 
     * @param player The name of the winning player.
     * @param firstPlayer The deck of cards belonging to the first player.
     * @param secondPlayer The deck of cards belonging to the second player.
     * @param firstCard The card played by the first player.
     * @param secondCard The card played by the second player.
     */
    public void turnResult(String player, DeckOfCards firstPlayer, DeckOfCards secondPlayer, Card firstCard,
            Card secondCard) {

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("---TURN OVER---");
        alert.setHeaderText("The " + player + " won the turn!");
        alert.setContentText(
                "The first player's card is " + firstCard + " and they have " + firstPlayer.sizeOfDeck()
                        + " cards left in their deck. \nThe second player's card is " + secondCard + " and they have "
                        + secondPlayer.sizeOfDeck() + " cards left in their deck. \n");

        Optional<ButtonType> result = alert.showAndWait();
        if (!result.isPresent() || result.get() == ButtonType.CANCEL) {
            closeGame();
        }
    }

    /**
     * Closes the game by exiting the application.
     */
    public void closeGame() {
        System.out.println("Game closed.");
        System.exit(0);
    }
}
