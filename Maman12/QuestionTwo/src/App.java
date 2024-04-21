public class Rational {
    private double numerator;
    private double denominator;
    //constructor
    public Rational (double numerator, double denominator) {
        if (denominator <= 0) { //checking that the denominator is a positive number
            throw new IllegalArgumentException("The denominator must be a positive number.");
        } else {
            if ((numerator % 1) == 0) { //checking that the numberator is a whole number
                throw new IllegalArgumentException("The numerator ust be a whole number.");
            } else {
                this.denominator = denominator;
                this.numerator = numerator;
            }
        }
    }
    
}
