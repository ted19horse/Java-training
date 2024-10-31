package am2;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import am.MyWin;

public class CardEx2 extends JFrame implements ActionListener {
  // 카드 레이아웃은 한 화면을 하나의 카드로 인지하고
  // 그 카드는 JPanel 로 만든다.

  /* Field */
  JPanel p1, p2;
  JButton p1Btn, p2Btn;
  CardLayout cardL;

  /* Constructer */
  public CardEx2() {
    p1 = new JPanel();
    p1Btn = new JButton("다음");
    p1.add(p1Btn);
    p1.setBackground(Color.CYAN);

    p2 = new JPanel();
    p2Btn = new JButton("이전");
    p2.add(p2Btn);
    p2.setBackground(Color.ORANGE);

    // 현재 창의 레이아웃을 CardLayout 으로 지정
    cardL = new CardLayout();
    this.setLayout(cardL);

    // 카드 화면들을 현재 창의 Container 에 추가한다.
    this.getContentPane().add(p1, "card1");
    this.getContentPane().add(p2, "card2");

    // 이 문장이 카드를 변경하는 문장
    // cardL.show(this.getContentPane(), "card2");

    this.setBounds(500, 100, 500, 500);
    this.setVisible(true);
    this.addWindowListener(new MyWin());

    p1Btn.addActionListener(this);
    p2Btn.addActionListener(this);
  }

  /* Event Handler */
  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();
    String cardName = null;
    if (obj == p1Btn) {
      cardName = "card2";
    } else {
      cardName = "card1";
    }
    cardL.show(this.getContentPane(), cardName);
  }

  public static void main(String[] args) {
    new CardEx2();
  }
}
