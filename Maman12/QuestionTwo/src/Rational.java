public class Rational {
    private double numerator;
    private double denominator;

    /**
     * Constructs a Rational object with the specified numerator and denominator.
     *
     * @param numerator   the numerator of the rational number (must be whole)
     * @param denominator the denominator of the rational number (must be positive)
     * @throws IllegalArgumentException if the denominator is not a positive number
     *                                  or if the numerator is not a whole number
     */
    public Rational(double numerator, double denominator) {
        if ((numerator % 1) == 0) // checking that the numberator is a whole number
            throw new IllegalArgumentException("The numerator ust be a whole number.");
        if (denominator <= 0) // checking that the denominator is a positive number
            throw new IllegalArgumentException("The denominator must be a positive number.");
        this.denominator = denominator;
        this.numerator = numerator;
    }

    /**
     * Gets the denominator of the rational number.
     *
     * @return the denominator
     */
    public double getDenominator() {
        return denominator;
    }

    /**
     * Gets the numerator of the rational number.
     *
     * @return the numerator
     */
    public double getNumerator() {
        return numerator;
    }

    /**
     * Checks if this rational number is greater than another rational number.
     *
     * @param number the rational number to compare
     * @return true if this rational number is greater than the specified rational
     *         number, otherwise false
     */
    public boolean greaterThan(Rational number) {
        return (this.denominator * number.numerator > this.numerator * number.denominator);
    }

    /**
     * Checks if this rational number is equal to another object.
     *
     * @param obj the object to compare
     * @return true if the specified object is a Rational with equal numerator and
     *         denominator, otherwise false
     * @throws IllegalArgumentException if the specified object is not a Rational
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Rational) {
            if (((Rational) obj).numerator == this.numerator
                    && ((Rational) obj).denominator == this.denominator)
                return true;
        } else
            throw new IllegalArgumentException("The object entered must be of type 'Rational'.");
        return false;
    }

    /**
     * Adds another rational number to this rational number.
     *
     * @param number the rational number to add
     * @return the sum of this rational number and the specified rational number
     */
    public Rational plus(Rational number) {
        return new Rational((number.denominator * this.numerator) + (number.numerator * this.denominator),
                number.denominator * this.denominator).reduce();
    }

    /**
     * Subtracts another rational number from this rational number.
     *
     * @param number the rational number to subtract
     * @return the difference between this rational number and the specified
     *         rational number
     */
    public Rational minus(Rational number) {
        return new Rational((number.denominator * this.numerator) - (number.numerator * this.denominator),
                number.denominator * this.denominator).reduce();
    }

    /**
     * Multiplies this rational number by another rational number.
     *
     * @param number the rational number to multiply by
     * @return the product of this rational number and the specified rational number
     */
    public Rational multiply(Rational number) {
        return new Rational((number.numerator * this.numerator),
                number.denominator * this.denominator).reduce();
    }

    /**
     * Divides this rational number by another rational number.
     *
     * @param number the rational number to divide by
     * @return the quotient of this rational number divided by the specified
     *         rational number
     * @throws ArithmeticException if the specified rational number has a numerator
     *                             of zero
     */
    public Rational divide(Rational number) {
        if (number.numerator == 0 || this.numerator == 0)
            throw new ArithmeticException("Cannot divide by zero.");

        return new Rational((number.denominator * this.numerator),
                number.numerator * this.denominator).reduce();
    }

    /**
     * Reduces this rational number to its simplest form.
     * 
     * @return the reduced form of this rational number
     */
    public Rational reduce() {
        double GCD;
        if (numerator > denominator)
            GCD = gcd(numerator, denominator);
        else
            GCD = gcd(denominator, numerator);

        return new Rational(this.numerator / GCD, this.denominator / GCD);
    }

    /*
     * Returns the greatest common divisor (GCD) of two numbers using the Euclidean
     * algorithm.
     * The GCD of two numbers is the largest number that divides both of them
     * without leaving a remainder.
     */
    private double gcd(double a, double b) {
        // If b is 0, then a is the GCD
        if (b == 0)
            return a;
        // Otherwise, recursively call gcd with b as the new first number and a mod b as
        // the new second number
        else
            return gcd(b, a % b);
    }

    /**
     * Returns a string representation of this rational number.
     * 
     * @return a string representation of the rational number in the form
     *         "numerator/denominator"
     */
    @Override
    public String toString() {
        return (numerator + "/" + denominator);
    }
}
