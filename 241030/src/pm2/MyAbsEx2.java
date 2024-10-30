package pm2;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyAbsEx2 extends WindowAdapter {
  /*
   * WindowAdapter 는 abstract 클래스지만
   * 내부에 abstract method 를 하나도 가지고 있지 않다.
   * 그래서 상속을 받자마자 사용자가 필요한 메서드만 재정의해서 사용하는 것
   */
  @Override
  public void windowClosing(WindowEvent e) {
    super.windowClosing(e);
    System.exit(0);
  }
}
