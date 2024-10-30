package hw;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyEmpFrame extends JFrame implements MouseListener {
  // 화면에서 표현되는 모든 객체들을 멤버변수로 선언
  JButton bt1, bt2, bt3, bt4, bt5;
  JTextField tf1, tf2, tf3, tf4, tf5;
  JLabel lb1, lb2, lb3, lb4, lb5;
  JTextArea ta;
  JPanel center_p, south_p, west_p, w_p1, w_p2, w_p3, w_p4, w_p5;

  @Override
  public void mouseClicked(MouseEvent e) {
    // 이벤트 발생 객체를 얻어낸다.
    // Object obj = e.getSource();
    // 프로그램 종료
    if (e.getSource() == bt5) {
      System.exit(0);
    }
  }

  @Override
  public void mouseEntered(MouseEvent e) {

  }

  @Override
  public void mouseExited(MouseEvent e) {

  }

  @Override
  public void mousePressed(MouseEvent e) {
    // Object obj = e.getSource();
    if (e.getSource() == bt4) {
      this.setTitle("눌렀네");
    }
  }

  @Override
  public void mouseReleased(MouseEvent e) {

  }

  public MyEmpFrame() {

    // ---------- 아래쪽 UI ----------

    // 패널 오른쪽 정렬
    FlowLayout flow = new FlowLayout(FlowLayout.RIGHT);
    south_p = new JPanel(flow);

    // 아래쪽 5개 버튼을 패널에 추가
    south_p.add(bt1 = new JButton("전체"));
    south_p.add(bt2 = new JButton("추가"));
    south_p.add(bt3 = new JButton("삭제"));
    south_p.add(bt4 = new JButton("검색"));
    south_p.add(bt5 = new JButton("닫기"));

    // 패널을 현재창 아래쪽에 배치
    south_p.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 5));
    this.add(south_p, BorderLayout.SOUTH);

    // ---------- 왼쪽 UI ----------
    west_p = new JPanel(new GridLayout(8, 1));
    west_p.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));

    w_p1 = new JPanel(flow);
    w_p1.add(lb1 = new JLabel("사번"));
    w_p1.add(tf1 = new JTextField(7));

    w_p2 = new JPanel(flow);
    w_p2.add(lb2 = new JLabel("이름"));
    w_p2.add(tf2 = new JTextField(7));

    w_p3 = new JPanel(flow);
    w_p3.add(lb3 = new JLabel("부서"));
    w_p3.add(tf3 = new JTextField(7));

    w_p4 = new JPanel(flow);
    w_p4.add(lb4 = new JLabel("직책"));
    w_p4.add(tf4 = new JTextField(7));

    w_p5 = new JPanel(flow);
    w_p5.add(lb5 = new JLabel("이메일"));
    w_p5.add(tf5 = new JTextField(7));

    west_p.add(new JPanel());
    west_p.add(w_p1);
    west_p.add(w_p2);
    west_p.add(w_p3);
    west_p.add(w_p4);
    west_p.add(w_p5);

    this.add(west_p, BorderLayout.WEST);

    // ---------- 가운데 UI ----------
    // this.add(ta = new JTextArea());
    // 스크롤 바는 JScrollPane 을 사용
    this.add(new JScrollPane(ta = new JTextArea()));
    ta.setEditable(false); // 수정불가, disabled

    // ---------- 기본 UI ----------
    // this.setSize(500, 400);
    // this.setLocation(300, 50);
    // setSize + setLocation = setBounds
    this.setBounds(300, 300, 500, 300);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x 버튼 클릭시 종료
    this.setVisible(true);

    // ---------- 이벤트 감지자 등록 ----------
    bt5.addMouseListener(this);
    /*
     * bt5 에게 마우스이벤트 감지자를 등록한다.
     * 감지자는 현재객체(this) 이며, bt5를 클릭하는 이벤트가 발생하면
     * 현재 객체(this)에서 클릭이벤트에 해당하는 함수 mouseClicked를 자동 호출한다.
     */

    /* bt4를 마우스로 누를 때 그것을 감지하고 창의 제목을 "눌럿네"로 변경하자! */
    bt4.addMouseListener(this);
  }

  public static void main(String[] args) {
    new MyEmpFrame();
  }

}
