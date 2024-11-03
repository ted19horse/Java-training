package pm2;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class CanvasEx11 extends Canvas {
  int x, y, l = 30, cmd;

  @Override
  public void paint(Graphics g) {
    g.setColor(Color.RED);
    g.fillRect(x, y, l, l);
  }

}
