package pm;

import java.util.Scanner;

public class Test5Switch문 {
  public static void main(String[] args) {
    // 키보드로부터 1,2,3중에 하나를 입력받도록
    System.out.println("입력(1~3):");

    Scanner scan = new Scanner(System.in);
    int val = scan.nextInt();

    if (val > 3) {
      System.out.println("잘 못 입력함");
      scan.close();
      return;
    }

    switch (val) {
      case 1:
        System.out.println("1번");
        break;
      case 2:
        System.out.println("2번");
        break;
      case 3:
        System.out.println("3번");
        break;
    }

    System.out.println("프로그램 판단시작!");

    scan.close();
  }
}
