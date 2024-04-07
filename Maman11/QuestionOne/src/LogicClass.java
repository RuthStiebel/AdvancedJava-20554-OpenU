public class LogicClass {

    // divide the cards from deck MainDeck to dackA and deckB
    public static void dealDeck(DeckOfCards deckA, DeckOfCards deckB, DeckOfCards MainDeck) {
        for (int i = 0; i < 52; i++) {
            if (i % 2 == 0)
                deckA.addCard(MainDeck.dealCard());
            else
                deckB.addCard(MainDeck.dealCard());
        }
    }

    public static void compareCardsAndUpdateDecks(DeckOfCards firstPlayer, DeckOfCards secondPlayer,
            DeckOfCards helperDeck, Card firstCard, Card secondCard) {
        if (firstCard.compare(secondCard) == 1) { // this means that the first card is bigger
            firstPlayer.mergeDecks(helperDeck);
        } else if (firstCard.compare(secondCard) == -1) {
            secondPlayer.mergeDecks(helperDeck);
        }
    }

    /**
     * 
     * @param firstPlayer
     * @param secondPlayer
     * @param helperDeck
     * @param firstCard
     * @param secondCard
     * @return True if both decks are not empty
     */
    public static boolean warTime (DeckOfCards firstPlayer, DeckOfCards secondPlayer,
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
            flag = warTime(firstPlayer, secondPlayer, helperDeck, null, null);
        }
        return flag;
    }
    public static void main(String[] args) {
        final int HALF_A_DECK = 26;
        boolean flag = true;
        DeckOfCards deckOfCards = new DeckOfCards();
        deckOfCards.shuffle(); //shuffles
        //deals
        DeckOfCards firstPlayer = new DeckOfCards(0, HALF_A_DECK, deckOfCards);
        DeckOfCards secondPlayer = new DeckOfCards(HALF_A_DECK, HALF_A_DECK, deckOfCards);
        DeckOfCards helperDeck = new DeckOfCards(0, 0, deckOfCards); //initialize an empty deck
        Card firstCard = new Card();
        Card secondCard = new Card();

        while (!firstPlayer.isEmpty() && !secondPlayer.isEmpty() && flag) {
            //need to clear helper deck each iteration
            firstCard = firstPlayer.dealCard();
            secondCard = secondPlayer.dealCard();
            helperDeck.addCard(firstCard);
            helperDeck.addCard(secondCard);
            if (firstCard.compare(secondCard) == 1 || firstCard.compare(secondCard) == -1) { // this means that one of the cards is bigger
                compareCardsAndUpdateDecks (firstPlayer, secondPlayer, helperDeck, firstCard, secondCard);
            } else { //means they are equal
                flag = warTime(firstPlayer, secondPlayer, helperDeck, null, null);
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
        // need to end game

        }
    }
}
