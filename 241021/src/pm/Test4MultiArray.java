package pm;

public class Test4MultiArray {
  public static void main(String[] args) {
    int[] ar1 = { 1, 2, 3 };
    int[] ar2 = { 10, 20, 30, 40 };
    int[] ar3 = { 55, 77 };

    // 위의 1차원 배열들을 하나로 묶기 위해 2차원 배열을 선언
    int[][] ar4 = { ar1, ar2, ar3 };
    // int[][] ar4 = new int[3][];
    // ar4[0] = ar1;
    // ar4[1] = ar2;
    // ar4[2] = ar3;

    // 반복문으로 모두 출력
    for (int i1 = 0; i1 < ar4.length; i1++) {
      for (int i2 = 0; i2 < ar4[i1].length; i2++) {
        System.out.printf("%3d", ar4[i1][i2]);
      }
      System.out.println();
    }
  }
}
