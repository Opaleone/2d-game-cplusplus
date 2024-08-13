package src.tile;

// import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import src.main.GamePanel;

public class TileManager {
  GamePanel gp;
  Tile[] tile;

  public TileManager(GamePanel gp) {
    this.gp = gp;
    tile = new Tile[1];
    getTileImage();
  }

  public void getTileImage() {
    try {
      tile[0] = new Tile();
      tile[0].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/Floor1.png"));
    } catch(IOException e) {
      e.printStackTrace();
    }
  }

  public void draw(Graphics2D g2) {
    // draw straight white line across bottom of frame
    int x = 0;
    int y = gp.screenHeight - 42;
    
    // timesRun = 159
    for (int i = 0; i < (gp.screenWidth / gp.tileSize + 1); i++) {
      if (i == 10 || i == 11 || i == 12 || i == 13) {
        x += gp.tileSize;
        continue;
      }

      g2.drawImage(tile[0].image, x, y, gp.tileSize, gp.tileSize, null);
      x += gp.tileSize;
    }
  }
}
