package am;

import javax.swing.*;

public class FrameEx3 extends JFrame {
  public FrameEx3() {
    this.setSize(500, 450);
    this.setLocation(500, 50);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 누를때 종료
    this.setVisible(true);
  }

  public static void main(String[] args) {
    // 현재 클래스 생성

    // FrameEx3 ex = new FrameEx3();
    new FrameEx3(); // 객체 생성만 할거면 생성자만 호출해도 된다.

    // ex.setSize(500, 450);
    // ex.setVisible(true);
    // ex.setLocation(500, 50);
    // 함수 호출은 생성자에서 하는것이 바람직하다.
  }
}
