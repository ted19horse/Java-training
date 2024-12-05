package pm3_Inner_Class;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InnerFrame extends JFrame {
  public InnerFrame() {
    this.setBounds(300, 50, 300, 300);
    this.setVisible(true);
    this.addWindowListener(new WindowAdapter() {
      // 여기는 WindowAdapter 를 상속받는 익명의 내부클래스
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }

  public static void main(String[] args) {
    new InnerFrame();
  }
}
