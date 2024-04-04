import java.util.*;

public class CardPile {
    private ArrayList<Card> cardPile;
    private final int WAR_TIME = 3;


    public Card removeCard () {

    }
    public Card addCard () {

    }

    public Card removeThreeCards () {
        if (cardPile.numOfCardsLeft() < 3)
            return null;

    }

    private boolean isEmpty () {

    }

    private int numOfCardsLeft () {
        return cardPile.size();
    }
    /*
Class Pile
* ArrayList from type of card
* Contructor, Shuffler, isEmpty, NumOfCardsLeft, Dealer, removing card (top), adding card (bottom), remove three, */

}
/*
* Controller/Main Class
* Graphics class^ - sends to user notes blahblahblah
* Logic class
* initializes pile, shuffles and etc
* 
* close game with  System.exit
*/
