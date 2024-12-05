package am_Timer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TimerEx1 extends JFrame {
  Canvas can = new Canvas() {
    @Override
    public void paint(Graphics g) {
      g.setColor(Color.ORANGE);
      g.fillRect(x, y, wh, wh);
    }
  };
  int wh = 20, x, y;
  boolean isRunning; // 기본값 false
  int direction; // 이동하는 방향을 기억하는 변수

  // Unicode 상으로 37 38 39 40
  int[] ar = { KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_UP, KeyEvent.VK_DOWN };

  Timer timer;

  public TimerEx1() {
    timer = new Timer(100, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // 상자가 이동할 방향(direction)으로 좌표를 수정
        switch (TimerEx1.this.direction) {
          case KeyEvent.VK_LEFT:
            TimerEx1.this.x -= 5;
            break;
          case KeyEvent.VK_RIGHT:
            TimerEx1.this.x += 5;
            break;
          case KeyEvent.VK_UP:
            TimerEx1.this.y -= 5;
            break;
          case KeyEvent.VK_DOWN:
            TimerEx1.this.y += 5;
            break;
        }
        // 좌표가 변경되었으니 캔버스에 그림을 다시 그리자
        TimerEx1.this.can.repaint();
      }
    });
    this.add(can);

    // 일반적인 게임에서는 창의 크기를 고정으로 정하지 않는다.
    // this.setBounds(EXIT_ON_CLOSE, y, WIDTH, HEIGHT);

    Dimension d = new Dimension(wh * 20, wh * 20);
    can.setPreferredSize(d); // 표준수치로 크기 지정
    // can.setPreferredSize(new Dimension(wh * 20, wh * 20));
    can.setBackground(Color.BLACK);
    can.setFocusable(true);

    // 상자의 위치를 화면 가운데에 지정하자.
    this.x = (d.width / 2) - (this.wh / 2);
    this.y = (d.height / 2) - (this.wh / 2);

    // 현재 창의 크기는 안에 배치된 객체의 크기에 맞도록 지정한다.
    this.pack();
    // pack 기능을 쓸 경우 location 은 따로 지정해줘야 한다.
    this.setLocation(1200, 100);

    this.setVisible(true);

    // 이벤트 감지자 등록
    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    can.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        TimerEx1.this.direction = e.getKeyCode(); // 방향키를 누르면 direction 변수에 자동으로 할당된다.
        switch (direction) {
          case KeyEvent.VK_SPACE:
            if (!isRunning) { // 현재 게임이 정지일때만 수행
              TimerEx1.this.direction = ar[(int) (Math.random() * ar.length)];
              isRunning = true;
              timer.start(); // 타이머 시작과 함께 0.1초마다 ActionListener 의 ActionPerformed 를 수행
            }
            break;
        }
      }
    });
  }

  public static void main(String[] args) {
    new TimerEx1();
  }
}
