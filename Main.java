import javax.swing.JFrame;

import src.*;

public class Main {
  public static void main(String[] args) {
    JFrame window = new JFrame();
    // Allows us to close
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // Can be set to false to restrict panel to pre-designatd size
    window.setResizable(true);
    window.setTitle("2d game Tutorial");

    GamePanel gamePanel = new GamePanel();
    window.add(gamePanel);

    window.pack();

    window.setLocationRelativeTo(null);
    window.setVisible(true);

    gamePanel.startGameThread();
  }
}