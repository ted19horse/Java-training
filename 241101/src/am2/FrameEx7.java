package am2;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class FrameEx7 extends JFrame implements MouseListener {
  CanvasEx7 can;

  public FrameEx7() {
    this.add(can = new CanvasEx7());
    this.setBounds(300, 50, 600, 600);
    this.setVisible(true);
    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    // 이벤트 감지자 등록
    can.addMouseListener(this);
  }

  @Override
  public void mouseClicked(MouseEvent e) {

  }

  @Override
  public void mouseEntered(MouseEvent e) {

  }

  @Override
  public void mouseExited(MouseEvent e) {

  }

  @Override
  public void mousePressed(MouseEvent e) {
    // 마우스 버튼을 누를 때마다 호출하는 곳
    // 마우스를 누른 시점의 좌표(x,y)를 얻어낸다.
    OvalEx2 o = new OvalEx2(e.getX(), e.getY());
    can.list.add(o);

    // 캔버스 다시 그리기
    can.repaint();
  }

  @Override
  public void mouseReleased(MouseEvent e) {

  }

  public static void main(String[] args) {
    new FrameEx7();
  }
}
