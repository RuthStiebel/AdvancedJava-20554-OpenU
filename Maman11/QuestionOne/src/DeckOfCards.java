import java.security.SecureRandom;
import java.util.*;

/**
 * Represents a deck of playing cards.
 */
public class DeckOfCards {
    private ArrayList<Card> cardDeck; // The deck of cards
    private static final SecureRandom randomNumbers = new SecureRandom(); // Random number generator
    private static final int NUM_OF_CARDS = 52; // Total number of cards in the deck
    private static final int NUM_OF_CARDS_IN_SUIT = 13; // Number of cards in each suit

    /**
     * Constructs a deck of cards and initializes it with standard playing cards.
     */
    public DeckOfCards() {
        cardDeck = new ArrayList<Card>(); // Initializes the deck of cards
        Card newCard = new Card(); // Temporary card object
        ArrayList<String> values = new ArrayList<String>(Arrays.asList("Ace", "Two", "Three", "Four", "Five", "Six",
                "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King")); // Card values
        ArrayList<String> suits = new ArrayList<String>(Arrays.asList("Hearts", "Diamonds", "Clubs", "Spades")); // Card
                                                                                                                 // suits

        // Populate the deck with Card objects
        for (int count = 0; count < NUM_OF_CARDS; count++) {
            newCard = new Card(values.get(count % NUM_OF_CARDS_IN_SUIT), suits.get(count / NUM_OF_CARDS_IN_SUIT));
            cardDeck.add(newCard);
        }
    }

    /**
     * Constructs a new deck of cards from a subset of cards from another deck.
     * 
     * @param start      The index of the first card to be included in the new deck.
     * @param sizeOfDeck The number of cards to include in the new deck.
     * @param deck       The original deck from which cards are extracted.
     */
    public DeckOfCards(int start, int sizeOfDeck, DeckOfCards deck) {
        cardDeck = new ArrayList<Card>(); // Initializes the deck of cards
        Card card = new Card(); // Temporary card object

        // Copy cards from the original deck to the new deck
        for (int i = 0; i < sizeOfDeck; i++) {
            card = deck.seeCard(i + start);
            if (card == null)
                break;
            else
                cardDeck.add(card);
        }
    }

    /**
     * Removes all cards from the deck.
     */
    public void clearDeck() {
        cardDeck.clear();
    }

    /**
     * Merges another deck into this deck.
     * 
     * @param smallDeck The deck to be merged into this deck.
     */
    public void mergeDecks(DeckOfCards smallDeck) {
        Card card = new Card(); // Temporary card object

        // Move cards from the smaller deck to this deck
        while (!smallDeck.isEmpty()) {
            card = smallDeck.dealCard();
            this.cardDeck.add(card);
        }
    }

    /**
     * Shuffles the deck using a one-pass algorithm.
     */
    public void shuffle() {
        Collections.shuffle(cardDeck, randomNumbers);
    }

    /**
     * Deals the top card from the deck.
     * 
     * @return The top card from the deck, or null if the deck is empty.
     */
    public Card dealCard() {
        if (isEmpty())
            return null;
        return cardDeck.remove(0);
    }

    /**
     * Retrieves a card from the deck without removing it.
     * 
     * @param index The index of the card to be retrieved.
     * @return The card at the specified index, or null if the index is out of
     *         bounds.
     */
    private Card seeCard(int index) {
        if (isEmpty())
            return null;
        return cardDeck.get(index);
    }

    /**
     * Adds a card to the bottom of the deck.
     * 
     * @param card The card to be added to the deck.
     * @return True if the card was added successfully, false if the card is null.
     */
    public boolean addCard(Card card) {
        if (card == null)
            return false;
        cardDeck.add(cardDeck.size(), card);
        return true;
    }

    /**
     * Checks if the deck is empty.
     * 
     * @return True if the deck has no cards, false otherwise.
     */
    public boolean isEmpty() {
        return sizeOfDeck() <= 0;
    }

    /**
     * Returns the number of cards in the deck.
     * 
     * @return The number of cards in the deck.
     */
    public int sizeOfDeck() {
        return cardDeck.size();
    }
}
