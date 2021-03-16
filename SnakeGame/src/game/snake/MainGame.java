package game.snake;

import javax.swing.*;

public class MainGame extends JFrame {
    public MainGame() {
        super("Snake Game by Almas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 425);
        setLocationRelativeTo(null);
        add(new Field());
    }

    public static void main(String[] args) {
        MainGame game = new MainGame();
        game.setVisible(true);
    }
}