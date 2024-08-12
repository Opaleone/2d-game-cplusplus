package src.main;

import javax.swing.JPanel;

import src.entity.Player;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

public class GamePanel extends JPanel implements Runnable {
  // Sets size and scale to create panel
  final int originalTileSize = 16;
  final int scale = 3;

  public final int tileSize = originalTileSize * scale;
  
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  public int screenHeight = (int)screenSize.getHeight();
  public int screenWidth = (int)screenSize.getWidth();

  // FPS
  int FPS = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0].getDisplayMode().getRefreshRate();

  KeyHandler keyH = new KeyHandler();
  Thread gameThread;
  Player player = new Player(this, keyH);

  int playerX = 100;
  int playerY = 100;
  int playerSpeed = 15;

  // Creating game panel
  public GamePanel() {
    this.setPreferredSize(new Dimension(screenWidth, screenHeight));
    this.setBackground(Color.black);
    this.setDoubleBuffered(true);
    this.addKeyListener(keyH);
    this.setFocusable(true);
  }

  public void startGameThread() {
    System.out.println(screenHeight);
    System.out.println(screenWidth);
    gameThread = new Thread(this);
    gameThread.start();
  }

  // Automatically called when gameThread is called
  public void run() {

    double drawInterval = 1_000_000_000/FPS; // 0.016666 seconds
    double nextDrawTime = System.nanoTime() + drawInterval;

    while(gameThread != null) {
      // System.out.println("The game loop is running!");
      // System.out.println(playerX);
      // System.out.println(playerY);
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
    player.update();
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;
    player.draw(g2);
    g2.dispose();
  }
}
