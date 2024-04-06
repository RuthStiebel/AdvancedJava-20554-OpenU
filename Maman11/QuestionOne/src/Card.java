import java.lang.String;
public class Card {
    private final String value;
    private final String suit;

 // two-argument constructor initializes card's value and suit
 public Card(String cardValue, String cardSuit) {
    this.value = cardValue; // initialize value of card
    this.suit = cardSuit; // initialize suit of card
 }
    public String getValue () {
        return this.value;
    }
    public String getSuit () {
        return this.suit;
    }

    public boolean equals (Card card) {
        return this.value.equals(card.value) && this.suit.equals(card.suit);
    }

// return String representation of Card
public String toString() {
    return value + " of " + suit;
   } 
    //what I need to do
    /*
     * Use arrayList
     * Class Card:
     * Number, Colour, Shape
     * Contructors, getters, equals, toString
     */
}
