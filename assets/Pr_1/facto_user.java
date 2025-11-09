import java.util.Scanner;

public class FactorialInput {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the No to calculate its factorial");
        double no;
        no = in.nextDouble();
        double fact = 1;

        for (int i = 1; i <= no; ++i) {
            fact *= i;
        }

        System.out.println("Factorial = " + fact);
    }
}
