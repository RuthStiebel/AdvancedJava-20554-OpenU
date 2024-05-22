import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.util.Optional;

public class LinkedListTester extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Array to store the strings
        String[] strings = new String[6];

        // Loop to get input from the user
        for (int i = 0; i < 6; i++) {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("String Input");
            dialog.setHeaderText("Enter string no' " + (i + 1));
            Optional<String> result = dialog.showAndWait();
            System.out.println(i + "\t" + result.get());
            if (result.get().trim().isEmpty()) {
                strings[i] = result.get();
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setContentText("You must enter something in the box.");
                alert.setTitle("ERROR");
                alert.setHeaderText("ERROR");
            }
        }
        primaryStage.setScene(new Scene(null));
        primaryStage.show();
    }
}
