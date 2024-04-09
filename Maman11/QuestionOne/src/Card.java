import java.lang.String;
import java.util.*;

/**
 * Represents a playing card with a specific value and suit.
 */
public class Card {
    private final String value;
    private final String suit;

    /**
     * Constructs a card with default values (null).
     */
    public Card() {
        this.value = null; // initializes value of card
        this.suit = null; // initializes suit of card

    }

    /**
     * Constructs a card with specified value and suit.
     * 
     * @param cardValue The value of the card.
     * @param cardSuit  The suit of the card.
     */
    public Card(String cardValue, String cardSuit) {
        this.value = cardValue; // initializes value of card
        this.suit = cardSuit; // initializes suit of card
    }

    /**
     * Compares the value of this card with another card.
     * 
     * @param card The card to compare with.
     * @return 0 if both cards have equal values, 1 if this card's value is greater,
     *         -1 otherwise.
     */
    public int compare(Card card) {
        if (this.cardNumber() == card.cardNumber())
            return 0;
        else if (this.cardNumber() > card.cardNumber())
            return 1;
        else
            return -1;
    }

    /**
     * Returns a string representation of the card.
     * 
     * @return A string containing the value and suit of the card.
     */
    public String toString() {
        return value + " of " + suit;
    }

    // Converts the string representation of the card's value into a number
    private int cardNumber() {
        ArrayList<String> values = new ArrayList<String>(Arrays.asList("Ace", "Deuce", "Three", "Four", "Five", "Six",
                "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"));
        for (int i = 0; i < values.size(); i++) {
            if (this.value.equals(values.get(i)))
                return i + 1;
        }
        return 0;
    }
}