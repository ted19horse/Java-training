package am2_Falling_keyword;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class DownKeywordFrameEx3 extends JFrame {
  /* Field */
  JPanel panelTop, panelText;
  JButton btnStart;
  boolean isStart = false;
  String[] keywordArr = new String[] { "용기", "우정", "사랑", "빨간망토", "차차" };
  ArrayList<KeywordEx3> list = new ArrayList<KeywordEx3>();
  Timer timer;

  class tim extends Thread {
    @Override
    public void run() {
      while (true) {
        // System.out.println("in thread roop");
        String txt = keywordArr[(int) (Math.random() * keywordArr.length)];
        int lbLength = new JLabel(txt).getWidth();
        int x = (int) (Math.random() * DownKeywordFrameEx3.this.panelText.getWidth());
        if (x > DownKeywordFrameEx3.this.panelText.getWidth() - lbLength) {
          x = DownKeywordFrameEx3.this.panelText.getWidth() - lbLength;
        }
        KeywordEx3 ki = new KeywordEx3(DownKeywordFrameEx3.this, x, txt);
        // System.out.println("txt:" + txt + " posX:" + x);
        list.add(ki);
        ki.start();
        // System.out.println("roop");

        try {
          Thread.sleep(1000);
        } catch (Exception e) {
        }
      }
    }
  }

  /* Constructer */
  public DownKeywordFrameEx3() {
    panelTop = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    btnStart = new JButton("시작");
    panelTop.add(btnStart);
    this.add(panelTop, BorderLayout.NORTH);

    this.add(panelText = new JPanel() {
      @Override
      protected void paintComponent(Graphics g) {
        Image buf = createImage(this.getWidth(), this.getHeight());
        Graphics buf_g = buf.getGraphics();
        for (int i = 0; i < list.size(); i++) {
          KeywordEx3 kel = list.get(i);
          buf_g.drawString(kel.txt, kel.x, kel.y);
        }
        g.drawImage(buf, 0, 0, this);
      }
    });

    this.setBounds(1000, 100, 600, 500);
    this.setVisible(true);

    /* Event listener */
    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    btnStart.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (!isStart) {
          DownKeywordFrameEx3.this.isStart = true;
          System.out.println("chk");

          Thread tt = new tim();
          tt.start();

          // timer = new Timer(1000, new ActionListener() {
          // @Override
          // public void actionPerformed(ActionEvent e) {
          // // System.out.println("in timer");
          // String txt = keywordArr[(int) (Math.random() * keywordArr.length)];
          // int lbLength = new JLabel(txt).getWidth();
          // int x = (int) (Math.random() *
          // DownKeywordFrameEx3.this.panelText.getWidth());
          // if (x > DownKeywordFrameEx3.this.panelText.getWidth() - lbLength) {
          // x = DownKeywordFrameEx3.this.panelText.getWidth() - lbLength;
          // }
          // KeywordEx3 ki = new KeywordEx3(DownKeywordFrameEx3.this, x, txt);
          // // System.out.println("txt:" + txt + " posX:" + x);
          // list.add(ki);
          // ki.start();
          // // System.out.println("roop");
          // }
          // });
          // timer.start();
        }
      }
    });
  }

  /* Event handler */
  public static void main(String[] args) {
    new DownKeywordFrameEx3();
  }
}
