import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.util.Scanner;

public class LinkedListTester extends Application{
    private static int MAX = 6;
    
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
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("LinkedListTester.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("LinkedListTester");
        stage.setScene(scene);
        stage.show();
    }

    public static void runApp() {
        Scanner scan = new Scanner(System.in);
        String[] list = new String[MAX];

        for (int i = 0; i < MAX; i++) {
            System.out.print("Enter string " + (i + 1) + ": ");
            String input = scan.nextLine();
            if (isValidInput(input)) {
                list[i] = input;
            } else {
                LinkedListController.showAlert("ERROR", "Invalid input", "Please enter a non-empty string.", false);
                i--; // Retry for the same position
            }
        }
        StringBuilder listContent = new StringBuilder();
        // Print the array
        System.out.println();
        for (String str : list) {
            listContent.append(str).append("\n");
        }
        LinkedListController.showAlert("", "The array elements are:", listContent.toString(), true);

        scan.close();
    }

    public static boolean isValidInput(String input) {
        return input != null && !input.trim().isEmpty();
    }


}
