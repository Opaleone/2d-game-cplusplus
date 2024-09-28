package src.main;
import javax.swing.JFrame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

public class Main {
  public static void main(String[] args) {
    GraphicsDevice myDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
    JFrame window = new JFrame();
    // Allows us to close
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // Can be set to false to restrict panel to pre-designatd size
    window.setResizable(true);
    window.setTitle("My Game");

    GamePanel gamePanel = new GamePanel();
    window.add(gamePanel);

    window.pack();

    window.setLocationRelativeTo(null);
    window.setVisible(true);
    myDevice.setFullScreenWindow(window);

    gamePanel.startGameThread();
  }
}