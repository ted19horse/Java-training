package pm2;

import javax.swing.JFrame;

import am.MyWin;

public class CanvasEx4 extends JFrame {
  MyCanvasEx4 can;

  public CanvasEx4() {
    this.add(can = new MyCanvasEx4());

    this.setBounds(300, 50, 500, 450);
    this.setVisible(true);
    this.addWindowListener(new MyWin());
  }

  public static void main(String[] args) {
    new CanvasEx4();
  }
}
