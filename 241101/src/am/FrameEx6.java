package am;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class FrameEx6 extends JFrame implements MouseMotionListener {
  // 현재창에 들어갈 객체들 모두 멤버변수로 선언
  CanvasEx6 can;

  public FrameEx6() {
    this.add(can = new CanvasEx6());

    this.setBounds(300, 50, 500, 450);
    this.setVisible(true);
    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    // 이벤트 감지자 등록 - 캔버스 위에서 마우스를 이동할 것이므로 이벤트 대상객체는 캔버스다.
    can.addMouseMotionListener(this);
  }

  @Override
  public void mouseDragged(MouseEvent e) {

  }

  @Override
  public void mouseMoved(MouseEvent e) {
    // 마우스가 이동할 때 마다 호출되는 곳
    // 현재 마우스의 위치(x,y)를 캔버스의 멤버변수인 x,y에 저장한다.
    can.x = e.getX();
    can.y = e.getY();
    can.repaint(); // -> update() -> paint()
  }

  public static void main(String[] args) {
    new FrameEx6();
  }
}
