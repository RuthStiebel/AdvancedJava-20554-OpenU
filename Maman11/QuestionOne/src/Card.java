import java.lang.String;
import java.util.*;
public class Card {
    private final String value;
    private final String suit;

    // two-argument constructor initializes card's value and suit
    public Card(String cardValue, String cardSuit) {
        this.value = cardValue; // initialize value of card
        this.suit = cardSuit; // initialize suit of card
    }

    //default constructor
    public Card() {
        this.value = null; // initialize value of card
        this.suit = null; // initialize suit of card

    }

    public String getValue() {
        return this.value;
    }

    public String getSuit() {
        return this.suit;
    }

    // returns 0 if equal
    // -1 if the card given is bigger than this
    // 1 else
    public int compare(Card card) {
        if (this.cardNumber() == card.cardNumber())
            return 0;
        else if (this.cardNumber() > card.cardNumber())
            return 1;
        else
            return -1;
    }

    private int cardNumber() {
        ArrayList<String> values = new ArrayList<String>(Arrays.asList("Ace", "Deuce", "Three", "Four", "Five", "Six",
                "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"));
        for(int i=0;i<values.size();i++) {
            if(this.value.equals(values.get(i)))
                return i+1;
        }
        return 0;
    }

    // return String representation of Card
    public String toString() {
        return value + " of " + suit;
    }
}
