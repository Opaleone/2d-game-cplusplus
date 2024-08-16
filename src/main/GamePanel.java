package src.main;

import javax.swing.JPanel;

import src.entity.Player;
import src.tile.TileManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;

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

  TileManager floor = new TileManager(this);
  KeyHandler keyH = new KeyHandler();
  Thread gameThread;
  public CollisionChecker cChecker = new CollisionChecker(this);
  Player player = new Player(this, keyH);
  public ArrayList<Rectangle> tiles = new ArrayList<Rectangle>();

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
    player.move(tiles);
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;
    floor.draw(g2);
    player.draw(g2);
    g2.dispose();
  }
}
