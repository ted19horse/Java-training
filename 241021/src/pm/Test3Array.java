package pm;

public class Test3Array {
  public static void main(String[] args) {
    int[] ar1 = { 10, 20, 30 };
    int[] ar2 = { 200, 300, 400 };

    // 2차원 배열 선언하자
    // int[][] ar3 = new int[][]{ar1,ar2};
    int[][] ar3 = new int[2][]; // n차원 배열 생성시 1차원 배열 안의 요소 수는 중요하지 않다.
    ar3[0] = ar1; // 2차원 배열 첫번째 요소에 1차원 배열 ar1이 기억하는 주소를 저장한다.
    ar3[1] = ar2;

    // System.out.println(ar3[0][1]);

    for (int i = 0; i < ar3.length; i++) {
      for (int j = 0; j < ar3[i].length; j++) {
        System.out.printf("%4d", ar3[i][j]);
      }
      System.out.println();
    }
  }
}
