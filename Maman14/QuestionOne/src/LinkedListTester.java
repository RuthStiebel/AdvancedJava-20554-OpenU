import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import java.util.Scanner;

public class LinkedListTester {
    private static int MAX = 6;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] list = new String[MAX];

        for (int i = 0; i < MAX; i++) {
            System.out.print("Enter string " + (i + 1) + ": ");
            String input = scan.nextLine();
            if (isValidInput(input)) {
                list[i] = input;
            } else {
                System.out.println("Invalid input. Please enter a non-empty string."); //                sendAlert("Invalid input. Please enter a non-empty string.", "ERROR", "ERROR");
                i--; // Retry for the same position
            }
        }

        // Print the array
        System.out.println("The array elements are:");
        for (String str : list) {
            System.out.println(str);
        }

        scan.close();
    }

    public static boolean isValidInput(String input) {
        return input != null && !input.trim().isEmpty();
    }
    private static void sendAlert(String alertContext, String alertTitle, String alertHeader) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setContentText(alertContext);
        alert.setTitle(alertTitle);
        alert.setHeaderText(alertHeader);
    }
}
