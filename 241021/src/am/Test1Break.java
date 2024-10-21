package am;

public class Test1Break {
  public static void main(String[] args) {
    for (int j = 0; j < 3; j++) {
      for (int i = 0; i < 4; i++) {
        System.out.printf("%2d", (i + 1));
        if ((i + 1) % 3 == 0) { // 3의 배수일 때 반복문 탈출
          break; // 가장 가까운 반복문 탈출
        }
      }
      System.out.println();
    }
  }
}
