package am;

import javax.swing.*;
import java.awt.*;

// ActionListener 를 MyDialogEx5 에서 처리할 경우
// public class MyDialogEx5 extends JDialog implements ActionListener {

// ActionListener 를 MyFrameEx5 에서 처리할 경우
public class MyDialogEx5 extends JDialog {
  /* Field */
  JButton btnR, btnG, btnB;
  MyFrameEx5 parentComp;

  /* Constructer */
  public MyDialogEx5(MyFrameEx5 ex5) {
    // 부모 컴포넌트의 주소 할당
    parentComp = ex5;

    // 현재 창의 레이아웃을 FlowLayout 으로 변경
    this.setLayout(new FlowLayout());

    btnR = new JButton("R");
    btnG = new JButton("G");
    btnB = new JButton("B");

    this.add(btnR);
    this.add(btnG);
    this.add(btnB);

    this.setBounds(500, 100, 250, 180);
    this.setVisible(true);

    /* Event Listener */
    // ActionListener 를 MyDialogEx5 에서 처리할 경우
    // btnR.addActionListener(this);
    // btnG.addActionListener(this);
    // btnB.addActionListener(this);

    // ActionListener 를 MyFrameEx5 에서 처리할 경우
    btnR.addActionListener(parentComp);
    btnG.addActionListener(parentComp);
    btnB.addActionListener(parentComp);

    // 부모 객체로 이벤트 리스너를 전달할 수 있다...만 각 객체별로 이벤트를 따로 처리하는게 좋을수도?
  }

  // ActionListener 를 MyDialogEx5 에서 처리할 경우
  // @Override
  // public void actionPerformed(ActionEvent e) {
  // Object obj = e.getSource();
  // Color c = null;

  // if (obj == btnR) {
  // c = Color.RED;
  // } else if (obj == btnG) {
  // c = Color.GREEN;
  // } else {
  // c = Color.BLUE;
  // }

  // parentComp.centerPanel.setBackground(c);
  // // parentComp.centerPanel.updateUI();
  // }

}
