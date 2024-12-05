package pm;

import am.MyWin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardEx1 extends JFrame implements ActionListener {
  JPanel card1, card2;
  // ----- card1 에 들어갈 객체들 -----
  JPanel p1, p1_1, p1_2, p1_3;
  JTextField id_tf;
  JPasswordField pw_tf;
  JButton login_bt;
  ImageIcon chat_icon;

  // ----- card2 에 들어갈 객체들 -----
  JPanel p2, p3;
  JTextArea ta;
  JTextField input_tf;
  JButton pre_bt, send_bt;

  CardLayout cl;

  public CardEx1() {
    // 현재 창의 레이아웃을 CardLayout 으로 지정
    this.setLayout(cl = new CardLayout());

    // 첫번째 카드 화면 구성
    card1 = new JPanel(new BorderLayout());
    p1 = new JPanel(new GridLayout(3, 1)); // 3행 1열짜리 GridLayout
    p1_1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    p1_1.add(new JLabel("ID: "));
    p1_1.add(id_tf = new JTextField(7)); // ID입력란
    p1.add(p1_1);
    p1_2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    p1_2.add(new JLabel("PW: "));
    p1_2.add(pw_tf = new JPasswordField(7)); // PW입력란
    p1.add(p1_2);
    p1_3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    p1_3.add(login_bt = new JButton("  Login  "));
    p1.add(p1_3);
    card1.add(p1, BorderLayout.SOUTH);
    Image img = new ImageIcon(getClass().getResource("/images/chat.png")).getImage().getScaledInstance(100, 100,
        Image.SCALE_SMOOTH);
    chat_icon = new ImageIcon(img);
    card1.add(new JLabel(chat_icon));
    this.getContentPane().add(card1, "card1");

    // 두번째 카드 화면 구성
    card2 = new JPanel(new BorderLayout());
    p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    p2.add(pre_bt = new JButton("Get out"));
    card2.add(p2, BorderLayout.NORTH);
    card2.add(new JScrollPane(ta = new JTextArea()));
    p3 = new JPanel(new BorderLayout());
    p3.add(input_tf = new JTextField()); // p3 의 가운데에 입력란 추가
    p3.add(send_bt = new JButton("Send msg"), BorderLayout.EAST);
    card2.add(p3, BorderLayout.SOUTH);
    this.getContentPane().add(card2, "card2");

    this.setBounds(700, 100, 300, 500);
    setVisible(true);

    this.addWindowListener(new MyWin());
    login_bt.addActionListener(this);
    pre_bt.addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();
    String cardName = null;
    if (obj == login_bt) {
      // 사용자가 입력한 id 와 pw 를 가져온다.
      String m_id = id_tf.getText().trim();
      String m_pw = String.valueOf(pw_tf.getPassword()).trim();
      if (m_id.length() > 0 && m_pw.length() > 0) {
        cardName = "card2";
      }
    } else {
      cardName = "card1";
    }
    cl.show(this.getContentPane(), cardName);
  }

  public static void main(String[] args) {
    new CardEx1();
  }
}
