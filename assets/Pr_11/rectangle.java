import java.awt.*;
import java.applet.*;
public class Rectangle extends Applet {
public void paint(Graphics g) {
// Sets the drawing color to black
g.setColor(Color.black);
// Draws the outline of a rectangle
g.drawRect(120, 50, 100, 100);
}
}