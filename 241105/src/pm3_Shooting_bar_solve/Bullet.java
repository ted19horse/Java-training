package pm3_Shooting_bar_solve;

public class Bullet extends Thread {
  int x, y;
  int w = 8, h = 20;
  Test f;

  // 현재 객체가 생성되는 시점이 스페이스바를 누를 때다.
  // 그리고 현재 객체에서는 Test의 멤버변수인 ArrayList 또는 JPanel을
  // 접근해야 할 때가 생긴다. 그래서 ArrayList와 JPanel을 가지고 있는
  // Test의 주소를 가지고 있어야 한다.
  public Bullet(int x, int y, Test f) {
    this.x = x;
    this.y = y;
    this.f = f;
  }

  @Override
  public void run() {
    // 일정 시간동안 쉬면서 y좌표를 감소시킨다.
    while (true) {
      y -= 5;
      // 좌표값이 변경되었으므로 다시 그림을 그리도록 한다.
      f.p.repaint();

      try {
        Thread.sleep(20);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      // 현재 총알이 화면 상단에 도달하면
      // 무한반복을 탈출하여 스레드를 소멸시키자
      if (y < 0) {
        // f.p.repaint();
        break;
      }
    } // while의 끝
    f.list.remove(this);
    f.p.repaint();
  }
}
