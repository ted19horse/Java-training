package pm2_Thread;

public class ThreadEx3_1 extends Thread {

  @Override
  public void run() {
    super.run();
    for (int i = 0; i < 7; i++) {
      System.out.printf("%-2s", "*");
      try {
        Thread.sleep(200);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

}
