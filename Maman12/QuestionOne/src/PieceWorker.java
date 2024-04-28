/**
 * PieceWorker represents an employee paid based on the number of pieces produced.
 * It extends the Employee class.
 */
public class PieceWorker extends Employee {
   
    private double wage; // wage per hour
    private int pieces; // number of pieces produced

    /**
     * Constructs a PieceWorker object with the specified attributes.
     * 
     * @param firstName the first name of the employee
     * @param lastName the last name of the employee
     * @param socialSecurityNumber the social security number of the employee
     * @param dateOfBirth the date of birth of the employee
     * @param wage the wage per piece
     * @param pieces the number of pieces produced
     * @throws IllegalArgumentException if wage is negative or if pieces is negative
     */
    public PieceWorker(String firstName, String lastName,
                       String socialSecurityNumber, String dateOfBirth, double wage, int pieces) {
        super(firstName, lastName, socialSecurityNumber, dateOfBirth);

        if (wage < 0.0) { // validates wage
            throw new IllegalArgumentException("Piece wage must be >= 0");
        }

        if (pieces < 0) { // validates pieces
            throw new IllegalArgumentException(
                    "Pieces made must be >= 0");
        }

        this.wage = wage;
        this.pieces = pieces;
    }

    /**
     * Sets the wage per piece for the employee.
     * 
     * @param wage the wage per piece to set
     * @throws IllegalArgumentException if wage is negative
     */
    public void setWage(double wage) {
        if (wage < 0.0) { // validates wage
            throw new IllegalArgumentException("Piece wage must be >= 0");
        }

        this.wage = wage;
    }

    /**
     * Returns the wage per piece of the employee.
     * 
     * @return the wage per piece
     */
    public double getWage() {
        return wage;
    }

    /**
     * Sets the number of pieces produced by the employee.
     * 
     * @param pieces the number of pieces produced to set
     * @throws IllegalArgumentException if pieces is negative
     */
    public void setPieces(int pieces) {
        if (pieces < 0.0) { // validates pieces
            throw new IllegalArgumentException(
                    "Pieces made must be >= 0");
        }
        this.pieces = pieces;
    }

    /**
     * Returns the number of pieces produced by the employee.
     * 
     * @return the number of pieces produced
     */
    public int getPieces() {
        return pieces;
    }

    /**
     * Calculates the earnings of the employee.
     * Overrides the abstract method earnings in the Employee class.
     * 
     * @return the earnings of the employee
     */
    @Override
    public double earnings() {
        return getWage() * getPieces();
    }

    /**
     * Returns a String representation of the PieceWorker object.
     * 
     * @return a String containing employee details including piece wage and pieces made
     */
    @Override
    public String toString() {
        return String.format("Piece worker: %s%n%s: %,.2f; %s: %d",
                super.toString(), "Piece wage", getWage(),
                "Pieces made", getPieces());
    }
}
