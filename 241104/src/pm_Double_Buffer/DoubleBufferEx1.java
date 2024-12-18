package pm_Double_Buffer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DoubleBufferEx1 extends JFrame {
  int x = 200, y = 235, w = 80, h = 30;
  Canvas can;

  public DoubleBufferEx1() {
    this.add(can = new Canvas() {
      @Override
      public void paint(Graphics g) {
        /* 기존 방식 */
        // g.setColor(Color.GREEN);
        // g.fillRect(x, y, w, h);

        /* 더블버퍼 방식 */

        /*
         * 기존의 이미지 repaint() 방식은 update(지우기) 후 paint(그리기)
         * 그래서 이미지가 지워졌다가 다시 그려지는 순간의 공백이 보여 블링크 현상이 생김
         * 더블버퍼 방식은 현재 이미지 위에 다른 이미지를 덧씌우는 방식
         * 블링크 현상이 생기지 않는다
         */

        // 버퍼 기능을 가지고 있는 이미지객체를 하나 준비하자.
        // 크기는 현재 Canvas 와 동일한 크기여야한다.
        int cw = this.getWidth(); // 여기서 this 는 Canvas 를 상속받는 객체 주소 can
        int ch = this.getHeight();

        Image buf = can.createImage(cw, ch); // 현재 캔버스와 같은 크기의 이미지를 생성
        // Image 에만 그림을 그리기 위해
        // Image 로부터 붓(Graphics)을 달라고 해야 한다.
        Graphics buf_g = buf.getGraphics();
        buf_g.setColor(Color.GREEN);
        buf_g.fillRect(x, y, w, h); // 이미지에 도형그리기

        // 이제 buf 이미지를 Canvas 에 그린다.
        g.drawImage(buf, 0, 0, this);
      }

      @Override
      public void update(Graphics g) {
        paint(g); // 지우지 않고 현재 그림상태를 그대로 가지고 paint() 를 호출
      }
    });

    this.setBounds(1000, 100, 500, 600);
    this.setVisible(true);

    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    this.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        DoubleBufferEx1.this.setTitle(code + "번");
        int mv = 10;
        switch (code) {
          case KeyEvent.VK_LEFT:
            DoubleBufferEx1.this.x -= mv;
            if (DoubleBufferEx1.this.x < 0) {
              DoubleBufferEx1.this.x = 0;
            }
            break;
          case KeyEvent.VK_RIGHT:
            DoubleBufferEx1.this.x += mv;
            if (DoubleBufferEx1.this.x > DoubleBufferEx1.this.x + DoubleBufferEx1.this.w) {
              DoubleBufferEx1.this.x = DoubleBufferEx1.this.x + DoubleBufferEx1.this.w;
            }
            break;
        }
        DoubleBufferEx1.this.can.repaint();
      }
    });
  }

  public static void main(String[] args) {
    new DoubleBufferEx1();
  }
}
