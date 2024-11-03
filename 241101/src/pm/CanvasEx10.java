package pm;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class CanvasEx10 extends Canvas {
  int cmd; // 사용자가 선택한 키의 코드값이 저장되는 곳
  int x = 10, y = 10;

  @Override
  public void paint(Graphics g) {
    // 1번 키를 눌렀을 때 타원을 그린다
    // 2번 키를 눌렀을 때 채워진 타원을 그린다
    // 3번 키를 눌렀을 때 사각형을 그린다
    // 4번 키를 눌렀을 때 채워진 사각형을 그린다
    int rd = (int) (Math.random() * 256);
    int gr = (int) (Math.random() * 256);
    int bl = (int) (Math.random() * 256);
    Color c = new Color(rd, gr, bl);
    g.setColor(c);
    switch (cmd) {
      case KeyEvent.VK_1: {
        g.drawOval(x, y, 100, 100);
        break; // 스위치문 탈출
      }
      case KeyEvent.VK_2: {
        g.fillOval(x, y, 100, 100);
        break; // 스위치문 탈출
      }
      case KeyEvent.VK_3: {
        g.drawRect(x, y, 100, 100);
        break; // 스위치문 탈출
      }
      case KeyEvent.VK_4: {
        g.fillRect(x, y, 100, 100);
        break; // 스위치문 탈출
      }
      case KeyEvent.VK_5: {
        g.drawString("쌍용교육센터", x, y);
      }
    }
  }
}
