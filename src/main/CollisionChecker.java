package src.main;

import java.awt.Rectangle;

import src.entity.Player;

public class CollisionChecker {
  GamePanel gp;
  public CollisionChecker(GamePanel gp) {
    this.gp = gp;
  }

  public static boolean isColliding(Player player, Rectangle tile) {
    Rectangle pRect = player.getBounds();
    Rectangle tRect = tile.getBounds();
    // System.out.println("Player: " + pRect);
    // System.out.println("Tile: " + tRect);

    if (pRect.intersects(tRect)) {
      return true;
    } else {
      return false;
    }
  }
}
