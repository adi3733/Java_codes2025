package adi_pr_8;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * InterfaceDemo.java
 * Public class with main method. Includes Student, Test and Results classes.
 * Save this file as InterfaceDemo.java in package adi_pr_7.
 */
public class InterfaceDemo {
    public static void main(String[] args) {
        Results r1 = new Results();

        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter the student's roll number: ");
            int rollno = input.nextInt();
            r1.getNumber(rollno);

            System.out.print("Enter the student's INSEM Marks out of 30: ");
            int inMarks = input.nextInt();
            if (inMarks < 0) inMarks = 0;
            if (inMarks > 30) inMarks = 30; // basic clamp

            System.out.print("Enter the student's ENDSEM Marks out of 70: ");
            int endMarks = input.nextInt();
            if (endMarks < 0) endMarks = 0;
            if (endMarks > 70) endMarks = 70; // basic clamp

            System.out.println();
            r1.getMarks(inMarks, endMarks);
            r1.display();

        } catch (InputMismatchException ime) {
            System.out.println("Invalid input. Please enter integer values only.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}

/* Base class for common student fields */
class Student {
    protected int rollNo;

    public void getNumber(int n) {
        this.rollNo = n;
    }

    public void putNumber() {
        System.out.println("Roll No is: " + rollNo);
    }
}

/* Test class extends Student and stores marks */
class Test extends Student {
    protected int inSem;   // marks out of 30
    protected int endSem;  // marks out of 70

    public void getMarks(int m1, int m2) {
        this.inSem = m1;
        this.endSem = m2;
    }

    public void putMarks() {
        System.out.println("Marks obtained:");
        System.out.println("Part 1 INSEM  marks = " + inSem);
        System.out.println("Part 2 ENDSEM marks = " + endSem);
    }
}

/* Results class demonstrates multiple inheritance via interface */
class Results extends Test implements Sports {
    private int total;

    @Override
    public void putWt() {
        System.out.println("Sports weight = " + SPORTS_WT);
    }

    public void display() {
        total = inSem + endSem + SPORTS_WT;

        // Optionally clamp total to 100 if required by lab specification
        if (total > 100) {
            total = 100;
        }

        putNumber();
        putMarks();
        putWt();
        System.out.println("Total score = " + total);
    }
}
