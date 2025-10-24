package fjp_pr3;


import java.util.*;

class Rectangle
{
    double width, length, area;
    String color;
    Scanner sc = new Scanner(System.in);

    Rectangle()
    {
        System.out.print("Enter the length: ");
        length = sc.nextDouble();
        System.out.print("Enter the width: ");
        width = sc.nextDouble();
        System.out.print("Enter the color: ");
        color = sc.next();
        area = length * width;
        System.out.println("Area of Rectangle: " + area);
    }
}

public class rect
{
    public static void main(String arg[])
    {
        System.out.println("First Rectangle: ");
        Rectangle r1 = new Rectangle();
        System.out.println("Second Rectangle: ");
        Rectangle r2 = new Rectangle();

        if (r1.area == r2.area && r1.color.equals(r2.color))
            System.out.println("Matching Rectangle ");
        else
            System.out.println("Non Matching Rectangle ");
    }
}
