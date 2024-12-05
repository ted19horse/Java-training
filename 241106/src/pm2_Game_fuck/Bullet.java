package pm2_Game_fuck;

import java.awt.*;
import java.util.Iterator;

public class Bullet extends Thread {
  // 위치와 크기를 Rectangle로 지정
  Rectangle rect = new Rectangle();
  int speed = 50;

  boolean isDestroyed = false;

  // 현재 총알 객체는 JFrame정보를 가지고 있어야 한다.
  // 거기에 있는 ArrayList와 JPanel 등을 접근해야 하기 때문
  Fuck f;

  public Bullet(Fuck f) {
    this.f = f;

    // eactangle의 사이즈를 지정 저장해야 한다.
    rect.width = 6;
    rect.height = 14;
  }

  @Override
  public void run() {
    // 무한반복을 통해 y값을 감소시킨다.
    // 이때 화면 상단에 도달할 경우 무한반복을 탈출한다.
    while (!isDestroyed) {
      rect.y -= 5;

      // 화면상단에 도달했는지? 확인!!
      if (rect.y < 0) {
        isDestroyed = true;
      }

      try {
        Thread.sleep(50); // 총알이니까 고정속도로 박자
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        isDestroyed = true;
      } catch (Exception e) {
        e.printStackTrace();
        isDestroyed = true;
      } finally {
        f.p.repaint();
      }
    }
    // 현재 총알객체를 Fuck의 ArrayList에서 삭제한다.

    /* 아래 부분은 java.util.ConcurrentModificationException 이 발생한다 */
    /* 이 방식은 여러 스레드에서 m_list를 점유하게 되어 결국 문제가 발생한다. */
    // f.m_list.remove(this);

    /* 아래 방식도 비슷할 것이다. */
    Iterator<Bullet> it = f.b_list.iterator();
    while (it.hasNext()) {
      Bullet b = it.next();
      // iterator로 가져온 m의 주소가 현재객체의 주소와 같은지? 비교하자!
      if (b == this) {
        b.interrupt();
        f.b_list.remove(b);
        break;
      }
    }
  }
}
