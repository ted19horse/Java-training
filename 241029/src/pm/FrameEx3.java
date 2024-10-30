package pm;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameEx3 extends JFrame {
  // JButton b1, b2, b3, b4, b5;
  JButton[] bt_ar = new JButton[5];
  JPanel p1;

  public FrameEx3(String title) {
    this.setTitle(title);

    p1 = new JPanel();
    /*
     * b1 = new JButton("버튼1");
     * b2 = new JButton("버튼2");
     * b3 = new JButton("버튼3");
     * b4 = new JButton("버튼4");
     * b5 = new JButton("버튼5");
     * 
     * p1.add(b1);
     * p1.add(b2);
     * p1.add(b3);
     * p1.add(b4);
     * p1.add(b5);
     */

    for (int i = 0; i < bt_ar.length; i++) {
      bt_ar[i] = new JButton("버튼" + (i + 1));
      p1.add(bt_ar[i]);
    }

    this.add(p1, BorderLayout.SOUTH);

    this.setSize(860, 680);
    this.setLocation(300, 60);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }

  public static void main(String[] args) {
    // FrameEx3 ex = new FrameEx3("타이틀");
    new FrameEx3("타이틀"); // 변수를 재사용하지 않는다면 생성자만 호출해도 된다.
  }
}
