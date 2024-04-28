import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

      public static String Tester() {
            // create subclass objects
            SalariedEmployee salariedEmployee = new SalariedEmployee("John", "Smith", "111-11-1111", "11.3.1994",
                        800.00);
            HourlyEmployee hourlyEmployee = new HourlyEmployee("Karen", "Price", "222-22-2222", "29.1.1990", 16.75, 40);
            CommissionEmployee commissionEmployee = new CommissionEmployee("Sue", "Jones", "333-33-3333", "30.6.1885",
                        10000,
                        .06);
            BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Bob", "Lewis",
                        "444-44-4444", "27.5.1995", 5000, .04, 300);
            PieceWorker pieceWorker = new PieceWorker("Lewis", "Mayhem", "555-55-5555", "10.4.1910", 1, 500);

            // create four-element Employee array
            Employee[] employees = new Employee[5];

            // initialize array with Employees
            employees[0] = salariedEmployee;
            employees[1] = hourlyEmployee;
            employees[2] = commissionEmployee;
            employees[3] = basePlusCommissionEmployee;
            employees[4] = pieceWorker;

            StringBuilder str = new StringBuilder();

            str.append("Employees processed polymorphically:\n\n");

            // generically process each element in array employees
            for (Employee currentEmployee : employees) {
                  str.append("\n").append(currentEmployee).append("\n");// invokes toString

                  // determine whether element is a BasePlusCommissionEmployee
                  if (currentEmployee instanceof BasePlusCommissionEmployee) {
                        // downcast Employee reference to BasePlusCommissionEmployee reference
                        BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) currentEmployee;

                        employee.setBaseSalary(1.10 * employee.getBaseSalary());

                        str.append("New base salary with 10% increase is: ").append(employee.getBaseSalary())
                                    .append("\n");
                  }

                  if (200 == currentEmployee.isBirthMonth()) {
                        str.append("Received birthday bonus of $200.").append("\n");
                  }
                  str.append("Earned $").append(currentEmployee.earnings() + currentEmployee.isBirthMonth())
                              .append("\n");
            }
            return str.toString();
      }
}