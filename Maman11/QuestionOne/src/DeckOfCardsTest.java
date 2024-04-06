public class DeckOfCardsTest {
    // execute application
    public static void main(String[] args) {
        DeckOfCards myDeckOfCards = new DeckOfCards();
        int num = 52;
        System.out.println("___________________"+num+"______________________");
        // print all 52 Cards in the order in which they are dealt
        for (int i = 0; i < num; i++) {
            // deal and display a Card
            System.out.printf("%-19s", myDeckOfCards.dealCard());

            if (i % 4 == 0) { // output a newline after every fourth card
                System.out.println();
            }
        }
 

    }
}