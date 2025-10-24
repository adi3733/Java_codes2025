import java.awt.*;
import java.applet.*;
public class circle extends Applet {
public void paint(Graphics g) {
// Draws the black outline of an oval
g.drawOval(20, 20, 200, 120);
// Sets the color to green for the next shape
g.setColor(Color.green);
// Draws a solid green circle inside the oval
g.fillOval(70, 30, 100, 100);
}
}