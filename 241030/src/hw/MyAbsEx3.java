package hw;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyAbsEx3 extends WindowAdapter {

  @Override
  public void windowClosing(WindowEvent e) {
    System.exit(0);
  }

}
