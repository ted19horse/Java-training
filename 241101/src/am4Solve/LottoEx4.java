package am4Solve;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LottoEx4 extends JFrame implements ActionListener {
  JPanel north_p, center_p;
  JButton bt;
  int[] ar;

  public LottoEx4() {
    ar = new int[6];

    // 화면구성
    north_p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    // bt = new JButton("생성");
    // north_p.add(bt);
    north_p.add(bt = new JButton("생성"));

    // 현재 창 NORTH 영역에 north_p 를 추가
    this.add(north_p, BorderLayout.NORTH);

    // 현재 창 가운데 영역에 center_p를 생성한 후 추가
    this.add(center_p = new JPanel());

    this.setBounds(500, 100, 800, 250);
    this.setVisible(true);
    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    bt.addActionListener(this); // 생성버튼을 클릭할 때마다 현재 객체에서 actionPerformed 를 호출
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // 생성버튼을 클릭할 때마다 수행하는 곳
    setArray(); // 난수를 저장한다. 중복 체크도 수행.
    setLabel(); // 만들어진 난수 배열로 이미지 아이콘 생성 후 JLable 생성하여 center_p 에 추가한다.
  }

  private void setLabel() {
    // center_p 에 JLabel 을 그리기 전에 이미 center_p 에 있는 내용들을 모두 지워야 한다.
    center_p.removeAll();

    for (int i = 0; i < ar.length; i++) {
      // String path = "src/images/"+ar[i]+".gif";
      StringBuffer sb = new StringBuffer("/images/");
      sb.append(ar[i]);
      sb.append(".gif");

      // 위 경로를 가지고 ImageIcon 을 생성하자!
      // ImageIcon icon = new ImageIcon(sb.toString()); // 이클립스에서 사용하는 방법
      ImageIcon icon = new ImageIcon(getClass().getResource(sb.toString())); // vscode에서 사용하는 방법

      // 위 ImageIcon 을 가지고 JLabel 을 생성하자
      JLabel lv = new JLabel(icon);

      // 위 JLabel 을 center_p 에 추가
      center_p.add(lv);
    }
    center_p.revalidate();
  }

  private void setArray() {
    // 배열은 생성자에서 이미 생성되어 있으므로 생성할 필요는 없다.
    for (int i = 0; i < ar.length;) {
      // 1~45 중 난수 발생
      // int r = (int)(Math.random()*45+1);
      // ar[i] = r;
      ar[i] = (int) (Math.random() * 45 + 1);

      // 위의 값이 중복된 값인지? 아닌지? 를 판단하기 위해 논리형 변수가 하나 필요하다.
      boolean chk = true; // true 값을 유지하면 중복되지 않은 값으로 간주한다.
      for (int j = 0; j < i; j++) {
        if (ar[i] == ar[j]) {
          chk = false;
          break;
        }
      } // 중복체크 for 문의 끝

      // 중복된 값이 없을 때만 (chk 가 true 일 때) i값을 증가
      if (chk) {
        ++i;
      }
    }
  }

  public static void main(String[] args) {
    new LottoEx4();
  }
}
