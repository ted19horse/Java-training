package hw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrameEx4 extends JFrame implements ActionListener {
  /* Field */
  JPanel panelNorth, panelCenter;
  JButton btL, btC, btR;
  FlowLayout flow = new FlowLayout();

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btL) {
      flow.setAlignment(FlowLayout.LEFT);
    } else if (e.getSource() == btR) {
      flow.setAlignment(FlowLayout.RIGHT);
    } else {
      flow.setAlignment(FlowLayout.CENTER);
    }
    panelNorth.setLayout(flow);
    this.revalidate();
    this.repaint();
  }

  /* Constructer */
  public MyFrameEx4() {
    /* North panel */
    flow.setAlignment(FlowLayout.CENTER);
    panelNorth = new JPanel(flow);
    panelNorth.add(btL = new JButton("L"));
    panelNorth.add(btC = new JButton("C"));
    panelNorth.add(btR = new JButton("R"));
    this.add(panelNorth, BorderLayout.NORTH);

    /* Center panel */
    panelCenter = new JPanel();
    this.add(panelCenter);

    /* Set basement */
    this.setBounds(300, 50, 400, 500);
    this.setVisible(true);

    /* Event listener */
    this.addWindowListener(new MyAbsEx3());
    btL.addActionListener(this);
    btC.addActionListener(this);
    btR.addActionListener(this);
  }

  public static void main(String[] args) {
    new MyFrameEx4();
  }
}
