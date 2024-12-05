package am_Frame_Thread;

import java.awt.*;

public class OvalEx2 extends Thread {
  // 클릭할 때마다 생성되는 타원객체
  int x, y, wh;
  Color c;
  // 부모창 객체의 주소가 필요함 (CallbyReference)
  DownBallFrameEx2 d = null;

  public OvalEx2(DownBallFrameEx2 d, int x, int y) {
    // 부모창의 주소를 현재영역이 아닌 run()에서도 사용해야 함
    this.d = d;
    this.x = x;
    this.y = y;

    this.wh = (int) (Math.random() * 150 + 50);

    int r = (int) (Math.random() * 256);
    int g = (int) (Math.random() * 256);
    int b = (int) (Math.random() * 256);
    this.c = new Color(r, g, b);
  }

  @Override
  public void run() {
    // 현재 스레드가 해야할 일은 y좌표를 증가시키면서
    // 바닥에 닿으면 멈추고
    // JPanel을 다시 그린다.
    x -= wh / 2;
    y -= wh / 2;
    while (true) {
      y += 5;
      if (y > d.p.getHeight() - wh) {
        break;
      }
      d.p.repaint();

      try {
        Thread.sleep((int) (Math.random() * 50 + 1));
      } catch (Exception e) {
        //
      }
    }
  }
}
