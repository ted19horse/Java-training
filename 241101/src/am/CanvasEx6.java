package am;

import java.awt.Canvas;
import java.awt.Graphics;

public class CanvasEx6 extends Canvas {
  // 마우스 이동 이벤트를 감지하여 위치값(x,y)를 저장할 변수
  int x, y;

  @Override
  public void paint(Graphics g) {
    // 마우스가 이동하는 좌표값을 문자열로 그린다.
    StringBuffer sb = new StringBuffer("x:");
    sb.append(x);
    sb.append(", y:");
    sb.append(y);
    g.drawString(sb.toString(), x, y);
  }

  @Override
  public void update(Graphics g) {

  }

}
