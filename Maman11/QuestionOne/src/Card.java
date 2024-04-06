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

    public boolean equals(Card card) {
        return this.value.equals(card.value) && this.suit.equals(card.suit);
    }

    public int cardNumber() {
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
