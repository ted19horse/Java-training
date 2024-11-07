package pm_Game_fuck;

import java.awt.Rectangle;
import java.util.Iterator;

public class MeteorEx2 extends Thread {
  // 위치와 크기를 Rectangle로 지정
  Rectangle rect = new Rectangle();
  int speed;

  // 현재 운석 객체는 JFrame정보를 가지고 있어야 한다.
  // 거기에 있는 ArrayList와 JPanel 등을 접근해야 하기 때문
  Fuck f;

  public MeteorEx2(Fuck f, int w, int h) {
    this.f = f;

    // 받은 w와 h는 Reactangle에 저장해야 한다.
    rect.width = w;
    rect.height = h;

    speed = (int) (Math.random() * 200 + 20);
  }

  @Override
  public void run() {
    // 무한반복을 통해 y값을 증가시킨다.
    // 이때 화면 하단에 도달할 경우 무한반복을 탈출한다.
    while (true) {
      rect.y += 3;

      // 화면하단에 도달했는지? 확인!!
      // p의 사이즈를 dimention에 맞췄기 때문에 getHeight() 대신 getSize().height 를 사용
      if (rect.y >= f.p.getSize().height - rect.height) {
        break;
      }

      // 주인공과 현재 운석이 충돌했을 수도 있으므로 충돌검사를 해보자!
      if (rect.intersects(f.me.rect)) {

        // 폭발객체 생성
        Explotion exp = new Explotion();

        // 충돌한 위치를 폭발객체에 저장해야 한다.
        exp.pt.x = (int) (rect.getCenterX() - exp.size / 2);
        exp.pt.y = (int) (rect.getCenterY() - exp.size / 2);

        // JFrame창의 멤버변수인 ex_list 즉, ArrayList에
        // 폭발객체 저장!
        f.ex_list.add(exp); // 이것 때문에 화면에
        break;
      }

      try {
        Thread.sleep(speed);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      f.p.repaint();
    }
    // 현재 운석객체를 Fuck의 ArrayList에서 삭제한다.

    /* 아래 부분은 java.util.ConcurrentModificationException 이 발생한다 */
    /* 이 방식은 여러 스레드에서 m_list를 점유하게 되어 결국 문제가 발생한다. */
    // f.m_list.remove(this);

    /* 아래 방식도 비슷할 것이다. */
    Iterator<MeteorEx2> it = f.m_list.iterator();
    while (it.hasNext()) {
      MeteorEx2 m = it.next();
      // iterator로 가져온 m의 주소가 현재객체의 주소와 같은지? 비교하자!
      if (m == this) {
        f.m_list.remove(m);
        break;
      }
    }
  }
}
