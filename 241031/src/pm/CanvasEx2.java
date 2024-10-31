package pm;

import java.awt.Canvas;

import javax.swing.JFrame;

import am.MyWin;

public class CanvasEx2 extends JFrame {

  Canvas can;

  public CanvasEx2() {
    this.add(can = new Canvas());

    this.setBounds(500, 100, 500, 500);
    this.setVisible(true);
    this.addWindowListener(new MyWin());
  }

  public static void main(String[] args) {
    new CanvasEx2();
  }
}
