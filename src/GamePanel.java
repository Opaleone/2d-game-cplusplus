package src;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;

public class GamePanel extends JPanel implements Runnable {
  // Sets size and scale to create panel
  final int originalTileSize = 16;
  final int scale = 3;

  // Finds actual size
  final int tileSize = originalTileSize * scale;
  final int maxScreenCol = 16;
  final int maxScreenRow = 12;
  final int screenWidth = tileSize * maxScreenCol;
  final int screenHeight = tileSize * maxScreenRow;

  Thread gameThread;

  // Creating game panel
  public GamePanel() {
    this.setPreferredSize(new Dimension(screenWidth, screenHeight));
    this.setBackground(Color.black);
    this.setDoubleBuffered(true);
  }

  public void startGameThread() {
    gameThread = new Thread(this);
    gameThread.start();
  }

  // Automatically called when gameThread is called
  public void run() {
    while(gameThread != null) {
      System.out.println("The game loop is running!");

      // UPDATE: Character information and position
      // DRAW: Character on screen based on Character position
    }
  }
}
