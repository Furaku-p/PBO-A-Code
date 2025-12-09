import java.awt.*;

public class Ball {
    int x, y;
    int xVelocity = 3;
    int yVelocity = 3;
    int diameter = 30;
    public Paddle player1;
    public Paddle player2;

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, diameter, diameter);
    }

    public int move() {
        x += xVelocity;
        y += yVelocity;

        if(y <= 0 || y >= GamePanel.GAME_HEIGHT - diameter) {
            yVelocity = -yVelocity;
        }
        
        if (x <= player1.x + player1.width &&
            y + diameter >= player1.y &&
            y <= player1.y + player1.height) {
            xVelocity = Math.abs(xVelocity);
        }

        if (x + diameter >= player2.x &&
            y + diameter >= player2.y &&
            y <= player2.y + player2.height) {
            xVelocity = -Math.abs(xVelocity);
        }
        
        if (x <= 0) return 2;
        
        if (x >= GamePanel.GAME_WIDTH - diameter) return 1;

        return 0;

        
    }

    
    public void increaseSpeed() {
        if (Math.abs(xVelocity) < 20) {
            if (xVelocity > 0 ) xVelocity += 1;
            else xVelocity -= 1;
        }
        if (Math.abs(yVelocity) < 20) {
            if (yVelocity > 0 ) yVelocity += 1;
            else yVelocity -= 1;
        }
    }
}