import java.lang.String;
public class Card {
    private String shape;
    private String colour;
    private int value;

    public Card () {

    }

    public String getShape () {
        return this.shape;
    }
    public String getColour () {
        return this.colour;
    }
    public int getValue () {
        return this.value;
    }
    public boolean equals (Card card) {
        return (this.value == card.value) && this.colour.equals(card.colour) && this.shape.equals(card.shape);

    }
    public String toString () {

    }

    //what I need to do
    /*
     * Use arrayList
     * Class Card:
     * Number, Colour, Shape
     * Contructors, getters, equals, toString
     */
}
