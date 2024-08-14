package src.entity;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import src.main.GamePanel;
import src.main.KeyHandler;

public class Player extends Entity {
  GamePanel gp;
  KeyHandler keyH;

  public Player(GamePanel gp, KeyHandler keyH) {
    this.gp = gp;
    this.keyH = keyH;

    colArea = new Rectangle(0,0,gp.tileSize,gp.tileSize);

    setDefaultValues();
  }

  public void setDefaultValues() {
    x = 100;
    y = 100;
    speed = 15;
  }

  public void update() {
    if (x > gp.screenWidth) x = 0;
    if (y > gp.screenHeight) y = 0;
    if (x < 0) x = gp.screenWidth;
    if (y < 0) y = gp.screenHeight;

    // start of collision checker feature
    // colOn = false;
    // gp.cChecker.checkTile(this);

    // if (y < (gp.screenHeight - 42 - gp.tileSize)) {
    //   if (keyH.upPressed) y -= speed;
    //   if (keyH.downPressed) y += speed;
    //   if (keyH.leftPressed) x -= speed;
    //   if (keyH.rightPressed) x += speed;
    // }
  }
  public void draw(Graphics2D g2) {
    g2.setColor(Color.white);
    g2.fillRect(x, y, gp.tileSize, gp.tileSize);
  }
}
