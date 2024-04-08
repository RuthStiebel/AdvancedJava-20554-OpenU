public class LogicClass {

    private static void compareCardsAndUpdateDecks(DeckOfCards firstPlayer, DeckOfCards secondPlayer,
            DeckOfCards helperDeck, Card firstCard, Card secondCard) {
                ControllerClass objGraphics = new ControllerClass();
        if (firstCard.compare(secondCard) == 1) { // this means that the first card is bigger
            firstPlayer.mergeDecks(helperDeck);
            objGraphics.playerTurn("first player", firstCard, secondCard);
            //need to send correct messages
        } else if (firstCard.compare(secondCard) == -1) {
            secondPlayer.mergeDecks(helperDeck);
            objGraphics.playerTurn("second player", firstCard, secondCard);
            //need to send correct messages
        }
    }

    /**
     * This method is called when both cards are equal.
     * @param firstPlayer The card deck of the first player
     * @param secondPlayer The card deck of the second player
     * @param helperDeck The deck that stores the extra cards and adds them to the right pile
     * @param firstCard The relevant card of the first player
     * @param secondCard The relevant card of the second player
     * @return True if both decks are not empty
     */
    private static boolean warTime (DeckOfCards firstPlayer, DeckOfCards secondPlayer,
            DeckOfCards helperDeck, Card firstCard, Card secondCard) {
        final int WAR_TIME = 3;
        boolean flag = true;
        for (int i = 1; i < WAR_TIME; i++) { //remove the first two 
            if (!helperDeck.addCard(firstPlayer.dealCard()) || !helperDeck.addCard(secondPlayer.dealCard())) {
                flag = false;
                break;
            }
        }
        firstCard = firstPlayer.dealCard();
        secondCard = secondPlayer.dealCard();
        helperDeck.addCard(firstCard);
        helperDeck.addCard(secondCard);
        if (firstCard.compare(secondCard) == 1 || firstCard.compare(secondCard) == -1) { // this means that one of the cards is bigger
            compareCardsAndUpdateDecks (firstPlayer, secondPlayer, helperDeck, firstCard, secondCard);
        } else { //again war
            //need to send correct messages
            //need to send correct messages
            flag = warTime(firstPlayer, secondPlayer, helperDeck, null, null);
        }
        return flag;
    }
    public static void main(String[] args) {
        final int HALF_A_DECK = 26;
        boolean flag = true;
        ControllerClass objGraphics = new ControllerClass();
        DeckOfCards deckOfCards = new DeckOfCards();
        deckOfCards.shuffle(); //shuffles
        //deals
        DeckOfCards firstPlayer = new DeckOfCards(0, HALF_A_DECK, deckOfCards);
        DeckOfCards secondPlayer = new DeckOfCards(HALF_A_DECK, HALF_A_DECK, deckOfCards);
        DeckOfCards helperDeck = new DeckOfCards(0, 0, deckOfCards); //initialize an empty deck
        Card firstCard = new Card();
        Card secondCard = new Card();

        while (!firstPlayer.isEmpty() && !secondPlayer.isEmpty() && flag) {
            helperDeck.clearDeck();
            firstCard = firstPlayer.dealCard();
            secondCard = secondPlayer.dealCard();
            helperDeck.addCard(firstCard);
            helperDeck.addCard(secondCard);
            if (firstCard.compare(secondCard) == 1 || firstCard.compare(secondCard) == -1) { // this means that one of the cards is bigger
                compareCardsAndUpdateDecks (firstPlayer, secondPlayer, helperDeck, firstCard, secondCard);
            } else { //means they are equal
                //need to send correct messages
                flag = warTime(firstPlayer, secondPlayer, helperDeck, null, null);
            }
        }
        objGraphics.warWinner (firstPlayer, secondPlayer);
    }
}

//need a while that goes on until one of them is empty
//then I need to have each one deal a caard and compare them
//if the first one wins the put both cards in the first deck
//if the second one wins then put both cards in the second deck
//should I have a method for adding? such as merge?
//if is wartime then compare 
//if one has not cards left then print correct message
// need to initialize two piles
// need to start game (divide the deck in half and shuffle)
// need to prompt the prnting on the screen