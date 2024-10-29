package pm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameEx4 extends JFrame {
  // Field
  JButton bt;
  JPanel northP, centerP;
  JCheckBox ch1, ch2, ch3;
  GridLayout grid;
  FlowLayout flow;

  // Generator
  public FrameEx4() {
    northP = new JPanel();
    centerP = new JPanel();

    flow = new FlowLayout(FlowLayout.RIGHT); // 오른쪽 정렬 FlowLayout
    northP.setLayout(flow);

    grid = new GridLayout(3, 1);
    centerP.setLayout(grid);// 위 레이아웃을 centerP에 적용

    bt = new JButton("확인");
    northP.add(bt);

    ch1 = new JCheckBox("항목1");
    ch2 = new JCheckBox("항목2");
    ch3 = new JCheckBox("항목3");
    centerP.add(ch1);
    centerP.add(ch2);
    centerP.add(ch3);

    this.add(northP, BorderLayout.NORTH);
    /*
     * Layout 의 종류
     * 1. BorderLayout > 외곽선처럼 동서남북+가운데로 나눠진 레이아웃
     * 2. FlowLayout > 넣어진 순서대로 쌓여가는 레이아웃(패널의 기본 레이아웃)
     * 3. GridLayout > 엑셀처럼 행열로
     */
    this.add(centerP); // Center

    this.setSize(860, 680);
    this.setLocation(300, 50);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }

  public static void main(String[] args) {
    new FrameEx4();
  }
}
