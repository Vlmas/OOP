package game.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Field extends JPanel implements ActionListener {
    private boolean inGame = true;

    private boolean movingRightward = true;
    private boolean movingLeftward = false;
    private boolean movingDownward = false;
    private boolean movingUpward = false;

    private final int SIZE = 400;
    private final int ENTITY_SIZE = 20;
    private final int ALL_SNAKE_BODIES = 400;
    private int foodX;
    private int foodY;
    private int snakeParts;

    private final int[] snakeX = new int[ALL_SNAKE_BODIES];
    private final int[] snakeY = new int[ALL_SNAKE_BODIES];

    private Image snake;
    private Image food;

    Color color = new Color(219, 219, 46);

    public Field() {
        setBackground(color);
        loadImages();
        init();
        addKeyListener(new LocalKeyListener());
        setFocusable(true);
    }

    protected void loadImages() {
        ImageIcon snakeIcon = new ImageIcon("C:/Programming/OOP/SnakeGame/src/game/snake/snake.png");
        ImageIcon foodIcon = new ImageIcon("C:/Programming/OOP/SnakeGame/src/game/snake/food.png");
        snake = snakeIcon.getImage();
        food = foodIcon.getImage();
    }

    protected void init() {
        snakeParts = 2;

        for(int i = 0; i < snakeParts; i++) {
            snakeX[i] = 60 - i * ENTITY_SIZE;
            snakeY[i] = 60;
        }

        Timer timer = new Timer(95, this);
        timer.start();

        createFood();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(inGame) {
            g.drawImage(food, foodX, foodY, this);

            for(int i = 0; i < snakeParts; i++) {
                g.drawImage(snake, snakeX[i], snakeY[i], this);
            }

            Font font = new Font("Times New Roman", Font.BOLD, 16);
            g.setFont(font);
            g.setColor(Color.BLACK);
            g.drawString("Score: " + (snakeParts - 1), 2, 15);
        } else {
            String s = "YOU LOST";
            Color DARK_RED = new Color(150, 0, 0);
            Font font = new Font("Times New Roman", Font.BOLD, 20);
            g.setFont(font);
            g.setColor(DARK_RED);
            g.drawString(s, 150, SIZE / 2 - 10);
        }
    }

    protected void createFood() {
        foodX = new Random().nextInt(19) * ENTITY_SIZE;
        foodY = new Random().nextInt(19) * ENTITY_SIZE;
    }

    protected void move() {
        for(int i = snakeParts; i > 0; i--) {
            snakeX[i] = snakeX[i - 1];
            snakeY[i] = snakeY[i - 1];
        }

        if(movingUpward) {
            snakeY[0] -= ENTITY_SIZE;
        }
        else if(movingDownward) {
            snakeY[0] += ENTITY_SIZE;
        }
        else if(movingRightward) {
            snakeX[0] += ENTITY_SIZE;
        }
        else if(movingLeftward) {
            snakeX[0] -= ENTITY_SIZE;
        }
    }

    protected void checkForFood() {
        if(snakeX[0] == foodX && snakeY[0] == foodY) {
            snakeParts++;
            createFood();
        }
    }

    protected void checkForCollisions() {
        for(int i = snakeParts; i > 0; i--) {
            if(i > 4 && snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]) {
                inGame = false;
                break;
            }
        }

        if(snakeX[0] > SIZE || snakeX[0] < 0 || snakeY[0] > SIZE || snakeY[0] < 0) {
            inGame = false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(inGame) {
            checkForFood();
            checkForCollisions();
            move();
        }

        repaint();
    }

    class LocalKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);

            int k = e.getKeyCode();

            if(k == KeyEvent.VK_W && !movingDownward) {
                movingUpward = true;
                movingLeftward = false;
                movingRightward = false;
            }
            else if(k == KeyEvent.VK_S && !movingUpward) {
                movingDownward = true;
                movingLeftward = false;
                movingRightward = false;
            }
            else if(k == KeyEvent.VK_D && !movingLeftward) {
                movingRightward = true;
                movingUpward = false;
                movingDownward = false;
            }
            else if(k == KeyEvent.VK_A && !movingRightward) {
                movingLeftward = true;
                movingUpward = false;
                movingDownward = false;
            }

            if(k == KeyEvent.VK_ESCAPE) {
                inGame = false;
            }
        }
    }
}