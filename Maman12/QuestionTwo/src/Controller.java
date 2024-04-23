import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println(
                "Enter two rational numbers seperated by a comma, where the numerator and denminator are seperated by a /, "
                        + "the numerator is a whole number and the denomantor is a positive number.\n For example, a correct input would be 1/2,1/3.");
        String rationalNum = scan.nextLine();
        Rational firstRational = new Rational(0, 1);
        Rational secondRational = new Rational(0, 1);
        Logic.saveNumbers(rationalNum, firstRational, secondRational);
        System.out.println(Logic.testAllFunctions(firstRational, secondRational));
        scan.close();
    }
}
