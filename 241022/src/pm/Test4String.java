package pm;

import java.util.Scanner;

public class Test4String {
  public static void main(String[] args) {
    String p_num = "010-1234-5678";
    String s = p_num.replaceAll("-", "");
    System.out.println(s);

    System.out.println("--- 별도로 구분해서 관리하려면 ---");
    String[] p_ar = p_num.split("-");

    for (int i = 0; i < p_ar.length; i++) {
      System.out.printf("%s", p_ar[i]);
    }

    System.out.println();
    System.out.println("--- Scanner 입력받기 ---");

    Scanner scan = new Scanner(System.in);
    String data = scan.nextLine();
    String l1 = data.substring(0, 1);
    String l2 = data.substring(1, 2);

    System.out.println(l1);
    System.out.println(l2);

    int i1 = Integer.parseInt(l1);
    int i2 = Integer.parseInt(l2);

    System.out.println(i1);
    System.out.println(i2);

    int[][] ar = new int[i1][i2];
    for (int i = 0; i < ar.length; i++) {
      for (int j = 0; j < ar[i].length; j++) {
        System.out.printf("%2d", ar[i][j]);
      }
      System.out.println();
    }

    scan.close();
  }
}
