package pm2_Thread;

public class MainEx3 {
  public static void main(String[] args) {
    ThreadEx3 t1 = new ThreadEx3();
    t1.start(); // 비동기!! >> 새로운 스레드 시작 --> run 함수를 자동 호출
    // t1.run(); // 동기!! >> 스레드를 시작한게 아니라 run 함수만 호출한 것

    ThreadEx3_1 t2 = new ThreadEx3_1();
    t2.start();

    // Thread t3 = new Thread() { // 내부클래스로 사용 가능
    new Thread() { // 내부클래스로 사용 가능
      @Override
      public void run() {
        super.run();
      }
    };

    System.out.println("나는 메인이야!");

  }
}
