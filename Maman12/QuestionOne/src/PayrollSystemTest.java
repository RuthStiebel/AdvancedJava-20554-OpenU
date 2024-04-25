import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class PayrollSystemTest {
   public static void main(String[] args) {
      // create subclass objects
      SalariedEmployee salariedEmployee = new SalariedEmployee("John", "Smith", "111-11-1111", "11.3.1994", 800.00);
      HourlyEmployee hourlyEmployee = new HourlyEmployee("Karen", "Price", "222-22-2222", "29.1.1990", 16.75, 40);
      CommissionEmployee commissionEmployee = new CommissionEmployee("Sue", "Jones", "333-33-3333", "30.6.1885", 10000,
            .06);
      BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Bob", "Lewis",
            "444-44-4444", "10.10.1910", 5000, .04, 300);
      PieceWorker pieceWorker = new PieceWorker("Lewis", "Mayhem", "444-44-4444", "10.4.1910", 1, 500);

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
         str.append(currentEmployee).append("\n"); // invokes toString

         // determine whether element is a BasePlusCommissionEmployee
         if (currentEmployee instanceof BasePlusCommissionEmployee) {
            // downcast Employee reference to BasePlusCommissionEmployee reference
            BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) currentEmployee;

            employee.setBaseSalary(1.10 * employee.getBaseSalary());

            str.append("New base salary with 10% increase is: ").append(employee.getBaseSalary()).append("\n");
         }
         
         if (200 == currentEmployee.isBirthMonth()) {
            str.append("Received birthday bonus of $200.").append("\n");
         }
         str.append("Earned ").append(currentEmployee.earnings() + currentEmployee.isBirthMonth()).append("\n");
      }

      // get type name of each object in employees array
      for (int j = 0; j < employees.length; j++) {
         str.append("Employee ").append(j).append(" is a ").append(employees[j].getClass().getName());
      }

      //cast stringbuilder to string
      Alert inform = new Alert(Alert.AlertType.NONE);
      inform.setTitle(null); // Set the title of the alert
      inform.setHeaderText("hey");
      inform.getButtonTypes().add(ButtonType.OK);
      inform.showAndWait();
   }
}