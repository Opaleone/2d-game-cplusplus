package src;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

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

  // FPS
  int FPS = 60;

  KeyHandler keyH = new KeyHandler();
  Thread gameThread;

  int playerX = 100;
  int playerY = 100;
  int playerSpeed = 20;

  // Creating game panel
  public GamePanel() {
    this.setPreferredSize(new Dimension(screenWidth, screenHeight));
    this.setBackground(Color.black);
    this.setDoubleBuffered(true);
    this.addKeyListener(keyH);
    this.setFocusable(true);
  }

  public void startGameThread() {
    gameThread = new Thread(this);
    gameThread.start();
  }

  // Automatically called when gameThread is called
  public void run() {

    double drawInterval = 1_000_000_000/FPS; // 0.016666 seconds
    double nextDrawTime = System.nanoTime() + drawInterval;

    while(gameThread != null) {
      System.out.println("The game loop is running!");
      update();
      repaint();

      try {
        double remainingTime = nextDrawTime - System.nanoTime();
        remainingTime = remainingTime / 1_000_000;

        if (remainingTime < 0) remainingTime = 0;

        Thread.sleep((long) remainingTime);

        nextDrawTime += drawInterval;
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void update() {
    if (keyH.upPressed) playerY -= playerSpeed;
    if (keyH.downPressed) playerY += playerSpeed;
    if (keyH.leftPressed) playerX -= playerSpeed;
    if (keyH.rightPressed) playerX += playerSpeed;

  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;
    g2.setColor(Color.white);
    g2.fillRect(playerX, playerY, tileSize, tileSize);
    g2.dispose();
  }
}
