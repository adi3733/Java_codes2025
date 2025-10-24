package fjp_pr1;

import java.util.Scanner;

public class facto_user {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number to calculate its factorial:");
        int no = sc.nextInt();

        long fact = 1;

        for (int i = 1; i <= no; ++i) {
            fact *= i;
        }

        System.out.println("Factorial = " + fact);
        
        sc.close();
    }
}