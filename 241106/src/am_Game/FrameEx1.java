package am_Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class FrameEx1 extends JFrame {
  // 크기 객체 선언
  Dimension d = new Dimension(390, 590);

  // 필요한 각 이미지들 선언
  Image back_img, me_img, meteor_img;
  Me me = new Me();

  // 두번째 작업 내용 ---------------------------------
  ArrayList<MeteorEx1> m_list = new ArrayList<MeteorEx1>();

  // 운석을 주기적으로 생성해 m_list에 저장하는 스레드
  Thread makeMeteor = new Thread() {
    @Override
    public void run() {
      // 1초 간격으로 운석객체를 생성하여 m_list에 추가한다.
      // 반드시 p의 paintComponent에서 그림으로 그려야 한다.
      // 생성된 운석객체의 스레드를 구동시킨다.
      while (true) {
        // 운석객체 생성
        MeteorEx1 m = new MeteorEx1(FrameEx1.this, 35, 30);

        // 운석의 위치
        int x = (int) (Math.random() * p.getSize().width - 35);

        m.rect.x = x;
        m.rect.y = -30;

        // 생성된 운석객체를 ArrayList에 저장
        m_list.add(m);
        m.start();

        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  };

  JPanel p = new JPanel() {
    @Override
    public void paintComponents(Graphics g) {
      // 배경 그리기
      g.drawImage(back_img, 0, 0, this);

      // 주인공 그리기
      g.drawImage(me_img, me.rect.x, me.rect.y, this);

      // 운석 그리기
      // 운석들은 모두 ArrayList에 있다.

      // for (MeteorEx1 m : m_list) {
      // // 운석을 하나씩 그린다.
      // g.drawImage(meteor_img, m.rect.x, m.rect.y, this);
      // }

      Iterator<MeteorEx1> it = m_list.iterator();
      while (it.hasNext()) {
        MeteorEx1 m = it.next();
        g.drawImage(meteor_img, m.rect.x, m.rect.y, this);
      }
    }
  };

  public FrameEx1() {
    // 이미지들 초기화
    back_img = new ImageIcon(getClass().getResource("/images/back.jpg")).getImage();
    me_img = new ImageIcon(getClass().getResource("/images/me.png")).getImage();
    meteor_img = new ImageIcon(getClass().getResource("/images/meteor.png")).getImage();

    init_game(); // 게임 초기화
    init_me_pos(); // 케릭터 초기화

    this.setLocation(300, 50);
    this.pack(); // 컴포넌트들의 크기에 맞게 사이즈 설정!
    // 이 경우는 JPanel을 넣었으니 JPanel의 사이즈에 맞춤
    this.setResizable(false); // 창 사이즈 조정 불가
    this.setVisible(true);

    makeMeteor.start(); // 운석들을 생성하는 스레드 시작

    /* 이벤트 감지자 등록 */
    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }

  private void init_game() {
    // 크기객체(Dimension)을 가지고 JPanel의 크기로 예약하자.
    p.setPreferredSize(d);

    // 크기가 지정된 JPanel을 현재 창 가운데에 추가!
    this.add(p);
  }

  private void init_me_pos() {
    // 주인공의 초기 위치를 지정하는 함수
    // 주인공 이미지의 너비
    int imgWidth = me_img.getWidth(p);
    int imgHeight = me_img.getHeight(p);

    // Me 객체 안에 Rectangle의 x, y, width, height 를 지정하자
    me.rect.x = (d.width - imgWidth) / 2;
    me.rect.y = d.height - imgHeight - 5;

    me.rect.width = imgWidth;
    me.rect.height = imgHeight;
  }

  public static void main(String[] args) {
    new FrameEx1();
  }
}
