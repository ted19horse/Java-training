package hw;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MyFrameEx3 extends JFrame implements ActionListener {
  /* Field */
  JPanel panelNorth;
  JButton bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9;
  JTextArea ta;

  @Override
  public void actionPerformed(ActionEvent e) {
    ta.setText("");
    int n = 0;
    if (e.getSource() == bt2) {
      n = 2;
    } else if (e.getSource() == bt3) {
      n = 3;
    } else if (e.getSource() == bt4) {
      n = 4;
    } else if (e.getSource() == bt5) {
      n = 5;
    } else if (e.getSource() == bt6) {
      n = 6;
    } else if (e.getSource() == bt7) {
      n = 7;
    } else if (e.getSource() == bt8) {
      n = 8;
    } else {
      n = 9;
    }
    ta.append(n + "단\r\n");
    ta.append("----------\r\n");
    for (int i = 1; i < 10; i++) {
      ta.append(n + " * " + i + " = " + (n * i) + "\r\n");
    }
  }

  /* Constructer */
  public MyFrameEx3() {
    /* North panel */
    panelNorth = new JPanel(new FlowLayout(FlowLayout.LEFT));
    panelNorth.add(bt2 = new JButton("2"));
    panelNorth.add(bt3 = new JButton("3"));
    panelNorth.add(bt4 = new JButton("4"));
    panelNorth.add(bt5 = new JButton("5"));
    panelNorth.add(bt6 = new JButton("6"));
    panelNorth.add(bt7 = new JButton("7"));
    panelNorth.add(bt8 = new JButton("8"));
    panelNorth.add(bt9 = new JButton("9"));
    this.add(panelNorth, BorderLayout.NORTH);

    /* Center panel */
    this.add(ta = new JTextArea());
    ta.setEditable(false);

    /* Set default */
    this.setBounds(300, 50, 400, 450);
    this.setVisible(true);

    /* Event listener */
    this.addWindowListener(new MyAbsEx3());
    bt2.addActionListener(this);
    bt3.addActionListener(this);
    bt4.addActionListener(this);
    bt5.addActionListener(this);
    bt6.addActionListener(this);
    bt7.addActionListener(this);
    bt8.addActionListener(this);
    bt9.addActionListener(this);
  }

  public static void main(String[] args) {
    new MyFrameEx3();
  }
}
