package nb.test.gamepackagev1;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Jet {

    private int x, y;
    private int width, height;
    private Color color;
    private ArrayList<Bullet> bullets;

    public ArrayList<Bullet> getBullets() {
        return bullets;
    }

    public Jet(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.bullets = new ArrayList<>();
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 20, 50);


        Polygon polygon1 = new Polygon();
        polygon1.addPoint(x+0, y+50);
        polygon1.addPoint(x+25, y+50);
        polygon1.addPoint(x+0, y+75);
        g.fillPolygon(polygon1);
        
        Polygon polygon2 = new Polygon();
        polygon2.addPoint(x+20, y+25);
        polygon2.addPoint(x+30, y+25);
        polygon2.addPoint(x+20, y+35);
        g.fillPolygon(polygon2);
        
        Polygon polygon3 = new Polygon();
        polygon3.addPoint(x+20, y+0);
        polygon3.addPoint(x+30, y+0);
        polygon3.addPoint(x+20, y+5);
        g.fillPolygon(polygon3);
        
        g.setColor(Color.BLACK);
        g.fillOval(x+5, y+50, 10, 10);
        
       


    }

    public void moveLeft() {
        x -= 5;
    }

    public void moveRight() {
        x += 5;
    }
    public void moveUp(){
        y-=5;
    }
    public void moveDown(){
        y+=5;
    }

    public void fireBullet() {
        Random rand = new Random();
        int numberOfBullets = 1;

        for (int i = 0; i < numberOfBullets; i++) {
            
            bullets.add(new Bullet(x + 8, y+55)); 
        }
    }

    public void drawBullets(Graphics g) {
        for (Bullet bullet : bullets) {
            bullet.draw(g);
            bullet.move();
        }
    }
}
