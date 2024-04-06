import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        cardsWar();
    }

    // start the warGame
    public static void cardsWar() {
        String msg;
        int war = 2;
        DeckOfCards deckA = new DeckOfCards();
        DeckOfCards deckB = new DeckOfCards();
        DeckOfCards deckMain = new DeckOfCards();
        deckMain.shuffle();
        dealDeck(deckA, deckB, deckMain);

        while(!deckA.isEmpty() && !deckB.isEmpty()) {
            Card cardA = deckA.dealCard();
            Card cardB = deckB.dealCard();
            msg = "Player A Card is: " + cardA + "\nPlayer B Card is: " + cardB;
            if (cardA.cardNumber() > cardB.cardNumber()) {
                AddToDeck(cardA, cardB, deckA, deckMain);
                msg += "\nPlayer A won!\nplayer A have: "+deckA.sizeOfDeck()+" cards\nplayer B have: "+deckB.sizeOfDeck()+" cards";
                JOptionPane.showMessageDialog(null, msg);
            }
            else if (cardA.cardNumber() < cardB.cardNumber()) {
                AddToDeck(cardB, cardA, deckB, deckMain);
                msg += "\nPlayer B won!\nplayer A have: "+deckA.sizeOfDeck()+" cards\nplayer B have: "+deckB.sizeOfDeck()+" cards";
                JOptionPane.showMessageDialog(null, msg);
            }
            // War mode
            else {
                deckMain.addCard(cardA);
                deckMain.addCard(cardB);
                msg += "\nIts a war!";
                JOptionPane.showMessageDialog(null, msg);
                //We will add 2 cards from each player to the temp deck and after the war will give them to the winner
                for (int i = 0; i < war; i++){
                    if (deckA.isEmpty()||deckB.isEmpty()) {
                        winner(deckA, deckB);
                        return;
                    }
                    cardA = deckA.dealCard();
                    cardB = deckB.dealCard();
                    deckMain.addCard(cardA);
                    deckMain.addCard(cardB);
                }
            }
        }// End of while
        winner(deckA, deckB);
    }

    // make a message of who won the game
    public static  void winner (DeckOfCards A, DeckOfCards B) {
        if(A.isEmpty())
            JOptionPane.showMessageDialog(null,  "Player B won the game!");
        else
            JOptionPane.showMessageDialog(null, "Player A won the game!");
    }

    // divide the cards from deck MainDeck to dackA and deckB
    public static void dealDeck(DeckOfCards deckA,DeckOfCards deckB, DeckOfCards MainDeck) {
        for(int i=0;i<52;i++) {
            if(i%2==0)
                deckA.addCard(MainDeck.dealCard());
            else
                deckB.addCard(MainDeck.dealCard());
        }
    }
}// End class Main

