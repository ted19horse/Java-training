package pm;

public class Test5MultiArray {
  public static void main(String[] args) {
    // 타입이 정수이고 길이가 4개짜리인 1차원 배열을 4개 저장하는 2차원 배열을 선언
    int[][] ar = new int[4][4];

    for (int i1 = 0; i1 < ar.length; i1++) {
      for (int i2 = 0; i2 < ar[i1].length; i2++) {
        if (i1 == i2)
          ar[i1][i2] = 1;
        System.out.printf("%3d", ar[i1][i2]);
      }
      System.out.println();
    }
  }
}
