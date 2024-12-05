package pm_Falling_keyword_solve;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class FrameEx1 extends JFrame {
  Thread t1;
  // 시작버튼을 클릭할 때 생성되어 단어들을 화면 위에서
  // 아래로 눈 내리듯 떨어지게 하는 스레드
  boolean chk = true;

  JPanel p, north_p;
  JButton start_bt;

  ArrayList<WordThread> list = new ArrayList<WordThread>();
  String[] txt_ar = { "통조림", "학교", "코끼리", "마우스", "키보드", "컴퓨터" };

  public FrameEx1() {
    north_p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    north_p.add(start_bt = new JButton("시작"));
    this.add(north_p, BorderLayout.NORTH);

    this.add(p = new JPanel() {
      @Override
      protected void paintComponent(Graphics g) {
        // 더블버퍼인 Image객체 준비
        Image img = createImage(this.getWidth(), this.getHeight());
        // Image에만 그림을 그리는 전용 붓!!!
        Graphics img_g = img.getGraphics();

        // 리스트 구조안에 있는 WordThread객체들을 모두 가져와서
        // 그림을 그린다.
        for (int i = 0; i < list.size(); i++) {
          WordThread tt = list.get(i);

          img_g.setColor(tt.color);
          img_g.drawString(tt.str, tt.x, tt.y);
        }

        g.drawImage(img, 0, 0, this);
      }
    });

    this.setBounds(1000, 100, 600, 500);
    this.setVisible(true);

    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    start_bt.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        t1 = new Thread() {
          @Override
          public void run() {
            // 일정한 시간이 흐를 떄마다 WordThread를 생성한다.
            while (chk) {
              WordThread wt = new WordThread(FrameEx1.this);
              list.add(wt); // 바깥쪽 클래스가 가지는 list에 저장
              wt.start(); // 스스로 떨어지도록 해당 스레드 시작!!!

              try {
                Thread.sleep(100);
              } catch (Exception e) {
              }
            }
          }
        };
        t1.start(); // 단어들을 만들어 떨어지게 하는 스레드 시작!!!
      }
    });
  }

  public static void main(String[] args) {
    new FrameEx1();
  }
}
