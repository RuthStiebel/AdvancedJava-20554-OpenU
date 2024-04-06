import java.security.SecureRandom;
import java.util.*;

public class DeckOfCards {
    private ArrayList<Card> cardDeck;
    private final int WAR_TIME = 3;
    private static final SecureRandom randomNumbers = new SecureRandom();
    private static final int NUM_OF_CARDS = 52; 
    private static final int NUM_OF_CARDS_IN_SUIT = 13;

    /**
     * Constructor for objects of class CardDeck. It fills the cardDeck with cards.
     */
     public DeckOfCards() {
        cardDeck = new ArrayList<Card>(); // Initialize cardDeck
        Card newCard = new Card();
        ArrayList<String> values = new ArrayList<String>(Arrays.asList("Ace", "Two", "Three", "Four", "Five", "Six",
                "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"));
        ArrayList<String> suits = new ArrayList<String>(Arrays.asList("Hearts", "Diamonds", "Clubs", "Spades"));
        // populate cardDeck with Card objects
        for (int count = 0; count < NUM_OF_CARDS; count++) {
            newCard = new Card(values.get(count % NUM_OF_CARDS_IN_SUIT), suits.get(count / NUM_OF_CARDS_IN_SUIT));
            cardDeck.add(newCard);
        }
    }

    /** This constructor creates a new deck from a given deck.  */
    public DeckOfCards (int start, int sizeOfDeck, DeckOfCards deck) {
        cardDeck = new ArrayList<Card>(); // Initialize cardDeck
        Card card = new Card();

        for (int i = 0; i<sizeOfDeck; i++){
            card = deck.seeCard(i+start);
            if (card==null)
                break;
            else 
                cardDeck.add(card);
        }
    }

    // shuffle cardDeck of Cards with one-pass algorithm
    public void shuffle() {
        Collections.shuffle(cardDeck, randomNumbers);
    }

    /**
     * This method deals the top card from the pile.
     * @return Top card
     */
    public Card dealCard() {
        // determine whether Cards remain to be dealt
        if (isEmpty())
            return null;
        return cardDeck.remove(0);
    }

    /**
     * This method shows the top card of the pile but does not remove it from deck.
     * @return Top card
     */
    public Card seeCard(int index) {
        // determine whether Cards remain to be dealt
        if (isEmpty())
            return null;
        return cardDeck.get(index);
    }

    /**
     * This method adds a card to the bottom of the card pile.
     * @param card The card to be added to the pile
     */
    public void addCard(Card card) {
        cardDeck.add(cardDeck.size(), card);
    }

    /**
     * This method returns the third card from the top. 
     * It is called in the instance that both players play the same value card.
     * @return Third card from the top.
     */
    public Card removeThreeCards() {
        if (isEmpty())
            return null;
        for (int i = 1; i < WAR_TIME; i++) {
            cardDeck.remove(0);
        }
        return cardDeck.remove(0);
    }

    /**
     * This method checks if the pile is empty or not.
     * @return True if card pile has less then three cards left and False otherwise
     */
    private boolean isEmpty() {
        return numOfCardsLeft() <= 0;
   }

    /**
     * This method returns how many cards are left in the pile.
     * @return Number of cards left in the pile
     */
    public int numOfCardsLeft() {
        return cardDeck.size();
    }
}