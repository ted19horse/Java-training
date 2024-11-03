package pm3_Inner_Class;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InnerEx3 {

  String str = "쌍용교육센터"; // 멤버변수

  class Inner { // 내부클래스(멤버)
    int value = 10;

    public void test() {
      System.out.println(str);
      System.out.println(value);
    }
  } // 내부클래스의 끝: 내부플래스의 장점은 바깥쪽 클래스의 멤버를 자신의 것처럼 사용함

  public InnerEx3() {
    // WindowAdapter wa = new WindowAdapter() { // 내부클래스(지역)
    new WindowAdapter() { // 내부클래스(지역)
      // WindowAdapter 의 새로운 영역으로 인식한다.
      // 그렇다면 WindowAdapter 의 새로운 영역은 바로 WindowAdapter 를 상속받는 새로운 영역이다.
      // 즉,
      // class ? extends WindowAdapter{}
      // 와 같이 사용되었다.

      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    };
  }

  public static void main(String[] args) {
    InnerEx3 ex3 = new InnerEx3();

    // 내부클래스 생성: 내부클래스는 반드시 바깥쪽 클래스를 통해서 생성해야 함
    // InnerEx3.Inner i = new InnerEx3().new Inner(); // 바깥쪽 클래스가 생성되지 않았을 때 사용
    InnerEx3.Inner i = ex3.new Inner(); // 바깥쪽 클래스가 생성되있으면 사용
    i.test();
  }
}
