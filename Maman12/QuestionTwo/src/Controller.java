import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println(
                "Enter two rational numbers, where the numerator and denminator are seperated by a //, "
                        + "the numerator is a whole number and the denomantor is a positive number.");
        String rationalNum = scan.nextLine();
        Rational firstRational = new Rational(0, 0);
        Rational secondRational = new Rational(0, 0);
        testAllFunctions(firstRational, secondRational);

        scan.close();
    }
}
