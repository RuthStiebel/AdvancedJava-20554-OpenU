import java.util.ArrayList;

public class LogicClass {
    public static void main(String[] args) {
        int HALF_A_DECK = 26;
        DeckOfCards firstPlayer= new DeckOfCards(HALF_A_DECK);
        DeckOfCards secondPlayer= new DeckOfCards(HALF_A_DECK);
        DeckOfCards deckOfCards = new DeckOfCards();
        deckOfCards.shuffle(); // place Cards in random order

        //split the deck into two card pils
        
        // print all 52 Cards in the order in which they are dealt
        for (int i = 1; i <= 52; i++) {
            // deal and display a Card
            System.out.printf("%-19s", deckOfCards.dealCard());

            if (i % 4 == 0) { // output a newline after every fourth card
                System.out.println();
            }
        }
    }

    //check the classes in book
    //need to initialize two piles
    //need to start game (divide the deck in half and shuffle)
    //need to prompt the prnting on the screen
    //need to end game
/*
 * * Logic class
* initializes pile, shuffles and etc
* 
* close game with  System.exit
 */
}
