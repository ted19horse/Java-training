package hwSolve;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex2Move extends JFrame implements ActionListener {
  /* Field */
  JPanel north_p;
  JButton left_bt, center_bt, right_bt;

  /* Constructer */
  public Ex2Move() {
    north_p = new JPanel();
    left_bt = new JButton("L");
    center_bt = new JButton("C");
    right_bt = new JButton("R");

    north_p.add(left_bt);
    north_p.add(center_bt);
    north_p.add(right_bt);

    this.add(north_p, BorderLayout.NORTH);

    /* Basement */
    this.setBounds(500, 100, 500, 450);
    this.setVisible(true);

    /* Event Listener */
    this.addWindowListener(new MyWin());
    left_bt.addActionListener(this);
    center_bt.addActionListener(this);
    right_bt.addActionListener(this);
  }

  /* Button event */
  @Override
  public void actionPerformed(ActionEvent e) {
    // 클릭한 버튼이 뭔지 가려내야 함
    Object obj = e.getSource();
    int align = -1;
    if (obj == left_bt) { // 사용자가 왼쪽 버튼을 클릭한 경우
      align = FlowLayout.LEFT;
    } else if (obj == center_bt) { // 사용자가 가운데 버튼을 클릭한 경우
      align = FlowLayout.CENTER;
    } else { // 사용자가 오른쪽 버튼을 클릭한 경우
      align = FlowLayout.RIGHT;
    }
    north_p.setLayout(new FlowLayout(align));
    north_p.updateUI();
  }

  public static void main(String[] args) {
    new Ex2Move();
  }
}
