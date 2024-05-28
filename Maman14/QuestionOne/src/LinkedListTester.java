import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class LinkedListTester extends Application {

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
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("LinkedListTester.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("LinkedListTester");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Generates a linked list of persons with sample data.
     * 
     * @return The linked list of persons.
     */
    public static LinkedList<Person> personList() {
        LinkedList<Person> personLinkedList = new LinkedList<Person>();
        String[] names = { "Arnold", "Benedict", "Christopher", "Dale" };
        int[] ids = { 123, 345, 567, 789 };
        int[] yearsOfBirth = { 1990, 1995, 1993, 1998 };

        for (int i = 0; i < names.length; i++) {
            Person person = new Person(names[i], ids[i], yearsOfBirth[i]);
            personLinkedList.addNode(new Node<Person>(person));
        }
        return personLinkedList;
    }

}
