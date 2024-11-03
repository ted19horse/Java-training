package am3;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class CanvasEx8 extends Canvas {
  Toolkit tk; // 이미지를 생성할 때 필요하다.

  public CanvasEx8() {
    tk = Toolkit.getDefaultToolkit();
  }

  @Override
  public void paint(Graphics g) {
    // Toolkit 을 이용하여 이미지를 생성
    Image img = tk.getImage(getClass().getResource("/images/1.gif"));

    g.drawImage(img, 100, 50, 120, 120, this); // this 는 이미지 옵저버를 뜻한다.
  }
}