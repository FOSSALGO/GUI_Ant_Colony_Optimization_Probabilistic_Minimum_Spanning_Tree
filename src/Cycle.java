
import java.awt.Color;
import java.awt.Graphics2D;

public class Cycle {

    public static void draw(Graphics2D graphics2d, int cx, int cy, int r) {
        graphics2d.drawOval(cx - r, cy - r, 2 * r, 2 * r);
    }

    public static void draw(Graphics2D graphics2d, int cx, int cy, int r, Color color) {
        graphics2d.setColor(color);
        graphics2d.drawOval(cx - r, cy - r, 2 * r, 2 * r);
    }

    public static void fill(Graphics2D graphics2d, int cx, int cy, int r, Color color) {
        graphics2d.setColor(color);
        graphics2d.fillOval(cx - r, cy - r, 2 * r, 2 * r);
    }

}
