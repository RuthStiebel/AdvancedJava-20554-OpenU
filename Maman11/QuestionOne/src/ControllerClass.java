import javafx.event.ActionEvent;
import javafx.fxml.*;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class ControllerClass {

    @FXML
    void newTurnOnPressed(ActionEvent event) {
         LogicClass.warGame();
/*
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
//move on to next turn
        } else if(result.get() == ButtonType.CANCEL){
            System.out.println("Game closed.");
            System.exit();
        }

    }
} */
    }
    
    public void warWinner (DeckOfCards firstPlayer, DeckOfCards secondPlayer) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("---GAME OVER---");
        alert.setHeaderText("Congratulations!");

        if (firstPlayer.isEmpty()) {
            alert.setContentText("The second player won.");
        } else {
            alert.setContentText("The first player won.");
        }

        alert.showAndWait();
    }
    
    public void playerTurn(String player, Card firstCard, Card secondCard) {
        
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("---TURN OVER---");
        alert.setHeaderText("The " + player + " won the turn!");
        alert.setContentText("The first player's card is " + firstCard + ". \n The second player's card is " + secondCard + ". \n");

        Optional<ButtonType> result = alert.showAndWait();
        if (!result.isPresent() || result.get() == ButtonType.CANCEL) {
            System.out.println("Game closed.");
            System.exit(0);
        }
    }
        
       // JOptionPane.showMessageDialog(null, "The " + player + " won this round!\nThe first player's card is " + 
       // firstCard + ". \n The second player's card is " + secondCard +". \n");
    }
