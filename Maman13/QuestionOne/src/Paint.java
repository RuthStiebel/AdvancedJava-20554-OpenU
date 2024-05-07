import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class Paint {
     /**
       * The main method to launch the application.
       */
      public static void main(String[] args) {
            launch(args);
            System.out.println();
      }

      /**
       * Starts the JavaFX application by loading the FXML file and setting up the
       * stage.
       * 
       * @param stage The primary stage of the application.
       * @throws Exception If an error occurs while loading the FXML file.
       */
      public void start(Stage stage) throws Exception {
            Parent root = (Parent) FXMLLoader.load(getClass().getResource("PayrollSystemTest.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("PayrollSystemTest");
            stage.setScene(scene);
            stage.show();
      }


}
