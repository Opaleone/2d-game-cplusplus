package src.tile;

import java.awt.Color;
import java.awt.Graphics2D;

import src.main.GamePanel;

public class TileManager {
  GamePanel gp;
  Tile[] tile;

  public TileManager(GamePanel gp) {
    this.gp = gp;
  }

  public void draw(Graphics2D g2) {
    int x = 0;
    int y = gp.screenHeight - 40;
    
    for (int i = 0; i < gp.screenWidth; i++) {
      g2.setColor(Color.white);
      g2.fillRect(x, y, gp.tileSize, gp.tileSize);
      x += gp.tileSize;
    }
  }
}
