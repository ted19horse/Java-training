package pm2;

import java.awt.*;

public class CanvasEx11 extends Canvas {
  int x, y, l = 30, cmd;

  @Override
  public void paint(Graphics g) {
    g.setColor(Color.RED);
    g.fillRect(x, y, l, l);
  }

}
