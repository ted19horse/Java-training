package pm4_Inner_Class_with_Canvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameEx5 extends JFrame {
  int x = 30, y = 100, l = 30;

  Canvas can = new Canvas() {
    // Canvas 를 상속받는 익명의 내부클래스(멤버)
    @Override
    public void paint(Graphics g) {
      g.fillRect(x, y, l, l);
    }
  };

  public FrameEx5() {
    this.add(can); // 기존 방법, 현재 창에 캔버스를 가운데에 추가

    this.setBounds(300, 50, 500, 450);
    this.setVisible(true);

    x = can.getWidth() / 2 - l / 2;
    y = can.getHeight() / 2 - l / 2;
    can.repaint();

    // WindowAdapter 를 상속받는 익명의 내부클래스(지역)
    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    this.addKeyListener(new KeyListener() {
      @Override
      public void keyPressed(KeyEvent e) {
        // 키가 눌렸을 때
        int code = e.getKeyCode(); // 어떤 키가 눌렸는지
        int mv = 10; // 얼마나 움직일건지
        switch (code) { // 눌린 키에 따른 움직임
          case KeyEvent.VK_UP:
            y -= mv;
            break;
          case KeyEvent.VK_DOWN:
            y += mv;
            break;
          case KeyEvent.VK_LEFT:
            x -= mv;
            break;
          case KeyEvent.VK_RIGHT:
            x += mv;
            break;
        }
        // 창 크기를 벗어나지 않도록
        if (y < 0) {
          y = 0;
        } else if (y + l > can.getHeight()) {
          y = can.getHeight() - l;
        }
        if (x < 0) {
          x = 0;
        } else if (x + l > can.getWidth()) {
          x = can.getWidth() - l;
        }
        // 좌표가 변경됐으니 캔버스의 그림을 다시 그린다.
        can.repaint();
      }

      @Override
      public void keyReleased(KeyEvent e) {

      }

      @Override
      public void keyTyped(KeyEvent e) {

      }
    });
  }

  public static void main(String[] args) {
    new FrameEx5();
  }
}
