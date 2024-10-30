package am;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyChatFrame extends JFrame implements WindowListener, MouseListener {
  // 멤버변수 선언
  JTextArea ta;
  JTextField tf;
  JButton send_bt;
  JPanel south_p;

  // WindowListener

  @Override
  public void windowActivated(WindowEvent e) { // 창 활성화

  }

  @Override
  public void windowClosed(WindowEvent e) { // 창 닫혔음

  }

  @Override
  public void windowClosing(WindowEvent e) { // 창 닫히기 전
    // 프로그램 즉시 종료
    System.exit(0);
  }

  @Override
  public void windowDeactivated(WindowEvent e) { // 창 비활성화

  }

  @Override
  public void windowDeiconified(WindowEvent e) { // 창 아이콘화(최소화) 해제

  }

  @Override
  public void windowIconified(WindowEvent e) { // 창 아이콘화(최소화) 실행

  }

  @Override
  public void windowOpened(WindowEvent e) { // 창 생성

  }

  // MouseListener

  @Override
  public void mouseClicked(MouseEvent e) {

  }

  @Override
  public void mouseEntered(MouseEvent e) {

  }

  @Override
  public void mouseExited(MouseEvent e) {

  }

  @Override
  public void mousePressed(MouseEvent e) {
    // send_bt 가 눌려질 때 마다 현재 영역 수행!
    if (e.getSource() == send_bt) {
      // tf 로부터 문자열 가져오기
      String str = tf.getText();
      ta.append(str);
      ta.append("\r\n");
      tf.setText("");
    }
  }

  @Override
  public void mouseReleased(MouseEvent e) {

  }

  public MyChatFrame() {
    /*
     * 현재 객체는 JFrame 으로부터 상속받았으므로
     * 현재 창의 레이아웃은 BorderLayout 이다.
     */
    JScrollPane scroll = new JScrollPane(ta = new JTextArea());
    this.add(scroll); // 현재 창 가운데에 JTextArea를 가진 JScrollPane 이 추가됐다.

    // JTextArea 비활성화
    ta.setEditable(false);

    /*
     * JPanel 의 기본레이아웃은 FlowLayout 이다.
     * 이것을 BorderLayout 으로 변경하자.
     */
    south_p = new JPanel(new BorderLayout());

    // south_p 내부의 객체 생성
    tf = new JTextField();
    send_bt = new JButton("보내기");
    south_p.add(tf); // south_p 의 가운데에 추가
    south_p.add(send_bt, BorderLayout.EAST); // south_p 의 EAST 방향에 추가

    // 현재 창 SOUTH 영역에 south_p 추가
    this.add(south_p, BorderLayout.SOUTH);

    this.setBounds(300, 100, 400, 700);
    this.setVisible(true);

    // 이벤트 감지자 등록
    this.addWindowListener(this);
    send_bt.addMouseListener(this);
  }

  public static void main(String[] args) {
    new MyChatFrame();
  }
}
