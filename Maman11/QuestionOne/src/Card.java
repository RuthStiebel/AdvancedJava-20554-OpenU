import java.lang.String;
public class Card {
    private String value;
    private String shape;
    private String colour;

    public Card () {

    }

    public String getValue () {
        return this.value;
    }
    public String getShape () {
        return this.shape;
    }
    public String getColour () {
        return this.colour;
    }
    public boolean equals (Card card) {
        return this.value.equals(card.value) && this.colour.equals(card.colour) && this.shape.equals(card.shape);
    }

    public String toString () {
        return value + "/n" + shape + "/n" + colour + "/n";
    }

    //what I need to do
    /*
     * Use arrayList
     * Class Card:
     * Number, Colour, Shape
     * Contructors, getters, equals, toString
     */
}
