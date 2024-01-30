package nb.test.gamepackagev1;
import edu.sjcny.gpv1.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.Timer;
import javax.swing.*;


public class NBTestGamePackageV1 extends DrawableAdapter {

    static NBTestGamePackageV1 ge = new NBTestGamePackageV1();
    static GameBoard gb = new GameBoard(ge, "HalloweenKiller");
    static Jet myJet;
    static Halloween H;
    static Halloween2 H2;
    static Timer halloweenTimer;
    static int score = 0;
    static long startTime = System.currentTimeMillis();
    static Timer timer;
    

    public static void main(String[] args) {
        
        myJet = new Jet(250, 50, 50, 20);
        H = new Halloween(50, 350, 100, 50);
        H2 = new Halloween2(450, 350, 100, 50);
        showGameBoard(gb);
        JOptionPane.showMessageDialog(gb, "Welcome to HalloweenKiller!");
        JOptionPane.showMessageDialog(gb, "Try to kill maximum possible halloweens in 60 seconds.");
        JOptionPane.showMessageDialog(gb, "Use arrow keys to move the jet.\nPress OK to start the game");
        gb.setBackground(Color.BLACK);
        gb.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_LEFT) {
                    myJet.moveLeft();
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    myJet.moveRight();
                } else if (keyCode == KeyEvent.VK_UP) {
                    myJet.moveUp();
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    myJet.moveDown();
                }
                gb.repaint();
            }
        });

        gb.requestFocus();
         timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myJet.fireBullet();
                H.move(gb.getWidth());
                handleBulletCollision();

                long currentTime = System.currentTimeMillis();
                long elapsedTime = currentTime - startTime;
                long remainingTime = Math.max(0, 60000 - elapsedTime);
                int secondsRemaining = (int) (remainingTime / 1000);
                
                secondsRemaining--;
                if (secondsRemaining == 0) {
                    gameOver();
                }
                
                gb.repaint();
            }
        });
        timer.start();

        Timer halloweenTimer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (H == null || H.getX() > gb.getWidth()) {
                    H = new Halloween(-100, 350, 100, 50);
                }

                gb.repaint();
            }
        });
        halloweenTimer.setInitialDelay(0);
        halloweenTimer.start();
        
        
        Timer halloween2Timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                H2.move(gb.getWidth()); 
                gb.repaint();
            }
        });
        halloween2Timer.start();
                   

    }
    public static void gameOver() {
    timer.stop(); 
    JOptionPane.showMessageDialog(gb, "Game Over! Your score is: " + score);
    System.exit(0); 
}

        public void draw(Graphics g) {

        myJet.draw(g);
        myJet.drawBullets(g);
        if (H != null) {
            H.draw(g);
        }
        if (H2 != null) {
            H2.draw(g);
        }
           long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - startTime;
        long remainingTime = Math.max(0, 60000 - elapsedTime);
        int secondsRemaining = (int) (remainingTime / 1000);
        g.setColor(Color.WHITE);
        g.drawString("Time: " + secondsRemaining + "s", 30, 50);

        g.drawString("Score: " + score, 400, 50);
        g.drawString("Developed By Sahil Siddiqui",10,70);

    }


    public static void handleBulletCollision() {
        ArrayList<Bullet> bullets = myJet.getBullets();
        Iterator<Bullet> bulletIterator = bullets.iterator();
        while (bulletIterator.hasNext()) {
            Bullet bullet = bulletIterator.next();
            int bulletX = bullet.getX();
            int bulletY = bullet.getY();
            int bulletWidth = bullet.getWidth();
            int bulletHeight = bullet.getHeight();

            int halloweenX = H.getX();
            int halloweenY = H.getY();
            int halloweenWidth = H.getWidth();
            int halloweenHeight = H.getHeight();
            int halloweenMiddleX = halloweenX + (halloweenWidth / 2);

            if (bulletX + bulletWidth / 2 >= halloweenMiddleX
                    && bulletX + bulletWidth / 2 <= halloweenMiddleX + 1
                    && bulletY + bulletHeight >= halloweenY
                    && bulletY <= halloweenY + halloweenHeight) {
                H.spawnNewHalloween(-H.getWidth(), 350);
                bulletIterator.remove();
                score += 10;
                break;
            }
        int halloween2X = H2.getX();
        int halloween2Y = H2.getY();
        int halloween2Width = H2.getWidth();
        int halloween2Height = H2.getHeight();
        int halloween2MiddleX = halloween2X + (halloween2Width / 2);

        if (bulletX + bulletWidth / 2 >= halloween2MiddleX
                && bulletX + bulletWidth / 2 <= halloween2MiddleX + 1
                && bulletY + bulletHeight >= halloween2Y
                && bulletY <= halloween2Y + halloween2Height) {
            H2.spawnNewHalloween(gb.getWidth(), 350); 
            bulletIterator.remove();
            score += 10; 
            break;
        }
        }
    }


}
