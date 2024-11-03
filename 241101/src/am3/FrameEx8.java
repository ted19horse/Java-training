package am3;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class FrameEx8 extends JFrame {
  CanvasEx8 can;

  public FrameEx8() {
    this.add(can = new CanvasEx8());

    this.setBounds(300, 50, 500, 500);
    this.setVisible(true);
    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }

  public static void main(String[] args) {
    new FrameEx8();
  }
}
