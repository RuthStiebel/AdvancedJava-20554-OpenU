import java.util.*;

public class CardPile {
    private ArrayList<Card> cardPile;
    private final int WAR_TIME = 3;

    /**
     * This method removes the top card from the pile.
     * @return Top card 
     */
    public Card removeCard () {
        return cardPile.remove(0);
    }

    /**
     * This method adds a card to the bottom of the card pile.
     * @param card The card to be added to the pile
     */
    public void addCard (Card card) {
        cardPile.add(cardPile.size(), card);
    }

    /**
     * This method returns the third card from the top. It is called in the instance that both players play the same value card.
     * @return Third card from the top.
     */
    public Card removeThreeCards () {
        if (isEmpty())
            return null; 
        for (int i = 1; i < WAR_TIME; i++) {
            cardPile.remove(0);            
        }
        return cardPile.remove(0);
    }

    /**
     * This method checks if the pile is empty or not.
     * @return True if card pile has less then three cards left and False otherwise
     */
    private boolean isEmpty () {
        if (numOfCardsLeft() < WAR_TIME)
            return true;
        return false;
    }

    /**
     * This method returns how many cards are left in the pile.
     * @return Number of cards left in the pile
     */
    private int numOfCardsLeft () {
        return cardPile.size();
    }
    /*
Class Pile
* ArrayList from type of card
* Contructor, Shuffler, isEmpty, NumOfCardsLeft, Dealer, removing card (top), adding card (bottom), remove three, */

}

