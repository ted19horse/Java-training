package pm5_Solve;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Test extends JFrame {
  int x, y, w = 100, h = 50;
  Color c; // 객체자료형의 기본값은 null 이다.

  Canvas can = new Canvas() {
    // Canvas 를 상속받는 내부클래스
    @Override
    public void paint(Graphics g) {
      if (c != null) {
        g.setColor(Test.this.c);
      }
      g.fillRect(Test.this.x, Test.this.y, Test.this.w, Test.this.h); // 내부클래스 바깥쪽 데이터를 사용할 때는 위치를 명시적으로 지정하는것이 검색에 유리하다
    }
  };

  public Test() {
    this.add(can);
    this.setBounds(300, 50, 600, 550);
    this.setVisible(true);

    // 현재창 가운데에 상자그림을 그리기 위해 현재 캔버스의 너비에서 2를 나눈 후
    // 상자의 너비에서 2를 나눈 값을 뺀다.
    this.x = (can.getWidth() / 2) - w / 2;
    this.y = can.getHeight() - (h + 5);

    // this.addWindowListener(new WindowListener() {
    // WindowListener(인터페이스)를 내부클래스로 사용하면 해당 인터페이스가 가지는 추상메서드를 전부 재정의 해야한다.
    // 그럴거면 현재 클래스에 implements 를 하는게 낫지..
    this.addWindowListener(new WindowAdapter() {
      // WindowAdapter 를 상속받는 익명의 내부클래스가 생성되는 영역
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    this.addKeyListener(new KeyAdapter() {
      // KeyAdapter 를 상속받는 익명의 내부클래스 영역
      // 곧 이 안에서 this 는 KeyAdapter 를 상속받는 내부클래스를 의미함
      @Override
      public void keyPressed(KeyEvent e) {
        // 사용자가 누른 키의 코드를 얻어낸다.
        int code = e.getKeyCode();

        switch (code) {
          case KeyEvent.VK_LEFT:
            // this.x -= 10; // 내부클래스 안에서 this 를 사용하면 내부클래스 안의 필드를 가르킨다.
            Test.this.x -= 10; // 내부클래스 안에서 명시적으로 바깥클래스의 필드를 사용하는 방법
            if (Test.this.x < 2) {
              Test.this.x = 2;
            }
            break;
          case KeyEvent.VK_RIGHT:
            // x += 10; // 변수를 내부클래스 안에서 찾지 못하면 자동으로 바깥클래스에서 변수를 찾는다. 다만 검색위치는 전체라 느려짐.
            Test.this.x += 10;
            if (Test.this.x > Test.this.can.getWidth() - Test.this.w - 2) {
              Test.this.x = Test.this.can.getWidth() - Test.this.w - 2;
            }
            break;
          case KeyEvent.VK_SPACE:
            // 색상 선택
            int red = (int) (Math.random() * 256);
            int greed = (int) (Math.random() * 256);
            int blue = (int) (Math.random() * 256);

            Test.this.c = new Color(red, greed, blue);
            break;
        }
        // Test.can.repaint(); // Math.random() 과 같이 repaint() 가 static 메서드인 경우는
        // 주소를 바로 찾아간다. 아니면 can.repaint() 와 같음.
        // 좌표가 변경되었으니 캔버스의 그림을 다시 그린다.
        Test.this.can.repaint();
      }
    });
  }

  public static void main(String[] args) {
    new Test();
  }
}
