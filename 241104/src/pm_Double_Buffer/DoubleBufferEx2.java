package pm_Double_Buffer;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DoubleBufferEx2 extends JFrame {
  int x = 210;
  JPanel p = new JPanel() {
    // JPanel 을 상속받는 익명의 내부클래스 정의
    @Override
    protected void paintComponent(Graphics g) {
      // 현재 JPanel 과 같은 크기의 이미지를 생성한다.
      Image buf = createImage(this.getWidth(), this.getHeight());

      // buf 에만 그림을 그릴 수 있는 붓을 얻어낸다.
      Graphics buf_g = buf.getGraphics();
      buf_g.fillRect(x, 235, 80, 30);

      // 그림을 그린 이미지를 JPanel 에 붙여넣는다.
      g.drawImage(buf, 0, 0, this);
    }
    /*
     * Canvas 와 JPanel 에서 DoubleBuffer 를 사용할 때 차이점은
     * Canvas 는 update() 를 재정의 해야 하지만,
     * JPanel 은 할 필요가 없다.
     */
  };

  public DoubleBufferEx2() {
    this.add(p);
    p.setFocusable(true);

    this.setBounds(1000, 100, 500, 500);
    this.setVisible(true);

    // 이벤트 감지자 등록
    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    p.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        // 키를 누를 때마다 현재 영역 수행
        int code = e.getKeyCode();
        switch (code) {
          case KeyEvent.VK_LEFT:
            x -= 5;
            if (x < 0) {
              x = 0;
            }
            break;
          case KeyEvent.VK_RIGHT:
            x += 5;
            if (x > p.getWidth() - 80) {
              x = p.getWidth() - 80;
            }
            break;
        }
        DoubleBufferEx2.this.p.repaint();
      }
    });
  }

  public static void main(String[] args) {
    new DoubleBufferEx2();
  }
}
