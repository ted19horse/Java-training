package pm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FrameEx5 extends JFrame {
  // Field
  JTextArea textArea;
  JPanel panelW, panelS;
  JLabel labelNum, labelNme, labelDep, labelPos, labelEml;
  JTextField fieldNum, fieldNme, fieldDep, fieldPos, fieldEml;
  JButton btnAll, btnAdd, btnSch, btnDel, btnCel;
  GridBagConstraints gbc;
  GridLayout grid;
  FlowLayout flow;

  // Generator
  public FrameEx5() {
    setTitle("사원관리");

    // Set Textarea on Center
    textArea = new JTextArea(5, 2);

    // Set West panel, Grid > Add Label & Textfield
    panelW = new JPanel(new GridBagLayout());
    gbc = new GridBagConstraints();
    // panelW.setPreferredSize(new Dimension(300, 400));
    panelW.setBorder(BorderFactory.createEmptyBorder(100, 25, 100, 25));
    // grid = new GridLayout(5, 2);
    // panelW.setLayout(grid);

    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridy = 0;
    gbc.gridx = 0;
    gbc.weightx = 0.3;
    panelW.add(labelNum = new JLabel("사번"), gbc);
    gbc.gridx = 1;
    gbc.weightx = 0.7;
    panelW.add(fieldNum = new JTextField(20), gbc);

    gbc.gridy = 1;
    gbc.gridx = 0;
    gbc.weightx = 0.3;
    panelW.add(labelNme = new JLabel("이름"), gbc);
    gbc.gridx = 1;
    gbc.weightx = 0.7;
    panelW.add(fieldNme = new JTextField(20), gbc);

    gbc.gridy = 2;
    gbc.gridx = 0;
    gbc.weightx = 0.3;
    panelW.add(labelDep = new JLabel("부서"), gbc);
    gbc.gridx = 1;
    gbc.weightx = 0.7;
    panelW.add(fieldDep = new JTextField(20), gbc);

    gbc.gridy = 3;
    gbc.gridx = 0;
    gbc.weightx = 0.3;
    panelW.add(labelPos = new JLabel("직책"), gbc);
    gbc.gridx = 1;
    gbc.weightx = 0.7;
    panelW.add(fieldPos = new JTextField(20), gbc);

    gbc.gridy = 4;
    gbc.gridx = 0;
    gbc.weightx = 0.3;
    panelW.add(labelEml = new JLabel("이메일"), gbc);
    gbc.gridx = 1;
    gbc.weightx = 0.7;
    panelW.add(fieldEml = new JTextField(20), gbc);

    // Set South panel, Grid > Add box
    panelS = new JPanel();
    panelS.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 10));

    flow = new FlowLayout(FlowLayout.RIGHT);
    panelS.setLayout(flow);

    panelS.add(btnAll = new JButton("전체"));
    panelS.add(btnAdd = new JButton("추가"));
    panelS.add(btnSch = new JButton("검색"));
    panelS.add(btnDel = new JButton("삭제"));
    panelS.add(btnCel = new JButton("취소"));

    // add on window
    this.add(textArea);
    this.add(panelW, BorderLayout.WEST);
    this.add(panelS, BorderLayout.SOUTH);

    // Base Setting
    this.setSize(860, 680);
    this.setLocation(300, 50);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기 버튼 눌렀을 때로 수정해보자
    this.setVisible(true);
  }

  public static void main(String[] args) {
    new FrameEx5();
  }
}
