import java.util.Scanner;

/**
 * Java Program calculating marks of a student using multiple inheritance
 * implemented through interface
 * Create class result to calculate student result using its test marks and sports marks
 * Declare class student and class test. Use student class in test class.
 * Create interface of sports.
 * Use sports and test in result class.
 */
class student {
    int rollNo;

    void getNumber(int n) {
        rollNo = n;
    }

    void putNumber() {
        System.out.println("Roll No is: " + rollNo);
    }
}

class test extends student {
    int inSem, endSem;

    void getMarks(int m1, int m2) {
        inSem = m1;
        endSem = m2;
    }

    void putMarks() {
        System.out.println("Marks obtained:");
        System.out.println("Part 1 INSEM marks = " + inSem);
        System.out.println("Part 2 ENDSEM marks = " + endSem);
    }
}

interface sports {
    int sportsWt = 5;
    void putWt();
}

class results extends test implements sports {
    int total;

    @Override
    public void putWt() {
        System.out.println("Sports weight = " + sportsWt);
    }

    void display() {
        total = inSem + endSem + sportsWt;
        if (total > 100)
            total = 100;

        putNumber();
        putMarks();
        putWt();
        System.out.println("Total score = " + total);
    }
}

public class InterfaceDemo {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        results r1 = new results();

        System.out.println("Enter the student's roll number:");
        int rollno = input.nextInt();
        r1.getNumber(rollno);

        System.out.println("Enter the student's INSEM Marks out of 30:");
        int inMarks = input.nextInt();

        System.out.println("Enter the student's ENDSEM Marks out of 70:");
        int endMarks = input.nextInt();

        r1.getMarks(inMarks, endMarks);
        r1.display();
    }
}
