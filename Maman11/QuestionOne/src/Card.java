import java.lang.String;
import java.util.*;
public class Card {
    private final String value;
    private final String suit;

    /**
     * This constructor is the default construct and initailizes both the value and the suit to "null".
     * @return Card object
     */
    public Card() {
        this.value = null; // initialize value of card
        this.suit = null; // initialize suit of card

    }

    /**
     * This constructor is a wo-argument constructor initializes card's value and suit.
     * @param cardValue The card's value
     * @param cardSuit The card's suit
     * @return Card object
     */
    public Card(String cardValue, String cardSuit) {
        this.value = cardValue; // initialize value of card
        this.suit = cardSuit; // initialize suit of card
    }

    /**
     * This method compares the values of two cards and returns 0, 1 or -1 accordingly.
     * @param card The card to be compared with
     * @return 0 if both cards are equal in value, 1 if this card's value is larger than the given card's value and -1 otherwise
     */
    public int compare(Card card) {
        if (this.cardNumber() == card.cardNumber())
            return 0;
        else if (this.cardNumber() > card.cardNumber())
            return 1;
        else
            return -1;
    }

    //this method convert the string represtation of the card's value into a number
    private int cardNumber() {
        ArrayList<String> values = new ArrayList<String>(Arrays.asList("Ace", "Deuce", "Three", "Four", "Five", "Six",
                "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"));
        for(int i=0;i<values.size();i++) {
            if(this.value.equals(values.get(i)))
                return i+1;
        }
        return 0;
    }
 
    /**
     * This method returns a string representation of the object card.
     * @return A string representation of the object card
     */
    public String toString() {
        return value + " of " + suit;
    }
}
