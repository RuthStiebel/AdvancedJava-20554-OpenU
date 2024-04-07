import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        cardsWar();
    }

    // start the warGame
    public static void cardsWar() {

    }


    // make a message of who won the game
    public static  void winner (DeckOfCards A, DeckOfCards B) {
        if(A.isEmpty())
            JOptionPane.showMessageDialog(null,  "Player B won the game!");
        else
            JOptionPane.showMessageDialog(null, "Player A won the game!");
    }


}// End class Main

