package pm;

import java.awt.*;

public class MyCanvas extends Canvas {

  @Override
  public void paint(Graphics g) {
    // Canvas 에 포함되어 있는 Empty Method
    // Graphics 가 곧 붓과 같은 객체다.
    g.drawString("쌍용교육센터", 100, 100);

    g.setColor(Color.BLUE);
    g.fillRect(100, 160, 120, 120);

    g.setColor(Color.RED);
    g.fillRect(120, 180, 80, 80);

    g.setColor(Color.ORANGE);
    g.drawRect(230, 160, 120, 120);

    g.setColor(Color.RED);
    g.fillOval(230, 160, 120, 120);
  }

}
