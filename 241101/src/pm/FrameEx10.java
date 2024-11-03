package pm;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class FrameEx10 extends JFrame implements KeyListener {
  CanvasEx10 can;

  public FrameEx10() {
    this.add(can = new CanvasEx10());

    this.setBounds(500, 100, 300, 300);
    this.setVisible(true);

    this.addKeyListener(this);
    can.addKeyListener(this); // 둘 다 사용 가능하지만, Canvas 에 리스너를 등록하면 마우스를 한 번 클릭해서 캔버스로 포커스를 잡아야 한다.
  }

  @Override
  public void keyPressed(KeyEvent e) {
    // 키보드의 키를 누를 때 수행하는 곳
    // 누른 키를 CanvasEx10 의 cmd 에 저장
    can.cmd = e.getKeyCode();
    can.repaint(); // > update() > paint()
  }

  @Override
  public void keyReleased(KeyEvent e) {

  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

  public static void main(String[] args) {
    new FrameEx10();
  }
}
