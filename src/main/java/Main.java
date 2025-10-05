/**
* This is a java swing program to test animation
* @author Alesya Hathaway
* @version 4/6/2025
*/

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args){
        JFrame frame = new JFrame("Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("2D Game");

        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);
        
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        gamePanel.setupGame();
        gamePanel.startGameThread();
    }
}
