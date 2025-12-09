import java.awt.*;
import java.awt.event.*;

public class Paddle {
    int x, y, id;
    int yVelocity = 0;
    int speed = 5;
    int width = 20;
    int height = 200;

    public Paddle(int x, int y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }

    public void move() {
        int HEIGHT = 600;
        y += yVelocity;
        
        if (y < 0) y = 0;
        if (y > HEIGHT - height) y = HEIGHT - height;
    }

    public void keyPressed(KeyEvent e) {
        switch(id) {
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_W) yVelocity = -speed;
                if (e.getKeyCode() == KeyEvent.VK_S) yVelocity = speed;
                break;
            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP) yVelocity = -speed;
                if (e.getKeyCode() == KeyEvent.VK_DOWN) yVelocity = speed;
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch(id) {
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_W) yVelocity = 0;
                if (e.getKeyCode() == KeyEvent.VK_S) yVelocity = 0;
                break;
            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP) yVelocity = 0;
                if (e.getKeyCode() == KeyEvent.VK_DOWN) yVelocity = 0;
                break;
        }
    }
    
    public void shrink() {
    if(height > 100) {
        height -= 10;
    }
}
}