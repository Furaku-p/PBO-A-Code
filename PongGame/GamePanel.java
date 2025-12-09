import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable {
    static final int GAME_WIDTH = 800;
    static final int GAME_HEIGHT = 600;
    Thread gameThread;
    Paddle player1, player2;
    Ball ball;
    int score1 = 0;
    int score2 = 0;
    boolean waitingForPlayer = false;
    long lastSpeedIncrease = System.currentTimeMillis();
    boolean gameOver = false;
    String winnerText = "";
    JButton restartButton;

    public GamePanel() {
        player1 = new Paddle(0, (GAME_HEIGHT/2)-50, 1);
        player2 = new Paddle(GAME_WIDTH-20, (GAME_HEIGHT/2)-50, 2);
        ball = new Ball((GAME_WIDTH/2)-15, (GAME_HEIGHT/2)-15);
        
        ball.player1 = player1;
        ball.player2 = player2;

        this.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new AL());

        gameThread = new Thread(this);
        gameThread.start();
        
        restartButton = new JButton("Restart");
        restartButton.setFocusable(false);
        restartButton.setVisible(false);
        
        restartButton.addActionListener(e -> restartGame());
        
        this.add(restartButton);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }


    public void draw(Graphics g) {
        player1.draw(g);
        player2.draw(g);
        ball.draw(g);
        
        g.setColor(Color.WHITE);
        g.setFont(new Font("Consolas", Font.BOLD, 40));
        g.drawString(score1 + "   -   " + score2, GAME_WIDTH/2 - 60, 50);
        
        if (gameOver) {
            g.setColor(Color.YELLOW);
            g.setFont(new Font("Consolas", Font.BOLD, 50));
            g.drawString(winnerText, GAME_WIDTH/2 - 250, GAME_HEIGHT/2);
        }
    }

    public void move() {
        player1.move();
        player2.move();
        
        if (waitingForPlayer) return;
        
        int goal = ball.move();

        if (goal == 1) {
            score1++;
            player1.shrink();
            checkWinner();
            resetBall();
        } else if (goal == 2) {
            score2++;
            player2.shrink();
            checkWinner();
            resetBall();
        }
    }

    public void run() {
        double nsPerFrame = 1000000000 / 60.0;
        long lastTime = System.nanoTime();
        double delta = 0;

        while(true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / nsPerFrame;
            lastTime = now;

            while(delta >= 1) {
                move();
                repaint();
                delta--;
            }
            
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastSpeedIncrease >= 5000) {
                ball.increaseSpeed();
                lastSpeedIncrease = currentTime;
            }
        }
    }

    public class AL extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            waitingForPlayer = false;
            player1.keyPressed(e);
            player2.keyPressed(e);
        }

        public void keyReleased(KeyEvent e) {
            player1.keyReleased(e);
            player2.keyReleased(e);
        }
    }
    
    public void resetBall() {
        ball.x = GAME_WIDTH/2 - ball.diameter/2;
        ball.y = GAME_HEIGHT/2 - ball.diameter/2;
        waitingForPlayer = true;
        
        ball.xVelocity = (Math.random() < 0.5 ? 3 : -3);
        ball.yVelocity = (Math.random() < 0.5 ? 3 : -3);
    }
    
    public void checkWinner() {
        if (score1 == 10) {
            winnerText = "PLAYER 1 WINS!";
            gameOver = true;
            restartButton.setVisible(true);
        }
        if (score2 == 10) {
            winnerText = "PLAYER 2 WINS!";
            gameOver = true;
            restartButton.setVisible(true);
        }
    }
    
    public void restartGame() {
        score1 = 0;
        score2 = 0;
    
        player1.height = 200;  // tinggi awal (atau 100 kalau default)
        player2.height = 200;
    
        ball.x = GAME_WIDTH / 2 - ball.diameter/2;
        ball.y = GAME_HEIGHT / 2 - ball.diameter/2;
        ball.xVelocity = 3;
        ball.yVelocity = 3;
    
        waitingForPlayer = true;
        gameOver = false;
    
        restartButton.setVisible(false);
    }
}