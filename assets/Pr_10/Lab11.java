package fjp_pr10_adi;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int ch = 0;
        System.out.println("1. Arithmetic Exception\n2.Null Pont Exception\n3.Array iNdex Out of Bound");
        System.out.println("4. File Handling Exception\n5.user defined Exception\n6. Number formating");
        System.out.println("enter choice:");
        ch = input.nextInt();

        switch (ch) {
            case 1:
                int a, b, c;
                int result;
                System.out.println("Enter value of a :\t");
                a = input.nextInt();
                System.out.println("Enter value of b:\t");
                b = input.nextInt();
                System.out.println("Enter value of c :\t");
                c = input.nextInt();
                try {
                    result = a / (b - c);
                } catch (ArithmeticException ae) {
                    System.out.println("Cannot divided by zero." + ae);
                } finally {
                    System.out.println("Finally Bock is excecuted Always");
                }
                break;

            case 2:
                String s = null;
                char c1;
                try {
                    c1 = s.charAt(1);
                } catch (NullPointerException ex) {
                    System.out.println("Null pointer Exception");
                }
                break;

            case 3:
                int arr[] = {1, 2, 3, 4};
                try {
                    arr[7] = 45;
                } catch (ArrayIndexOutOfBoundsException ai) {
                    System.out.println("Required Array index is not available.");
                }
                break;

            case 4:
                try {
                    FileInputStream f1 = new FileInputStream("D:\\JAVAPROJECT\\FDP_FJP\\src\\fdp_fjp\\Saving1.java");
                    DataInputStream in = new DataInputStream(f1);
                    System.out.println("File is found");
                } catch (FileNotFoundException ne) {
                    System.out.println("File not found");
                }
                break;

            case 5:
                try {
                    Circle cr1 = new Circle(10, 10, 0);
                    System.out.println("Circle Created");
                } catch (InvalidRadiusException e) {
                    e.printError();
                }
                break;

            case 6:
                try {
                    String s2 = "123";
                    int x = Integer.parseInt(s2);
                    System.out.println(" Interger number is " + x);
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage() + " is not an interger");
                }
                break;

            default:
                System.out.println("Wrong Choice");
        }
    }
}
