package pm3_Game_fuck;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.util.ArrayList;

public class Fuck extends JFrame {
  // 첫번째 작업 내용 ----------------------------------------
  // 크기 객체 선언
  Dimension d = new Dimension(390, 590);

  // 필요한 각 이미지들 선언
  Image back_img, me_img, meteor_img, bullet_img;
  Me2 me = new Me2();

  // 두번째 작업 내용 ----------------------------------------
  ArrayList<MeteorEx2> m_list = new ArrayList<MeteorEx2>();

  // 운석을 주기적으로 생성해 m_list에 저장하는 스레드
  Thread makeMeteor = new Thread() {
    @Override
    public void run() {
      // 1초 간격으로 운석객체를 생성하여 m_list에 추가한다.
      // 반드시 p의 paintComponent에서 그림으로 그려야 한다.
      // 생성된 운석객체의 스레드를 구동시킨다.
      while (true) {
        // 운석객체 생성
        MeteorEx2 m = new MeteorEx2(Fuck.this, 35, 30);

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

  // 세번째 작업 내용----------------------------------------
  // 폭발객체(Explotion)가 저장될 곳
  ArrayList<Explotion> ex_list = new ArrayList<>();

  // 폭발이미지들
  Image[] exp_ar = new Image[27];

  // 네번째 작업 내용----------------------------------------
  // 총알객체(Explotion)가 저장될 곳
  ArrayList<Bullet> b_list = new ArrayList<Bullet>();

  // 다섯번째 작업 내용----------------------------------------
  JPanel panelScoreBoard;
  JTextField textFieldScore;

  // 첫번째 작업 내용----------------------------------------
  JPanel p = new JPanel() {
    @Override
    protected void paintComponent(Graphics g) {
      // 배경 그리기
      g.drawImage(back_img, 0, 0, this);

      // 주인공 그리기
      g.drawImage(me_img, me.rect.x, me.rect.y, this);

      // 두번째 작업 내용 ----------------------------------------
      // 운석 그리기
      // 운석들은 모두 ArrayList에 있다.

      // for (MeteorEx2 m : m_list) {
      // // 운석을 하나씩 그린다.
      // g.drawImage(meteor_img, m.rect.x, m.rect.y, this);
      // }

      /* 아래 부분은 java.util.ConcurrentModificationException 이 발생한다 */
      /* 같은 list 를 여러 쓰레드가 동시에 사용해서 그런듯 */
      // Iterator<MeteorEx2> it = m_list.iterator();
      // while (it.hasNext()) {
      // MeteorEx2 m = it.next();
      // g.drawImage(meteor_img, m.rect.x, m.rect.y, this);
      // }

      /* m_list 복사본을 만드는 방식 */
      ArrayList<MeteorEx2> copy_list = new ArrayList<>(m_list);
      for (MeteorEx2 m : copy_list) {
        g.drawImage(meteor_img, m.rect.x, m.rect.y, this);
      }

      // 네번째 작업 내용----------------------------------------
      ArrayList<Bullet> copy_list_b = new ArrayList<>(b_list);
      for (Bullet b : copy_list_b) {
        g.drawImage(bullet_img, b.rect.x, b.rect.y, this);
      }

      // 세번째 작업 내용----------------------------------------
      // 폭발객체는 모두 ex_list에 저장되어 있다. 이거 하나당 27개의 이미지를 표현!
      // exp_list 는 ex_list의 카피 배열이다.
      ArrayList<Explotion> exp_list = new ArrayList<>(ex_list);
      for (Explotion exp : exp_list) {
        // 폭발객체 안에 있는 index를 이용하여
        // exp_ar이라는 배열의 index로 삼고 그릴 폭발이미지를 하나 가져온다.
        Image img = exp_ar[exp.index];
        g.drawImage(img, exp.pt.x, exp.pt.y, this);

        // 폭발객체 안에 있는 move_index() 함수를 5번 호출할 때마다 index값이 1씩 증가한다.
        // >> (메테오 혹은 주인공이 움직이면 repaint()가 자동으로 paint()를 호출하므로,
        // >> move_index()도 매번 같이 호출된다. 쓰레드가 여러개 만들어지므로
        // >> 사실상 while처럼 자동으로 갱신되는 셈.)
        // 그리고 index값이 27이 됐을 때 move_index함수는 true를 반환하여
        // 폭발이 끝났음을 알려준다.
        if (exp.move_index()) {
          ex_list.remove(exp); // 폭발이 끝난 객체는 삭제!!!
        }
      }
    }
  };

  public Fuck() {
    // 첫번째 작업 내용 ----------------------------------------
    // 이미지들 초기화
    back_img = new ImageIcon(getClass().getResource("/images/back.jpg")).getImage();
    me_img = new ImageIcon(getClass().getResource("/images/me.png")).getImage();
    meteor_img = new ImageIcon(getClass().getResource("/images/meteor.png")).getImage();
    bullet_img = new ImageIcon(getClass().getResource("/images/b.png")).getImage();

    // 세번째 작업 내용----------------------------------------
    // 폭발이미지 27개 생성
    for (int i = 0; i < exp_ar.length; i++) {
      String img_path = String.format("/images/exp_enemy_1/exp_%d.png", i + 1);
      URL imgUrl = getClass().getResource(img_path);

      // 위의 경로를 가지고 이미지 로드
      Image exp = new ImageIcon(imgUrl).getImage();

      // 로드된 이미지 객체를 배열에 저장
      exp_ar[i] = exp;
    }

    // 첫번째 작업 내용 ----------------------------------------
    init_game(); // 게임 초기화
    init_me_pos(); // 케릭터 초기화

    // 다섯번째 작업 내용 ----------------------------------------
    p.setLayout(new BorderLayout());

    panelScoreBoard = new JPanel(new FlowLayout());
    panelScoreBoard.setOpaque(false);
    textFieldScore = new JTextField(8);
    panelScoreBoard.add(textFieldScore, new FlowLayout(FlowLayout.RIGHT));
    p.add(panelScoreBoard, BorderLayout.NORTH);

    p.setFocusable(true);
    this.setLocation(1000, 100);
    this.pack(); // 컴포넌트들의 크기에 맞게 사이즈 설정!
    this.setResizable(false); // 창 사이즈 조정 불가
    this.setVisible(true);

    // 세번째 작업 내용----------------------------------------
    makeMeteor.start(); // 운석들을 생성하는 스레드 시작

    // 첫번째 작업 내용 ----------------------------------------
    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    // 첫번째 작업 내용 ----------------------------------------
    p.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
          case KeyEvent.VK_LEFT:
            me.rect.x -= 5;
            if (me.rect.x < 0) {
              me.rect.x = 0;
            }
            break;
          case KeyEvent.VK_RIGHT:
            me.rect.x += 5;
            if (me.rect.x > d.width - me.rect.width) {
              me.rect.x = d.width - me.rect.width;
            }
            break;
          case KeyEvent.VK_SPACE:
            // 총알 객체를 생성해서 발사함 (스레드를 상속받은 Rectangle)
            // JFrame에서 총알 ArrayList를 만들어놓고 paintConponent에서 그림
            // 메테오 안에서 이벤트로 총알과 겹치는지 체크
            // 메테오와 겹치면 폭발

            // 총알객체 생성
            Bullet b = new Bullet(Fuck.this);

            // 총알의 위치
            int x = (int) (me.rect.getCenterX() - 5);
            int y = (int) me.rect.getMinY();

            b.rect.x = x;
            b.rect.y = y;

            // 생성된 총알객체를 ArrayList에 저장
            b_list.add(b);
            b.start();
            break;
        }
        p.repaint();
      }
    });
  }

  // 첫번째 작업 내용 ----------------------------------------
  public void init_game() {
    // 크기객체(Dimension)을 가지고 JPanel의 크기로 예약하자.
    p.setPreferredSize(d);

    // 크기가 지정된 JPanel을 현재 창 가운데에 추가!
    this.add(p);
  }

  // 첫번째 작업 내용 ----------------------------------------
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
    new Fuck();
  }
}
