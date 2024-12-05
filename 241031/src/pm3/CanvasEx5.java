package pm3;

import am.MyWin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CanvasEx5 extends JFrame implements ActionListener {
  /* Field */
  JPanel p, p1, p2;
  JButton[] btnArr = new JButton[6];
  Color[] colors = new Color[] { Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.CYAN, Color.BLACK };
  JComboBox<Integer> cBox;
  MyCanvasEx5 can;
  Integer bs = 20;

  /* Constructer */
  public CanvasEx5() {
    /* Side panel */
    // p = new JPanel(new GridLayout(4, 1));
    p = new JPanel();
    /*
     * 배경 패널에 Grid 를 적용하면 내부 패널에 영향을 받는다.
     * p1 패널의 버튼 사이즈가 for 에서 30*30 으로 고정되었지만
     * p1 이 p 에 로딩되면서 Grid 에 영향을 받는듯 하다.
     */
    p.setPreferredSize(new Dimension(70, 0));

    /* Color panel */
    p1 = new JPanel(new GridLayout(3, 2));

    for (int i = 0; i < btnArr.length; i++) {
      btnArr[i] = new JButton();
      btnArr[i].setPreferredSize(new Dimension(30, 30));
      btnArr[i].setBackground(colors[i]);
      btnArr[i].addActionListener(this);
      p1.add(btnArr[i]);
    }

    p.add(p1);

    /* Brush size panel */
    p2 = new JPanel();

    cBox = new JComboBox<Integer>();
    cBox.setPreferredSize(new Dimension(60, 20));
    cBox.addItem(10);
    cBox.addItem(20);
    cBox.addItem(30);

    p2.add(cBox);

    p.add(p2);

    this.add(p, BorderLayout.WEST);

    /* Canvas */
    this.add(can = new MyCanvasEx5(this));

    /* Basement */
    this.setBounds(500, 100, 500, 500);
    this.setVisible(true);
    this.addWindowListener(new MyWin());

    /* Event Listener */
    cBox.addActionListener(this);
  }

  /*
   * 패널의 크기를 너비는 70, 높이는 창의 높이를 고정하려 한다면
   * Dimension(70,0)을 생성하여 해당 패널에게 PreferredSize 로 지정하면 된다.
   * Dimension 은 너비와 높이를 가지고 객체화 시킨 것이다.
   * setPreferredSize(new dimension())
   */

  /* Event handler */
  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();
    if (obj == cBox) {
      can.setBrush((Integer) cBox.getSelectedItem());
    } else {
      for (int i = 0; i < btnArr.length; i++) {
        if (obj == btnArr[i]) {
          can.setColor(btnArr[i].getBackground());
        }
      }
    }
  }

  public static void main(String[] args) {
    new CanvasEx5();
  }

}
