package nb.test.gamepackagev1;

import java.awt.*;

public class Halloween {
    private int x, y;
    private int width, height;
    private int speed = 3;

    public Halloween(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
      
    }

    public void move(int gameBoardWidth) {
         x += speed;
    if (x > gameBoardWidth) {
        x = -width;
        y = 350; 
    }
    }
    public void draw(Graphics g) {
   
     g.setColor(Color.WHITE);
     g.fillOval(x+30, y+60, 30, 50);
      
     
     
     g.setColor(Color.WHITE);
     g.fillRect(x+31, y+80, 29, 35);
     
    
     g.setColor(Color.BLACK);
     g.fillOval(x+33, y+75, 10, 10);
     
     g.setColor(Color.BLACK);
     g.fillOval(x+47, y+75, 10, 10);
     
     
     g.setColor(Color.BLACK);
     g.fillOval(x+40,y+87,11,10);
     
     g.setColor(Color.WHITE);
     Polygon new_Leg=new Polygon();
     new_Leg.addPoint(x+31,y+110);
     new_Leg.addPoint(x+40,y+110);
     new_Leg.addPoint(x+35,y+140);
     g.fillPolygon(new_Leg);
     
     
     Polygon Leg1=new Polygon();
     Leg1.addPoint(x+45,y+140);
     Leg1.addPoint(x+40,y+110);
     Leg1.addPoint(x+49,y+110);
     g.fillPolygon(Leg1);
     
     Polygon Leg2=new Polygon();
     Leg2.addPoint(x+54,y+140);
     Leg2.addPoint(x+49,y+110);
     Leg2.addPoint(x+60,y+110);
     g.fillPolygon(Leg2);
    }
    public void spawnNewHalloween(int newX, int newY) {
        this.x = newX;
        this.y = newY;
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
