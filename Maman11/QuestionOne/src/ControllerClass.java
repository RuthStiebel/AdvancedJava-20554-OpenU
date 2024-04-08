import javafx.event.ActionEvent;
import javafx.fxml.*;

import javax.swing.*;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ControllerClass {
/*
    @FXML
    void newTurnOnPressed(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("---TURN OVER---");
        alert.setHeaderText("The " + player + "won the turn!");
        alert.setContentText("The first player's card is " + 
        firstCard + ". \n The second player's card is " + secondCard +". \n"
        Optional<ButtonType> result = alert.showAndWait();


        if(result.isEmpty()){
            System.out.println("Game closed.");
            System.exit();
        } else if(result.get() == ButtonType.OK){
            System.out.println("OK!");
        } else if(result.get() == ButtonType.CANCEL){
            System.out.println("Game closed.");
            System.exit();
        }

    }
}
    }
    */
    public void warWinner (DeckOfCards firstPlayer, DeckOfCards secondPlayer) {
    //    Alert alert = new Alert(AlertType.ERROR);
     //   alert.setTitle("---GAME OVER---");
       // alert.setHeaderText("Congradulations!");
        if (firstPlayer.isEmpty()) //print that the second one won
        {
            JOptionPane.showMessageDialog(null, "The first player won the game.");
            // alert.setContentText("The first player won.");
        } else {//print that the first one won 
            JOptionPane.showMessageDialog(null, "The second player won the game.");
            // alert.setContentText("The second player won.");
        }
    }
    
    public void playerTurn(String player, Card firstCard, Card secondCard) {
        /*
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("---TURN OVER---");
        alert.setHeaderText("The " + player + "won the turn!");
        alert.setContentText("The first player's card is " + 
        firstCard + ". \n The second player's card is " + secondCard +". \n");
        */
        JOptionPane.showMessageDialog(null, "The " + player + " won this round!\nThe first player's card is " + 
        firstCard + ". \n The second player's card is " + secondCard +". \n");
    }

}