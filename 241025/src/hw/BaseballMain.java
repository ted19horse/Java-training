package hw;

import java.util.Scanner;

public class BaseballMain {
  public static void main(String[] args) {
    // 카드 초기화
    BaseballGame bg = new BaseballGame();
    bg.init();

    // 스캐너 준비
    Scanner scan = new Scanner(System.in);
    System.out.println("게임을 시작하지.");

    // System.out.println(bc.isWin());
    while (bg.getStrike() < 3) {
      for (int i = 0; i < bg.cardList.length; i++) {
        System.out.printf("%2d", bg.cardList[i]);
      }
      System.out.println();

      // 여기부터는 반복
      System.out.println("값을 입력:");
      // 사용자의 값 입력
      Integer playBall = scan.nextInt();
      // 메세지 출력
      String msg = bg.game(playBall);
      System.out.println(msg);
    }

    scan.close();
  }
}
