package am;

public class Test1Array {
  public static void main(String[] args) {
    // 1D []
    int[] a1 = { 1, 2, 3 };
    int[] a2 = { 4, 5, 6 };

    // 2D []
    int[][] a3 = new int[2][];
    a3[0] = a1;
    a3[1] = a2;

    // 1D[]
    int[] a4 = { 7, 8, 9 };
    int[] a5 = { 9, 9, 9 };

    // 위 a4 a5를 하나로 묶는 2차원 배열 생성
    int[][] a6 = { a4, a5 };

    for (int i = 0; i < a6.length; i++) {
      for (int j = 0; j < a6[i].length; j++) {
        System.out.printf("%2d", a6[i][j]);
      }
      System.out.println();
    }

    // a3, a6를 가지는 3차원 배열 생성
    int[][][] a7 = { a3, a6 };
    System.out.println(a7);
  }
}
