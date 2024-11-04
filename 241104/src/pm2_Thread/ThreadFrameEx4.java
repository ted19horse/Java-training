package pm2_Thread;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ThreadFrameEx4 extends JFrame {
  int x = 0;

  ThreadEx4 t4; // 스레드 객체 준비! - 스페이스바를 누르면 생성하자!
  ArrayList<Thread> ar = new ArrayList<Thread>();

  JPanel p = new JPanel() {
    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      // 더블버퍼링을 기법을 쓰기 위해 이미지 객체를 준비
      // 현재 JPanel 의 크기와 같게
      Image buf = createImage(this.getWidth(), this.getHeight());

      // 준비된 이미지객체에게만 그림을 그릴 수 있는 붓과 같은 객체 준비
      Graphics buf_g = buf.getGraphics();
      buf_g.fillRect(x, 200, 20, 20);

      g.drawImage(buf, 0, 0, this);
    }
  };

  public ThreadFrameEx4() {
    this.add(p);

    this.setBounds(1000, 100, 500, 450);
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
        switch (code) {
          case KeyEvent.VK_SPACE:
            // t4 = new ThreadEx4(ThreadFrameEx4.this);
            // t4.start(); // 스레드 시작!!!!!!!!!!!!!!!

            ar.add(new ThreadEx4(ThreadFrameEx4.this) {
              @Override
              public void run() {
                // ThreadFrameEx4 가 가지고 있는 x값을 증가시킨 후
                // 잠시 쉬었다가 ThreadFrameEx4 가 가지는 p 를 다시 그려야 한다.

                // 무한반복
                while (true) {
                  // ThreadFrameEx4 가 가지고 있는 x값을 증가!
                  ThreadFrameEx4.this.x += 5;

                  // f의 x값이 f가 가지는 p의 너비를 넘으면 탈출!
                  if (ThreadFrameEx4.this.x > ThreadFrameEx4.this.p.getWidth() - 20) {
                    break;
                  }

                  ThreadFrameEx4.this.p.repaint();

                  try {
                    Thread.sleep(50);
                  } catch (Exception e) {
                    //
                  }
                }
                // 현재 스레드 소멸 직전!!
              }
            });
            ar.get(ar.size() - 1).start();

            break;
        }
      }
    });
  }

  public static void main(String[] args) {
    new ThreadFrameEx4();
  }
}
