package pm2_Thread;

public class ThreadEx3 extends Thread {
  // 스레드를 상속받은 현재클래스는 스레드다.

  @Override
  public void run() {
    // 현재 스레드가 해야할 일들...
    for (int i = 1; i <= 10; i++) {
      System.out.printf("%-3d", i);
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
}
