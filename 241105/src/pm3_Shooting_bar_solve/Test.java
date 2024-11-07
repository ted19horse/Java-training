package pm3_Shooting_bar_solve;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test extends JFrame {
  JPanel p;
  int w = 80;
  int h = 30;
  int x, y;
  ArrayList<Bullet> list = new ArrayList<>();

  public Test() {
    this.add(p = new JPanel() {
      // 현재 영역은 JPanel을 상속받는 익명의 내부클래스 영역이다.
      @Override
      protected void paintComponent(Graphics g) {
        // 더블버퍼링 기법 - 현 JPanel과 같은 크기의 Image객체를 준비한다.
        Image img = createImage(this.getWidth(), this.getHeight());

        // 준비된 이미지 객체에만 그림을 그릴 수 있는 붓 객체를 준비한다.
        Graphics ig = img.getGraphics();

        // 그림을 그리기 위해 붓(Graphics)이 필요한 것이며 그 붓은 반드시
        // 그리고자 하는 곳(Image)으로 부터 얻어야 한다.

        ig.fillRect(x, y, w, h);

        // for (int i = 0; i < list.size(); i++) {
        // Bullet b = list.get(i);
        // ig.fillOval(b.x, b.y, b.w, b.h);
        // }

        // 개선형, map이나 in 과 유사한 형태, 여전히 배열과 리스트에만 사용이 가능해서 iterator와는 사용이 다름.
        for (Bullet b : list) {
          ig.fillOval(b.x, b.y, b.w, b.h);
          // 총알을 여러개 그리고 싶다면 직접 paint 로 그리는 것 보다 스레드를 추가하는게 맞다.
          // 그림만 추가하면 이벤트 캐치가 안되거나 어려움.
          // ig.fillOval(b.x + ((Test.this.w - b.w) / 2), b.y - b.h, b.w, b.h);
          // ig.fillOval(b.x + Test.this.w - b.w, b.y, b.w, b.h);
        }

        // 이렇게 그림이 그려진 Image를 다시 현 JPanel에 이미지로 그린다.
        // Observer는 관찰자로, 이미지가 잘 그려지는지 확인하는 역활을 한다.
        // component로 상속받은 이미지는 모두 관찰자를 가지고 있다.
        g.drawImage(img, 0, 0, this);
      }
    });

    p.setFocusable(true); // JPanel을 활성화!

    this.setBounds(1000, 100, 600, 500);
    this.setVisible(true);

    x = (p.getWidth() / 2) - (w / 2); // setVisible 후에 해야함!
    y = p.getHeight() - (h + 5); // 상자의 y값도 되지만 총알의 y값으로도 쓰인다.

    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    p.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        // 사용자가 누른 키의 코드 값을 얻어낸다.
        int code = e.getKeyCode();

        switch (code) {
          case KeyEvent.VK_LEFT:
            x -= 5;
            // x가 0보다 작다는 것은 왼쪽 벽을 뚫고 지나갔다는 의미다.
            // 이건 있을 수 없는 일이므로 x의 값을 다시 0으로 초기화 하낟.
            if (x < 0) {
              x = 0;
            }
            break;
          case KeyEvent.VK_RIGHT:
            x += 5;
            if (x > p.getWidth() - w) {
              x = p.getWidth() - w;
            }
            break;
          case KeyEvent.VK_SPACE:
            // 스페이스바를 누를 때마다 총알 객체 생성
            Bullet b = new Bullet(x, y, Test.this);

            // 생성된 총알객체를 ArrayList에 저장한다.
            list.add(b);
            // list에 저장해 둬야 나중에 그림을 그릴 때 list에 있는 총알들을 모두 가져와서 그릴 수 있다.
            // 총알들은 모두가 스레드다. 스레드 구동하자.
            b.start();
            break;
        } // switch의 끝
        // 프로그램의 흐름이 현재 위치에 왔다는 것은 좌표가 변경되었을 것이다.
        // 그러면 그림을 다시 그려야 한다.
        p.repaint();
        // 만약 안움직이면 paint 부분에서 변수 값을 할당중인지 확인해볼것.
      }
    });
  }

  public static void main(String[] args) {
    new Test();
  }
}
