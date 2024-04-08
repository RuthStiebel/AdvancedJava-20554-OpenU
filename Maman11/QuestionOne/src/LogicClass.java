public class LogicClass {

    public static void main(String[] args) {
        warGame();
    }

    /**
     * This method recieves two cards and places them in the deck from which the card with the higher value originated from.
     * @param firstPlayer The first card deck
     * @param secondPlayer The second card deck
     * @param helperDeck A deck that stores the cards that need to move the one of the given decks
     * @param firstCard The card from the first card deck
     * @param secondCard The card from the second card deck
     */
    private static void compareCardsAndUpdateDecks(DeckOfCards firstPlayer, DeckOfCards secondPlayer,
            DeckOfCards helperDeck, Card firstCard, Card secondCard) {
        ControllerClass objGraphics = new ControllerClass();
        if (firstCard.compare(secondCard) == 1) { //the first card's value is bigger
            firstPlayer.mergeDecks(helperDeck);
            objGraphics.playerTurn("first player", firstCard, secondCard);
        } else if (firstCard.compare(secondCard) == -1) { //the second card's value is bigger
            secondPlayer.mergeDecks(helperDeck);
            objGraphics.playerTurn("second player", firstCard, secondCard);
        }
    }

    /**
     * This method is called when both cards are equal.
     * 
     * @param firstPlayer  The card deck of the first player
     * @param secondPlayer The card deck of the second player
     * @param helperDeck   The deck that stores the extra cards and adds them to the
     *                     right pile
     * @param firstCard    The relevant card of the first player
     * @param secondCard   The relevant card of the second player
     * @return True if both decks are not empty
     */
    private static boolean warTime(DeckOfCards firstPlayer, DeckOfCards secondPlayer,
            DeckOfCards helperDeck, Card firstCard, Card secondCard) {
        final int WAR_TIME = 3;
        boolean flag = true;
        for (int i = 1; i < WAR_TIME; i++) { // removes the first two cards in each deck and places them in the helper
                                             // deck
            if (!helperDeck.addCard(firstPlayer.dealCard()) || !helperDeck.addCard(secondPlayer.dealCard())) {
                flag = false;
                break;
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
            flag = warTime(firstPlayer, secondPlayer, helperDeck, null, null);
        }
        return flag;
    }

    /**
     * This method implents the war game.
     */
    public static void warGame() {
        final int HALF_A_DECK = 1;
        boolean flag = true;
        ControllerClass objGraphics = new ControllerClass();
        DeckOfCards deckOfCards = new DeckOfCards();
        deckOfCards.shuffle(); // shuffles
        // deals
        DeckOfCards firstPlayer = new DeckOfCards(0, HALF_A_DECK, deckOfCards);
        DeckOfCards secondPlayer = new DeckOfCards(HALF_A_DECK, HALF_A_DECK, deckOfCards);
        DeckOfCards helperDeck = new DeckOfCards(0, 0, deckOfCards); // initialize an empty deck
        Card firstCard = new Card();
        Card secondCard = new Card();

        // starts the war game
        while (!firstPlayer.isEmpty() && !secondPlayer.isEmpty() && flag) {
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
                flag = warTime(firstPlayer, secondPlayer, helperDeck, null, null);
            }
        }
        objGraphics.warWinner(firstPlayer, secondPlayer); // if the while loop finished then one of the decks must be empty
    }
}