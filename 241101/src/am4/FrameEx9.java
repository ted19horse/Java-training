package am4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashSet;
import java.util.Iterator;

public class FrameEx9 extends JFrame implements ActionListener {
  /* Field */
  String[] list = new String[6];
  JPanel panelNorth, panelCenter;
  // JLabel num1, num2, num3, num4, num5, num6;
  ImageIcon icon;
  JButton btn;
  HashSet<Integer> hs = new HashSet<Integer>();
  Iterator<Integer> it;

  /* Constructer */
  public FrameEx9() {
    /* Panel */
    panelNorth = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    panelNorth.setPreferredSize(new Dimension(0, 50));
    panelNorth.add(btn = new JButton("Gen"));
    this.add(panelNorth, BorderLayout.NORTH);

    /* Center */
    panelCenter = new JPanel(new GridLayout(1, 6));
    // panelCenter.setBackground(Color.RED);
    this.add(panelCenter);

    /* Basement */
    this.setBounds(800, 100, 800, 250);
    this.setVisible(true);
    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    /* Event listener */
    btn.addActionListener(this);
  }

  /* Event handler */
  @Override
  public void actionPerformed(ActionEvent e) {
    // Generate lotto number

    // Init Set, ran, panelCenter
    hs.clear();
    int ran = (int) (Math.random() * 45 + 1);
    panelCenter.removeAll();
    // Make Set
    while (hs.size() < 6) {
      hs.add(ran);
      ran = (int) (Math.random() * 45 + 1);
    }

    it = hs.iterator();

    for (int i = 0; i < hs.size(); i++) {
      StringBuffer sb = new StringBuffer();
      sb.append("/images/");
      sb.append(it.next());
      sb.append(".gif");
      list[i] = sb.toString();

      Image img = new ImageIcon(getClass().getResource(list[i])).getImage().getScaledInstance(100, 100,
          Image.SCALE_SMOOTH);
      icon = new ImageIcon(img);
      panelCenter.add(new JLabel(icon));
    }

    panelCenter.updateUI();
  }

  public static void main(String[] args) {
    new FrameEx9();
  }

}
