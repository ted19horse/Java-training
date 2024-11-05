package am_Frame_Thread;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DownBallFrameEx1 extends JFrame {
  JPanel p;
  int y = 0;
  boolean isRunning = false;

  Thread t1 = new Thread() {
    @Override
    public void run() {
      /*
       * 현 스레드가 해야할 일들...
       * 1) y좌표 증가
       * 2) p의 그림 다시 그리기
       * 3) 일정 시간 휴식(sleep)
       * 4) 1~3을 반복
       */

      while (true) {
        y += 8;

        // 바닥에 도달했다면 무한반복 탈출!
        if (y > p.getHeight() - 60) {
          break;
        }

        p.repaint();
        try {
          Thread.sleep(20);
        } catch (Exception e) {
          // 예외가 발생했을 때만 수행하는 곳, 할 일이 없으면 니용이 없어도 된다.
        }
      } // 무한반복의 끝
    }
    // Thread를 상속받는 내부클래스
  };

  public DownBallFrameEx1() {
    this.add(p = new JPanel() {

      @Override
      protected void paintComponent(Graphics g) {
        // 더블버퍼링 기법을 사용하기 위해 Image객체를
        // 현재 JPanel과 같은 크기로 만들자.
        Image buf = createImage(this.getWidth(), this.getHeight());

        // 이렇게 준비된 Image에는 g라는 Graphics로 그림을 그릴 수 없다.
        // Image객체에만 그림을 그리는 전용 붓을 준비하자
        Graphics buf_g = buf.getGraphics();
        buf_g.setColor(Color.MAGENTA);
        buf_g.fillOval(170, DownBallFrameEx1.this.y, 60, 60);

        // 그림이 그려진 Image를 현재 JPanel에 추가해야 한다.
        g.drawImage(buf, 0, 0, this);
      }

    });
    p.setFocusable(true);

    this.setBounds(100, 100, 400, 500);
    this.setVisible(true);

    // 이벤트 감지자 등록
    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0); // 프로그램 종료
      }
    });

    // 스페이스 바를 눌렀을 때 t1이라는 스레드가 구동되기를 원한다면
    // 다음과 같은 KeyListener(감지자)를 등록해야 한다.
    p.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
          case KeyEvent.VK_SPACE:
            if (!isRunning) {
              isRunning = true;
              t1.start();
            }
            break;
        }
      }
    });

  }

  public static void main(String[] args) {
    new DownBallFrameEx1();
  }
}
