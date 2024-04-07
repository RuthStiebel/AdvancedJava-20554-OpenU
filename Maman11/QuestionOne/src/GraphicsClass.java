import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class GraphicsClass {
    public static void main(String[] args) {
        cardsWar();
    }

    // start the warGame
    public static void cardsWar() {

    }

    public void warWinner (DeckOfCards firstPlayer, DeckOfCards secondPlayer) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("---GAME OVER---");
        alert.setHeaderText("Congradulations!");
        if (firstPlayer.isEmpty()) //print that the second one won
        {
            alert.setContentText("The first player won.");
        } else {//print that the first one won 
            alert.setContentText("The second player won.");
        }
    }

    public void playerTurn(String player, Card firstCard, Card secondCard) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("---GAME OVER---");
        alert.setHeaderText("The " + player + "won the turn!");
        alert.setContentText("The first player's card is " + 
        firstCard + ". \n The second player's card is " + secondCard +". \n");
    }

}// End class Main

