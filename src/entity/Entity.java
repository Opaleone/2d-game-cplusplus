package src.entity;

import java.awt.Rectangle;

public class Entity {

  public int x, y, width, height;
  public int speed;
  // set area for collision
  public Rectangle colArea;
  public boolean colOn = true;
}
