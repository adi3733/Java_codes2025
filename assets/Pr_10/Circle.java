package fjp_pr10_adi;

public class Circle {
    int x, y, r;

    public Circle(int centreX, int centreY, int radius) throws InvalidRadiusException {
        if (radius <= 0) {
            throw new InvalidRadiusException(radius);
        } else {
            this.x = centreX;
            this.y = centreY;
            this.r = radius;
        }
    }
}
