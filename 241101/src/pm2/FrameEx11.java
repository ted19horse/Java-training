package pm2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class FrameEx11 extends JFrame implements KeyListener {
  CanvasEx11 can;
  int x, y, cmd;

  public FrameEx11() {
    this.add(can = new CanvasEx11());

    this.setBounds(400, 100, 600, 600);
    this.setVisible(true);
    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    can.x = can.getWidth() / 2 - can.l / 2;
    can.y = can.getHeight() / 2 - can.l / 2;
    can.repaint();

    this.addKeyListener(this);
    can.addKeyListener(this);
  }

  @Override
  public void keyPressed(KeyEvent e) {
    int code = e.getKeyCode();
    int mv = 10;
    switch (code) {
      case KeyEvent.VK_UP:
        can.y -= mv;
        break;
      case KeyEvent.VK_DOWN:
        can.y += mv;
        break;
      case KeyEvent.VK_LEFT:
        can.x -= mv;
        break;
      case KeyEvent.VK_RIGHT:
        can.x += mv;
        break;
    }
    if (can.y < 0) {
      can.y = 0;
    } else if (can.y + can.l > can.getHeight()) {
      can.y = can.getHeight() - can.l;
    }
    if (can.x < 0) {
      can.x = 0;
    } else if (can.x + can.l > can.getWidth()) {
      can.x = can.getWidth() - can.l;
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

  public static void main(String[] args) {
    new FrameEx11();
  }
}
