import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class PayrollSystemTest extends Application {
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

      /**
       * Tester method for processing different types of employees polymorphically.
       * 
       * @return a string containing information about the processed employees
       */
      public static String Tester() {
            // creates an array to hold Employee objects
            Employee[] employees = new Employee[5];
            boolean flag = true;

            try {
                  // creates instances of different types of employees
                  SalariedEmployee salariedEmployee = new SalariedEmployee("John", "Smith", "111-11-1111", "11.3.1994",
                              800.00);
                  HourlyEmployee hourlyEmployee = new HourlyEmployee("Karen", "Price", "222-22-2222", "29.1.1990",
                              16.75, 40);
                  CommissionEmployee commissionEmployee = new CommissionEmployee("Sue", "Jones", "333-33-3333",
                              "30.6.1885",
                              10000, .06);
                  BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Bob", "Lewis",
                              "444-44-4444", "27.5.1995", 5000, .04, 300);
                  PieceWorker pieceWorker = new PieceWorker("Lewis", "Mayhem", "555-55-5555", "10.4.1910", 100, 500);

                  // initializes the array with Employee objects
                  employees[0] = salariedEmployee;
                  employees[1] = hourlyEmployee;
                  employees[2] = commissionEmployee;
                  employees[3] = basePlusCommissionEmployee;
                  employees[4] = pieceWorker;

            } catch (IllegalArgumentException e) {
                  // handles invalid input
                  flag = false;
                  Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                  errorAlert.setTitle("ERROR");
                  errorAlert.setHeaderText("Invalid employee!");
                  errorAlert.setContentText(null);
                  errorAlert.showAndWait();
            }

            // initializes a StringBuilder to store the result
            StringBuilder str = new StringBuilder();
            str.append("Could not process employees due to problems initializing them.");

            // checks if employee initialization was successful
            if (flag) {
                  // resets the StringBuilder
                  str.setLength(0);
                  str.append("Employees processed polymorphically:\n");

                  // processes each element in the array employees
                  for (Employee currentEmployee : employees) {
                        // appends employee information to the result string
                        str.append("\n").append(currentEmployee).append("\n");

                        // checks if the current employee is a BasePlusCommissionEmployee
                        if (currentEmployee instanceof BasePlusCommissionEmployee) {
                              // downcasts Employee reference to BasePlusCommissionEmployee reference
                              BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) currentEmployee;

                              // increases base salary by 10%
                              employee.setBaseSalary(1.10 * employee.getBaseSalary());

                              // appends the new base salary to the result string
                              str.append("New base salary with 10% increase is: ").append(employee.getBaseSalary())
                                          .append("\n");
                        }

                        // checks if the current employee's birth month is the current month
                        if (200 == currentEmployee.isBirthMonth()) {
                              // appends birthday bonus information to the result string
                              str.append("Received birthday bonus of $200.").append("\n");
                        }

                        // appends earnings information to the result string
                        str.append("Earned $").append(currentEmployee.earnings() + currentEmployee.isBirthMonth())
                                    .append("\n");
                  }
            }
            // returns the result string
            return str.toString();
      }
}