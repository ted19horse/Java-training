package pm2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

// public class MyFrameEx2 extends JFrame implements WindowListener, ActionListener {
public class MyFrameEx2 extends JFrame implements ActionListener {
  /* Field */
  JPanel center_p, north_p;
  JButton red_bt, green_bt, blue_bt;

  /* MouseListener */
  @Override
  public void actionPerformed(ActionEvent e) {
    // 각 버튼을 클릭할 때 마다 현재 영역을 수행한다.
    // 그러므로 현재 위치에서 어떤 버튼을 클릭했는지 가려내야 한다.
    if (e.getSource() == red_bt) {
      center_p.setBackground(Color.RED);
    } else if (e.getSource() == blue_bt) {
      center_p.setBackground(Color.BLUE);
      // EventListener 를 3개 버튼에만 등록했기 때문에 그 외에 다른 Object 는 e.getSource() 에 들어올 수 없다.
      // } else if (e.getSource() == green_bt) {
    } else {
      center_p.setBackground(Color.GREEN);
    }
  }

  /* Constructor */
  public MyFrameEx2() {
    /* North panel */
    north_p = new JPanel();
    north_p.add(red_bt = new JButton("빨강"));
    north_p.add(blue_bt = new JButton("파랑"));
    north_p.add(green_bt = new JButton("초록"));
    this.add(north_p, BorderLayout.NORTH);

    /* Center panel */
    this.add(center_p = new JPanel());
    this.setBounds(300, 50, 400, 500);
    this.setVisible(true);

    /* Event listener */
    // this.addWindowListener(this); // 종료 이벤트, 기존 인터페이스 구현 방식

    /* WindowAdapter 를 상속받은 클래스 생성, 혹은 재사용하지 않을거면 바로 사용 가능 */
    // MyAbsEx2 abs = new MyAbsEx2();
    this.addWindowListener(new MyAbsEx2()); // 종료 이벤트, 추상클래스 상속 방식
    red_bt.addActionListener(this);
    blue_bt.addActionListener(this);
    green_bt.addActionListener(this);
    ; // 버튼 클릭시 center_p 배경색 변경 이벤트 적용
  }

  public static void main(String[] args) {
    new MyFrameEx2();
  }
}
