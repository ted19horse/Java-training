package pm;

import am.MyWin;

import javax.swing.*;
import java.awt.*;

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
