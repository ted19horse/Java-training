package am;

public class Test5MultiFor {
  public static void main(String[] args) {
    // [결과]
    // * * * *
    // * * * *
    // * * * *
    // for (int i1 = 1; i1 <= 3; i1++) {
    // for (int i2 = 1; i2 <= 4; i2++) {
    // System.out.print("* ");
    // }
    // System.out.println();
    // }

    // [결과]
    // 1 2 3 4 5
    // 1 2 3 4 5
    // 1 2 3 4 5
    // for (int i3 = 1; i3 <= 3; i3++) {
    // for (int i4 = 1; i4 <= 5; i4++) {
    // String msg = i4 + " ";
    // System.out.print(msg);
    // }
    // System.out.println();
    // }

    // [결과]
    // 1 2 3 4 5
    // 6 7 8 9 10
    // 11 12 13 14 15
    // for (int i5 = 1; i5 <= 15; i5++) {
    // String msg = i5 + " ";
    // if (i5 < 10)
    // msg += " ";
    // System.out.print(msg);
    // if (i5 % 5 == 0)
    // System.out.println();
    // }
    int val = 0;
    for (int i6 = 0; i6 < 3; i6++) {
      for (int i7 = 0; i7 < 5; i7++) {
        System.out.printf("%-3d", ++val);
        // %d 1자리 10진수
        // %2d 2자리 10진수
        // %3d 3자리 10진수
        // - 붙이면 앞에서부터 정렬
      }
      System.out.println();
    }
  }
}
