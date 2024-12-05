package pm3_Game_fuck;

import java.awt.*;
import java.util.Iterator;

public class MeteorEx2 extends Thread {
  // 위치와 크기를 Rectangle로 지정
  Rectangle rect = new Rectangle();
  int speed;

  // isDestroyed로 while문 조건에서 체크하는 방식
  boolean isDestroyed = false;

  // 현재 운석 객체는 JFrame정보를 가지고 있어야 한다.
  // 거기에 있는 ArrayList와 JPanel 등을 접근해야 하기 때문
  Fuck f;

  public MeteorEx2(Fuck f, int w, int h) {
    this.f = f;

    // 받은 w와 h는 Reactangle에 저장해야 한다.
    rect.width = w;
    rect.height = h;

    /* speed는 sleep을 반복하는 주기이므로 작은 숫자가 더 빠름 */
    speed = (int) (Math.random() * 100 + 20);
  }

  @Override
  public void run() {
    // 무한반복을 통해 y값을 증가시킨다.
    // 이때 화면 하단에 도달할 경우 무한반복을 탈출한다.
    while (!isDestroyed) {
      rect.y += 3;

      // 화면하단에 도달했는지? 확인!!
      // p의 사이즈를 dimention에 맞췄기 때문에 getHeight() 대신 getSize().height 를 사용
      if (rect.y >= f.p.getSize().height - rect.height) {

        // isDestroyed로 while문 조건에서 체크하는 방식
        isDestroyed = true;
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

        // isDestroyed로 while문 조건에서 체크하는 방식
        isDestroyed = true;
      }

      for (Bullet b : f.b_list) {
        if (rect.intersects(b.rect)) {
          // System.out.println("총알 충돌 이벤트 발생");

          // 폭발객체 생성
          Explotion exp = new Explotion();

          // 충돌한 위치를 폭발객체에 저장해야 한다.
          exp.pt.x = (int) (rect.getCenterX() - exp.size / 2);
          exp.pt.y = (int) (rect.getCenterY() - exp.size / 2);

          // JFrame창의 멤버변수인 ex_list 즉, ArrayList에
          // 폭발객체 저장!
          f.ex_list.add(exp); // 이것 때문에 화면에

          // 현재 메테오를 f의 m_list 에서 제거
          Iterator<MeteorEx2> itm = f.m_list.iterator();
          while (itm.hasNext()) {
            MeteorEx2 m = itm.next();
            // iterator로 가져온 m의 주소가 현재객체의 주소와 같은지? 비교하자!
            if (m == this) {
              // System.out.println("반복 중에 메테오 제거");
              m.interrupt();
              f.m_list.remove(m);
              break; // break while iterator
            }
          }

          // 현재 총알을 f의 b_list 에서 제거
          Iterator<Bullet> itb = f.b_list.iterator();
          while (itb.hasNext()) {
            Bullet lb = itb.next();
            // iterator로 가져온 b의 주소가 현재객체의 주소와 같은지? 비교하자!
            if (lb == b) {
              // System.out.println("반복 중에 총알 제거");
              b.interrupt();
              f.b_list.remove(b);
              break; // break while iterator
            }
          }

          break; // break for
        }
      }

      try {
        Thread.sleep(speed);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        // isDestroyed로 while문 조건에서 체크하는 방식
        isDestroyed = true;
      } catch (Exception e) {
        // isDestroyed로 while문 조건에서 체크하는 방식
        e.printStackTrace();
        isDestroyed = true;
      } finally {
        f.p.repaint();
      }
    }

    // 현재 운석객체를 Fuck의 ArrayList에서 삭제한다.
    /* 현재 위치는 while이 끝났으므로 운석이 땅에 닿은 상황이다. */
    /* 충돌 이벤트 발생시 이미 f.m_list.remove(m)를 했으니까 중복은 되지 않을 것 같다. */
    /* 그래도 print로 실험해보자 */

    /* 아래 부분은 java.util.ConcurrentModificationException 이 발생한다 */
    /* 이 방식은 여러 스레드에서 m_list를 점유하게 되어 결국 문제가 발생한다. */
    // f.m_list.remove(this);

    /* 아래 방식은 iterator를 사용한 것이지만 상황 발생은 비슷할 것이다. */
    Iterator<MeteorEx2> it = f.m_list.iterator();
    while (it.hasNext()) {
      MeteorEx2 m = it.next();
      // iterator로 가져온 m의 주소가 현재객체의 주소와 같은지? 비교하자!
      if (m == this) {
        // System.out.println("반복 밖에 메테오 제거");
        m.interrupt();
        f.m_list.remove(m);
        break;
      }
    }
  }
}
