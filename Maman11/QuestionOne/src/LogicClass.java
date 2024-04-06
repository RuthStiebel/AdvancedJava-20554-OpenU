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

    public static void main(String[] args) {
        int HALF_A_DECK = 26;
        DeckOfCards deckOfCards = new DeckOfCards();
        deckOfCards.shuffle(); // place Cards in random order
        DeckOfCards firstPlayer = new DeckOfCards(0, HALF_A_DECK, deckOfCards);
        DeckOfCards secondPlayer = new DeckOfCards(HALF_A_DECK, HALF_A_DECK, deckOfCards);

        System.out.println("\n\n____________________Second deck_____________________\n");
        System.out.println(secondPlayer.sizeOfDeck());
        for (int i = 0; i < 26; i++) {
            // deal and display a Card
            System.out.printf("%-19s", secondPlayer.dealCard());

            if (i % 4 == 0) { // output a newline after every fourth card
                System.out.println();
            }
        }

        System.out.println("\n\n__________________First Deck______________________________\n");
        System.out.println(firstPlayer.sizeOfDeck());
        for (int i = 0; i < 26; i++) {
            // deal and display a Card
            System.out.printf("%-19s", firstPlayer.dealCard());

            if (i % 4 == 0) { // output a newline after every fourth card
                System.out.println();
            }
        }

        // need to initialize two piles
        // need to start game (divide the deck in half and shuffle)
        // need to prompt the prnting on the screen
        // need to end game
        /*
         * * Logic class
         * initializes pile, shuffles and etc
         * 
         * close game with System.exit
         */
    }
}
