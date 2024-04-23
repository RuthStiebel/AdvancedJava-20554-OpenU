public class Logic {

    // check if there is a slash
    // check if there are only two numbers - one on either side of the slash
    // send to Rational constructor
    // check if Rational number was created
    public void saveNumbers(String rationalNum, Rational firstRationalNumber, Rational secondRationalNumber) {
        try {
            String[] rational = rationalNum.split("//");
            firstRationalNumber = new Rational(Double.parseDouble(rational[0]), Double.parseDouble(rational[1]));
            secondRationalNumber = new Rational(Double.parseDouble(rational[2]), Double.parseDouble(rational[3]));
        } catch (Exception IllegalArgumentException) {
            System.out.println("Error with input.");
        }
    }

    public static void testAllFunctions(Rational firstRationalNumber, Rational secondRationalNumber) {
        // testing getters
        System.out.printf("The first number's numerator is %s and it's denominator is %s.%n",
                firstRationalNumber.getNumerator(), firstRationalNumber.getDenominator());
        System.out.printf("The second number's numerator is %s and it's denominator is %s.%n",
                secondRationalNumber.getNumerator(), secondRationalNumber.getDenominator());
        // testing reduce function and toString
        System.out.printf("The first number after reduction is %s.%nThe second number after reduction is %s.%n",
                firstRationalNumber.reduce(), secondRationalNumber.reduce());
        // testing greaterThan
        System.out.printf("The first number is %s than the second number.%n",
                firstRationalNumber.greaterThan(secondRationalNumber) ? "larger" : "smaller");
        // testing equals
        System.out.printf("The first number is %s to the second number.%n",
                firstRationalNumber.equals(secondRationalNumber) ? "equal" : "not equal");
        // testing plus
        System.out.printf("Both numbers added together equal %s.%n",
                firstRationalNumber.plus(secondRationalNumber));
        // testing minus
        System.out.printf("The first number minus the second number is %s.%n",
                firstRationalNumber.minus(secondRationalNumber));
        // testing multiply
        System.out.printf("Both numbers multiplied together equal %s.%n",
                firstRationalNumber.multiply(secondRationalNumber));
        // testing divide
        System.out.printf("The first number divided by the second number is %s.%n",
                firstRationalNumber.divide(secondRationalNumber)); //need to send exception if one of exception is returned
    }

}
