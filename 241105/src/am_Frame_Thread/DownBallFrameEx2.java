package am_Frame_Thread;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DownBallFrameEx2 extends JFrame {
  /* Field */
  JPanel p;
  ArrayList<OvalEx2> list = new ArrayList<OvalEx2>();

  /* Constructer */
  public DownBallFrameEx2() {
    this.add(p = new JPanel() {
      @Override
      protected void paintComponent(Graphics g) {
        // 사용자가 클릭할 때 마다 타원 객체가 생성되어 저장

        // 현재 JPanel과 크기가 같은 Image를 생성
        Image buf = createImage(this.getWidth(), this.getHeight());

        // buf에만 그림을 그릴수 있는 Graphics를 얻어낸다.
        Graphics buf_g = buf.getGraphics();

        // 사용자가 클릭할 때마다 타원객체가 생성되어 저장되는 list를
        // 반복하여 하나씩 얻어내어 그림을 그린다.
        for (int i = 0; i < list.size(); i++) {
          OvalEx2 oval = list.get(i);
          buf_g.setColor(oval.c);
          buf_g.fillOval(oval.x, oval.y, oval.wh, oval.wh);
        }

        g.drawImage(buf, 0, 0, this);
      }
    });
    p.setFocusable(true);

    this.setBounds(1000, 100, 500, 600);
    this.setVisible(true);

    /* Event listener */
    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    p.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        // 마우스를 누를때 마다 호출되는 곳
        int x = e.getX();
        int y = e.getY();

        // 타원객체(OvalEx2) 생성
        OvalEx2 ov = new OvalEx2(DownBallFrameEx2.this, x, y);
        list.add(ov);

        // OvalEx2가 스레드를 상속 받았기 때문에 스레드이다.
        // 이쯤에서 스레드 구동!
        ov.start(); // --> OvalEx2의 run() 메서드를 수행한다.
      }
    });
  }

  /* Event handler */
  public static void main(String[] args) {
    new DownBallFrameEx2();
  }
}
