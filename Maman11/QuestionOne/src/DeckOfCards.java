import java.security.SecureRandom;
import java.util.*;

public class DeckOfCards {
    private ArrayList<Card> cardDeck;
    private final int WAR_TIME = 3;
    private static final SecureRandom randomNumbers = new SecureRandom();
 private static final int NUMBER_OF_CARDS = 52; // constant # of Cards
 private int currentCard = 0; // index of next Card to be dealt (0-51)

 // constructor fills deck of Cards
 public DeckOfCards() {
    ArrayList<String> values = new ArrayList<String>(Arrays.asList("Ace", "Deuce", "Three", "Four", "Five", "Six",
    "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"));
    ArrayList<String> suits = new ArrayList<String>(Arrays.asList("Hearts", "Diamonds", "Clubs", "Spades"));
   // populate deck with Card objects
   for (int count = 0; count < NUMBER_OF_CARDS; count++) {
    cardDeck.add(new Card(values.get(count % 13), suits.get(count / 13)));
   }
 }

  // shuffle deck of Cards with one-pass algorithm
  public void shuffle() {
    // next call to method dealCard should start at deck[0] again
    currentCard = 0;
   
    // for each Card, pick another random Card (0-51) and swap them
    for (int first = 0; first < deck.length; first++) {
        // select a random number between 0 and 51
        int second = randomNumbers.nextInt(NUMBER_OF_CARDS);
    
        // swap current Card with randomly selected Card
        Card temp = deck[first];
        deck[first] = deck[second];
        deck[second] = temp; 
    }
}

    /**
     * This method removes the top card from the pile.
     * @return Top card 
     */
    public Card removeCard () {
        return cardPile.remove(0);
    }

     // deal one Card
 public Card dealCard() {
    // determine whether Cards remain to be dealt
    if ( currentCard < deck.length) {
    return deck[currentCard++]; // return current Card in array
    }
    else {
    return null; // return null to indicate that all Cards were dealt
    }
    }

    /**
     * This method adds a card to the bottom of the card pile.
     * @param card The card to be added to the pile
     */
    public void addCard (Card card) {
        cardPile.add(cardPile.size(), card);
    }

    /**
     * This method returns the third card from the top. It is called in the instance that both players play the same value card.
     * @return Third card from the top.
     */
    public Card removeThreeCards () {
        if (isEmpty())
            return null; 
        for (int i = 1; i < WAR_TIME; i++) {
            cardPile.remove(0);            
        }
        return cardPile.remove(0);
    }

    /**
     * This method checks if the pile is empty or not.
     * @return True if card pile has less then three cards left and False otherwise
     */
    private boolean isEmpty () {
        if (numOfCardsLeft() < WAR_TIME)
            return true;
        return false;
    }

    /**
     * This method returns how many cards are left in the pile.
     * @return Number of cards left in the pile
     */
    private int numOfCardsLeft () {
        return cardPile.size();
    }
    /*
Class Pile
* ArrayList from type of card
* Contructor, Shuffler, isEmpty, NumOfCardsLeft, Dealer, removing card (top), adding card (bottom), remove three, */

}