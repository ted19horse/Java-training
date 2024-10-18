package pm;

import java.util.Scanner;

public class Test6Switch문 {
  public static void main(String[] args) {
    // 키보드와 연결된 스캐너 객체 생성
    Scanner scan = new Scanner(System.in);

    System.out.println("원하는 월을 입력(1~12)");
    int month = scan.nextInt();

    if (month > 12 || month < 1) {
      System.out.println("값을 잘못 입력했습니다.");
      scan.close();
      return;
    }

    // 1,3,5,7,8,10,12 ~31
    // 4,6,9,11 ~30
    // 2 ~29
    String msg = "";

    switch (month) {
      case 5:
      case 1:
      case 3:
      case 7:
      case 8:
      case 12:
      case 10:
        msg = "큰달이므로 31일까지 입니다.";
        break;
      case 4:
      case 6:
      case 9:
      case 11:
        msg = "작은달이므로 30일까지 입니다.";
        break;
      default:
        msg = "2월은 29일까지 입니다.";
    }
    System.out.println(month + "는 " + msg);
    scan.close();
  }
}
