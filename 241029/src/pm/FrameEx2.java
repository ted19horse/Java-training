package pm;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameEx2 extends JFrame {
  JButton bt1, bt2, bt3;
  JPanel p1; // 위 버튼 3개를 가지는 나무판자같은 객체

  public FrameEx2(String title) {
    // 제목표시줄에 제목 입력
    this.setTitle(title);
    // 버튼 객체들 생성
    bt1 = new JButton("버튼1");
    bt2 = new JButton("버튼2");
    bt3 = new JButton("버튼3");
    // 패널 객체 생성
    p1 = new JPanel();
    // 패널 객체에 버튼 객체 추가
    p1.add(bt1);
    p1.add(bt2);
    p1.add(bt3);
    // 현재창 North영역에 패널 추가
    this.add(p1, BorderLayout.NORTH);

    this.setSize(860, 680);
    this.setLocation(300, 50);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }

  public static void main(String[] args) {
    FrameEx2 ex = new FrameEx2("패널연습");
  }
}
