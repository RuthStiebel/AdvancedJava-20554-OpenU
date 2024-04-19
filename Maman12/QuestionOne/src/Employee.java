import java.util.Calendar;

/**
 * The Employee class represents an abstract employee with basic information.
 * This class serves as a base class for concrete subclasses representing
 * different types of employees.
 */
public abstract class Employee {
   private final String firstName; // The first name of the employee
   private final String lastName; // The last name of the employee
   private final String socialSecurityNumber; // The social security number of the employee
   private final DateOfBirth dateOfBirth; // The date of birth of the employee

   /**
    * Constructs an Employee object with the specified first name, last name,
    * social security number, and date of birth.
    *
    * @param firstName            The first name of the employee
    * @param lastName             The last name of the employee
    * @param socialSecurityNumber The social security number of the employee
    * @param dateOfBirth          The date of birth of the employee in the format
    *                             "YYYY-MM-DD"
    */
   public Employee(String firstName, String lastName, String socialSecurityNumber, String dateOfBirth) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.socialSecurityNumber = socialSecurityNumber;
      this.dateOfBirth = new DateOfBirth(dateOfBirth);
   }

   /**
    * Retrieves the first name of the employee.
    *
    * @return The first name of the employee
    */
   public String getFirstName() {
      return firstName;
   }

   /**
    * Retrieves the last name of the employee.
    *
    * @return The last name of the employee
    */
   public String getLastName() {
      return lastName;
   }

   /**
    * Retrieves the social security number of the employee.
    *
    * @return The social security number of the employee
    */
   public String getSocialSecurityNumber() {
      return socialSecurityNumber;
   }

   /**
    * Retrieves the date of birth of the employee.
    *
    * @return The date of birth of the employee
    */
   public DateOfBirth getDateOfBirth() {
      return dateOfBirth;
   }

   /**
    * Checks if the employee's birth month matches the current month.
    *
    * @return 200 if the birth month matches the current month, otherwise 0
    */
   public int isBirthMonth() {
      if (dateOfBirth.getMonth() == Calendar.getInstance().get(Calendar.MONTH) + 1)
         return 200;
      return 0;
   }

   /**
    * Returns a string representation of the Employee object.
    *
    * @return A string containing the employee's full name, social security number,
    *         and date of birth
    */
   @Override
   public String toString() {
      return String.format("%s %s%nSocial security number: %s%nDate of birth: %s",
            getFirstName(), getLastName(), getSocialSecurityNumber(), getDateOfBirth());
   }

   /**
    * Abstract method to be implemented by concrete subclasses.
    * Calculates the earnings of the employee.
    *
    * @return The earnings of the employee
    */
   public abstract double earnings(); // no implementation here
}
