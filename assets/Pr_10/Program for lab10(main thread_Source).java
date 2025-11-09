import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int ch = 0;

        System.out.println("1. Arithmetic Exception");
        System.out.println("2. Null Pointer Exception");
        System.out.println("3. Array Index Out of Bound");
        System.out.println("4. File Handling Exception");
        System.out.println("5. User Defined Exception");
        System.out.println("6. Number Formatting");
        System.out.print("Enter choice: ");
        ch = input.nextInt();

        switch (ch) {
            case 1:
                // Arithmetic Exception
                int a, b, c, result;
                System.out.print("Enter value of a: ");
                a = input.nextInt();
                System.out.print("Enter value of b: ");
                b = input.nextInt();
                System.out.print("Enter value of c: ");
                c = input.nextInt();

                try {
                    result = a / (b - c);
                    System.out.println("Result: " + result);
                } catch (ArithmeticException ae) {
                    System.out.println("Cannot divide by zero. " + ae);
                } finally {
                    System.out.println("Finally Block is executed always.");
                }
                break;

            case 2:
                // Null Pointer Exception
                String s = null;
                try {
                    char c1 = s.charAt(1);
                } catch (NullPointerException ex) {
                    System.out.println("Null Pointer Exception occurred.");
                }
                break;

            case 3:
                // Array Index Out of Bounds Exception
                int arr[] = {1, 2, 3, 4};
                try {
                    arr[7] = 45;
                } catch (ArrayIndexOutOfBoundsException ai) {
                    System.out.println("Required array index is not available.");
                }
                break;

            case 4:
                // File Handling Exception
                try {
                    FileInputStream f1 = new FileInputStream("D:\\JAVAPROJECT\\FDP_FJP\\src\\fdp_fjp\\Saving1.java");
                    DataInputStream in = new DataInputStream(f1);
                    System.out.println("File is found");
                } catch (FileNotFoundException ne) {
                    System.out.println("File not found.");
                }
                break;

            case 5:
                // User Defined Exception
                try {
                    Circle cr1 = new Circle(10, 10, 0);
                    System.out.println("Circle Created");
                } catch (InvalidRadiusException e) {
                    e.printError();
                }
                break;

            case 6:
                // Number Format Exception
                try {
                    // String s1 = "RMDSSOE";
                    String s2 = "123";
                    int x = Integer.parseInt(s2);
                    System.out.println("Integer number is " + x);
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage() + " is not an integer.");
                }
                break;

            default:
                System.out.println("Wrong Choice");
        }
    }
}
