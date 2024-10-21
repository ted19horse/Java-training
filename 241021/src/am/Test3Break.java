package am;

public class Test3Break {
  public static void main(String[] args) {
    // break문은 반복문을 탈출하는 것으로 알고 있지만
    // switch문을 사용하면 switch문을 탈출하는 과정을 알아본다.

    bk: for (int i = 0; i < 3; i++) {
      switch (i + 1) {
        case 1:
          System.out.printf("%2d", i + 1);
          break; // 반복문 탈출이 아닌 switch를 탈출!
        case 2:
          System.out.printf("%2d", i + 1);
          break;
        case 3:
          System.out.printf("%2d", i + 1);
          break bk; // bk라는 반복문을 탈출!!
        case 4:
          System.out.printf("%2d", i + 1);
          break;
      }
    }
  }
}
