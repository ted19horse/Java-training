package am2;

import java.awt.Color;

public class OvalEx2 {
  int x, y, wh;
  Color c;

  public OvalEx2(int x, int y) {
    this.x = x;
    this.y = y;

    // 색상을 랜덤하게
    int r = (int) (Math.random() * 255 + 1);
    int g = (int) (Math.random() * 255 + 1);
    int b = (int) (Math.random() * 255 + 1);
    c = new Color(r, g, b);

    // 크기(너비,높이) 지정
    wh = (int) (Math.random() * 150 + 50);

    this.x -= (wh / 2);
    this.y -= (wh / 2);
  }
}
