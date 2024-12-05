package hwSolve;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex1Gugudan extends JFrame implements ActionListener {
  /* Field */
  JTextArea ta;
  JPanel north_p;
  JButton[] bt_ar;

  /* Constructer */
  public Ex1Gugudan() {
    ta = new JTextArea();
    bt_ar = new JButton[8];
    north_p = new JPanel(new FlowLayout(FlowLayout.LEFT));

    /* North panel */
    // north_p 에 들어갈 버튼들을 생성하여 배열에 저장하고, north_p 에 추가한 후 이벤트를 적용하는 반복문을 만든다.
    for (int i = 0; i < bt_ar.length; i++) {
      // bt_ar[i] = new JButton(Integer.toString(i+2));
      bt_ar[i] = new JButton(String.valueOf(i + 2));
      north_p.add(bt_ar[i]);
      bt_ar[i].addActionListener(this);
    }
    this.add(north_p, BorderLayout.NORTH);

    /* Center panel */
    this.add(ta);
    ta.setEditable(false);

    /* Basement */
    this.setBounds(500, 150, 400, 450);
    this.setVisible(true);

    /* Event Listener */
    this.addWindowListener(new MyWin());
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // 숫자 버튼 중 하나를 누를때마다 실행
    // getActionCommand() => 버튼 안의 문자열을 빼낸다.
    int dan = Integer.parseInt(e.getActionCommand());
    ta.setText(String.format("%d단\r\n", dan));
    ta.append("---------------");
    for (int j = 1; j <= 9; j++) {
      // 포맷터를 사용한 문자열
      String str = String.format("\r\n%d*%d=%d", dan, j, (dan * j));
      ta.append(str);
    }
  }

  public static void main(String[] args) {
    new Ex1Gugudan();
  }
}
