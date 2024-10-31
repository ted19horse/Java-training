package hwSolve;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyWin extends WindowAdapter {

  @Override
  public void windowClosing(WindowEvent e) {
    System.exit(0);
  }

}
