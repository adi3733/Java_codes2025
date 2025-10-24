

class Rectangle {
    private int length;
    private int breadth;

    // Constructor for square
    public Rectangle(int side) {
        length = side;
        breadth = side;
    }

    // Constructor for rectangle
    public Rectangle(int l, int b) {
        length = l;
        breadth = b;
    }

    // Method to calculate area
    public int getArea() {
        return length * breadth;
    }
}

// Main class must be public and file name should match it
public class rect {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(4, 5);  // rectangle
        Rectangle sq = new Rectangle(5);      // square

        System.out.println("Area of rectangle: " + rect.getArea());
        System.out.println("Area of square: " + sq.getArea());
    }
}
