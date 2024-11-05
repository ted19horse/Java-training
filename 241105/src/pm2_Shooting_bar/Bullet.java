package pm2_Shooting_bar;

import java.awt.Color;

public class Bullet extends Thread {
  int x, y, w = 5, h = 10;
  Color color = new Color(184, 155, 51);
  Frame f;

  public Bullet(Frame f, int x, int y) {
    this.f = f;
    this.x = x;
    this.y = y - this.h;
  }

  @Override
  public void run() {
    while (true) {
      this.y -= 10;
      if (this.y <= 0) {
        f.panelPalette.repaint();
        break;
      }
      f.panelPalette.repaint();

      try {
        Thread.sleep(10);
      } catch (Exception e) {
      }
    }
    f.list.remove(this);
  }
}
