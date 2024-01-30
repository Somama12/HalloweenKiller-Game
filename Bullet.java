
package nb.test.gamepackagev1;

import java.awt.Color;
import java.awt.Graphics;
import static javax.swing.Spring.height;


    public class Bullet {
    private int x, y;
    private final int width = 3;
    private final int height = 8;
    private final int speed = 10;

    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }

    public void move() {
        y += speed; 
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}