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
