public class PieceWorker extends Employee {
    private double wage; // wage per hour
    private int pieces; // hours worked for week
 
    // constructor
    public PieceWorker(String firstName, String lastName,
       String socialSecurityNumber, String dateOfBirth, double wage, int pieces) {
       super(firstName, lastName, socialSecurityNumber, dateOfBirth);
 
       if (wage < 0.0) { // validate wage
          throw new IllegalArgumentException("Hourly wage must be >= 0.0");
       }
 
       if (pieces < 0.0) { // validate pieces
          throw new IllegalArgumentException(
             "Pieces made must be >= 0.0");
       }
 
       this.wage = wage;
       this.pieces = pieces;
    } 
 
    // set wage
    public void setWage(double wage) {
       if (wage < 0.0) { // validate wage
          throw new IllegalArgumentException("Hourly wage must be >= 0.0");
       }
 
       this.wage = wage;
    } 
 
    // return wage
    public double getWage() {return wage;}
 
    // set hours worked
    public void setPieces(int pieces) {
       if ((pieces < 0.0) || (pieces > 168.0)) { // validate hours
          throw new IllegalArgumentException(
             "Hours worked must be >= 0.0 and <= 168.0");
       }
 
       this.pieces = pieces;
    } 
 
    // return pieces made
    public int getPieces() {return pieces;}
 
    // calculate earnings; override abstract method earnings in Employee
    @Override                                                           
    public double earnings() {                                          
       if (getPieces() <= 40) { // no overtime                           
          return getWage() * getPieces();                                
       }                                                                
       else {                                                           
          return 40 * getWage() + (getPieces() - 40) * getWage() * 1.5;  
       }                                                                
    }                                                                   
 
    // return String representation of HourlyEmployee object              
    @Override                                                             
    public String toString() {                                            
       return String.format("hourly employee: %s%n%s: $%,.2f; %s: %,.2f", 
          super.toString(), "hourly wage", getWage(),                     
          "hours worked", getPieces());                                    
    }                                                                     
 } 
 