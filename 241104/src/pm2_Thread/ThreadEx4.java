package pm2_Thread;

public class ThreadEx4 extends Thread {
  ThreadFrameEx4 f; // ********** 매우 중요함

  public ThreadEx4(ThreadFrameEx4 f) {
    this.f = f; // ********** 매우 중요함
  }

  @Override
  public void run() {
    // ThreadFrameEx4 가 가지고 있는 x값을 증가시킨 후
    // 잠시 쉬었다가 ThreadFrameEx4 가 가지는 p 를 다시 그려야 한다.

    // 무한반복
    while (true) {
      // ThreadFrameEx4 가 가지고 있는 x값을 증가!
      ThreadEx4.this.f.x += 5;

      // f의 x값이 f가 가지는 p의 너비를 넘으면 탈출!
      if (ThreadEx4.this.f.x > ThreadEx4.this.f.p.getWidth() - 20) {
        break;
      }

      ThreadEx4.this.f.p.repaint();

      try {
        Thread.sleep(50);
      } catch (Exception e) {
        //
      }
    }
    // 현재 스레드 소멸 직전!!
  }
}
