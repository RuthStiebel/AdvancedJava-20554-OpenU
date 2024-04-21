import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println(
                "Enter a rational number, when the numerator and denminator are seperated by a //, "
                        + "the numerator is a whole number and the denomantor is a positive number.");
        String rationalNum = scan.nextLine();

        scan.close();
    }

}
