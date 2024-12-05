package am;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrameEx5 extends JFrame implements ActionListener {
  /* Field */
  JPanel northPanel, centerPanel;
  private JButton btn;
  private MyDialogEx5 md;

  /* Constructer */
  public MyFrameEx5() {
    /* North panel */
    northPanel = new JPanel();
    btn = new JButton("대화상자");
    northPanel.add(btn);
    this.add(northPanel, BorderLayout.NORTH);

    /* Center panel */
    centerPanel = new JPanel();
    this.add(centerPanel);

    /* Basement */
    this.setBounds(300, 100, 300, 500);
    this.setVisible(true);

    /* Event listener */
    this.addWindowListener(new MyWin());
    btn.addActionListener(this);
  }

  /* Event handler */
  @Override
  public void actionPerformed(ActionEvent e) {
    // md = new MyDialogEx5(this);

    Object obj = e.getSource();

    if (obj == btn) {
      md = new MyDialogEx5(this);
    } else {
      Color c = null;

      if (obj == md.btnR) {
        c = Color.RED;
        System.out.println("R");
      } else if (obj == md.btnG) {
        c = Color.GREEN;
        System.out.println("G");
      } else {
        c = Color.BLUE;
        System.out.println("B");
      }

      centerPanel.setBackground(c);
    }
  }

  public static void main(String[] args) {
    new MyFrameEx5();
  }
}
