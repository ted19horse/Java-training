package am;

public class Test4Continue {
  public static void main(String[] args) {
    aa: for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 4; j++) {
        if ((j + 1) % 3 == 0) {
          continue aa; // 이후 내용을 하지 않고 다음 반복회차로 넘어간다
        }
        System.out.printf("%2d", (j + 1));
      } // for문의 끝
      System.out.println(); // 줄바꿈
    } // 바깥쪽 for문의 끝
  }
}
