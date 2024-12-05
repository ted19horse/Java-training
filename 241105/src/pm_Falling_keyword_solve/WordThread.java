package pm_Falling_keyword_solve;

import java.awt.*;

public class WordThread extends Thread {
  // 부모창의 주소
  FrameEx1 f;
  int x, y; // 좌표값
  Color color; // 글자 색
  int speed; // 내려가는 속도(20~1000)
  String str; // 단어 저장할 변수

  public WordThread(FrameEx1 f) {
    this.f = f;
    x = (int) (Math.random() * f.p.getWidth() - 80);
    y = -20;
    speed = (int) (Math.random() * 980 + 20);

    int r = (int) (Math.random() * 256);
    int g = (int) (Math.random() * 256);
    int b = (int) (Math.random() * 256);
    color = new Color(r, g, b);

    // str
    str = f.txt_ar[(int) (Math.random() * f.txt_ar.length)];
  }

  @Override
  public void run() {

    // y의 값이 부모창의 높이보다 크다면 반복문 탈출
    while (true) {
      y += 5;

      if (y > f.p.getHeight() - 15) {
        break;
      }
      f.p.repaint();
      // 부모창에 있는 JPanel을 다시 그린다.

      try {
        Thread.sleep(speed);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    // 부모창의 ArrayList에서 현재객체 삭제
    f.list.remove(this);
  }
}
