import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * LogicClass represents the logic of the card game application.
 * It manages game flow and interactions between players.
 */
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

    /**
     * Compares two cards and updates the respective player's deck based on the
     * comparison.
     * 
     * @param firstPlayer  The deck of cards belonging to the first player.
     * @param secondPlayer The deck of cards belonging to the second player.
     * @param helperDeck   A deck that temporarily stores cards during comparison.
     * @param firstCard    The card drawn from the first player's deck.
     * @param secondCard   The card drawn from the second player's deck.
     */
    private static void compareCardsAndUpdateDecks(DeckOfCards firstPlayer, DeckOfCards secondPlayer,
            DeckOfCards helperDeck, Card firstCard, Card secondCard) {
        ControllerClass objGraphics = new ControllerClass();

        if (firstCard.compare(secondCard) == 1) { // the first card's value is bigger
            firstPlayer.mergeDecks(helperDeck);
            objGraphics.turnResult("first player", firstPlayer, secondPlayer, firstCard, secondCard);
        } else if (firstCard.compare(secondCard) == -1) { // the second card's value is bigger
            secondPlayer.mergeDecks(helperDeck);
            objGraphics.turnResult("second player", firstPlayer, secondPlayer, firstCard, secondCard);
        }
    }

    /**
     * Conducts a "war" in the game when both players draw cards of equal rank.
     * 
     * @param firstPlayer  The deck of cards belonging to the first player.
     * @param secondPlayer The deck of cards belonging to the second player.
     * @param helperDeck   A deck that temporarily stores cards during the war.
     * @param firstCard    The card drawn from the first player's deck.
     * @param secondCard   The card drawn from the second player's deck.
     * @return True if both players still have cards in their deck after the war,
     *         false otherwise.
     */
    private static boolean warTime(DeckOfCards firstPlayer, DeckOfCards secondPlayer,
            DeckOfCards helperDeck, Card firstCard, Card secondCard) {
        final int WAR_TIME = 3;

        for (int i = 1; i < WAR_TIME; i++) { // removes the first two cards in each deck and places them in the helper
                                             // deck
            if (!helperDeck.addCard(firstPlayer.dealCard()) || !helperDeck.addCard(secondPlayer.dealCard())) {
                return false;
            }
        }

        firstCard = firstPlayer.dealCard();
        secondCard = secondPlayer.dealCard();
        helperDeck.addCard(firstCard);
        helperDeck.addCard(secondCard);

        if (firstCard.compare(secondCard) == 1 || firstCard.compare(secondCard) == -1) { // this means that one of the
                                                                                         // cards is bigger
            compareCardsAndUpdateDecks(firstPlayer, secondPlayer, helperDeck, firstCard, secondCard);
        } else { // again war
            return warTime(firstPlayer, secondPlayer, helperDeck, null, null);
        }
        return true;
    }

    /**
     * Initiates and controls the game flow.
     */
    public static void warGame() {
        final int HALF_A_DECK = 26;
        DeckOfCards deckOfCards = new DeckOfCards();
        deckOfCards.shuffle(); // shuffles
        // deals
        DeckOfCards firstPlayer = new DeckOfCards(0, HALF_A_DECK, deckOfCards);
        DeckOfCards secondPlayer = new DeckOfCards(HALF_A_DECK, HALF_A_DECK, deckOfCards);

        // plays the game
        while (warTurn(firstPlayer, secondPlayer))
            ;

        ControllerClass controller = new ControllerClass();
        // if game finished then one of the decks must be empty
        controller.gameOver(firstPlayer, secondPlayer);
    }

    /**
     * Conducts a single turn in the game.
     * 
     * @param firstPlayer  The deck of cards belonging to the first player.
     * @param secondPlayer The deck of cards belonging to the second player.
     * @return True if both players still have cards in their deck after the turn,
     *         false otherwise.
     */
    public static boolean warTurn(DeckOfCards firstPlayer, DeckOfCards secondPlayer) {
        DeckOfCards helperDeck = new DeckOfCards(); // initialize an empty deck
        Card firstCard = new Card();
        Card secondCard = new Card();
        helperDeck.clearDeck(); // clears the helper deck so that cards from previous turns will not pop up
                                // unexpectedly
        firstCard = firstPlayer.dealCard();
        secondCard = secondPlayer.dealCard();
        helperDeck.addCard(firstCard);
        helperDeck.addCard(secondCard);
        if (firstCard.compare(secondCard) == 1 || firstCard.compare(secondCard) == -1) { // this means that one of
                                                                                         // the cards is bigger
            compareCardsAndUpdateDecks(firstPlayer, secondPlayer, helperDeck, firstCard, secondCard);
        } else { // means they are equal
            return warTime(firstPlayer, secondPlayer, helperDeck, null, null);
        }
        return !firstPlayer.isEmpty() && !secondPlayer.isEmpty();
    }
}
