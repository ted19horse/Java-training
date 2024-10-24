package vendingMachine;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    /*
     * 자판기 만들기
     * 1: 레쓰비 500원
     * 2: 사이다 700원
     * 3: 콜라 800원
     * 4: 웰치스 900원
     * 
     * insert coin:
     * 숫자 값 입력받음
     * ex 800
     * 
     * 뽑을 수 있는 음료수 종류 표시
     * 1:레쓰비, 2:사이다, 3:콜라
     * 숫자 값 입력받음
     * ex 2
     * 
     * 사이다 잔돈:100
     */

    // 클래스 초기화
    VendingMachine vendingMachine = new VendingMachine();
    // 음료수 리스트 만들기
    vendingMachine.init();

    // 스캐너 생성
    Scanner scan = new Scanner(System.in);
    String msg;

    // insert coin
    System.out.println("insert coin:");
    int coin = scan.nextInt();
    msg = vendingMachine.selecter(coin);
    System.out.println(msg);

    if (!vendingMachine.isPickable()) {
      System.out.println("자판기 종료");
      scan.close();
      return;
    }

    // picker
    System.out.println("음료를 선택하세요.");
    int pick = scan.nextInt();
    switch (pick) {
      case 1:
        break;
      case 2:
        break;
      case 3:
        break;
      case 4:
        break;
      default: {
        msg = "올바르지 않은 값입니다. 거스름돈: " + coin;
        break;
      }
    }

    msg = vendingMachine.picker(msg, pick);
    System.out.println(msg);

    scan.close();
  }
}
