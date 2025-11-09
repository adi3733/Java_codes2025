class Rectangle {
    private int length;
    private int breadth;

    public Rectangle(int side) {
        length = side;
        breadth = side;
    }

    public Rectangle(int l, int b) {
        length = l;
        breadth = b;
    }

    public int getArea() {
        return length * breadth;
    }
}


class Test {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(4, 5);
        Rectangle sq = new Rectangle(5);
        System.out.println(rect.getArea());
        System.out.println(sq.getArea());
    }
}
