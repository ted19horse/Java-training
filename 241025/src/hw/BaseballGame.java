package hw;

import java.util.HashSet;
import java.util.Iterator;

public class BaseballGame {
  private int strike = 0;
  private int ball = 0;
  public int[] cardList = new int[3];

  public int getStrike() {
    return this.strike;
  }

  public int getBall() {
    return this.ball;
  }

  public void init() {
    // Init Set
    HashSet<Integer> hs = new HashSet<Integer>();
    // Init ran
    int ran = (int) (Math.random() * 9 + 1);
    // Make Set
    while (hs.size() < 3) {
      hs.add(ran);
      ran = (int) (Math.random() * 9 + 1);
    }
    // Init Iterator
    Iterator<Integer> it = hs.iterator();
    // Push el in cardList
    for (int i = 0; i < this.cardList.length; i++) {
      this.cardList[i] = it.next();
    }
    System.out.println("카드리스트는");
    for (int i = 0; i < this.cardList.length; i++) {
      System.out.printf("%2d", this.cardList[i]);
    }
    System.out.println();
  }

  public String game(Integer anw) {
    // 메세지 초기화
    StringBuffer sb = new StringBuffer();
    // 유저의 값 검사
    String cardNum = anw.toString();

    // 1. 카드는 무조건 3장(이상)
    if (cardNum.length() < 3) {
      sb.append("카드는 3장 이상");
      return sb.toString();
    }

    int card1 = cardNum.charAt(0) - 48;
    int card2 = cardNum.charAt(1) - 48;
    int card3 = cardNum.charAt(2) - 48;

    // 2. 0은 안돼
    if (card1 == 0 || card2 == 0 || card3 == 0) {
      sb.append("0은 안돼");
      return sb.toString();
    }

    // 3. 카드는 중복 안돼
    HashSet<Integer> testInitHs = new HashSet<>();
    testInitHs.add(card1);
    testInitHs.add(card2);
    testInitHs.add(card3);
    if (testInitHs.size() < 3) {
      sb.append("카드 중복은 반칙");
      return sb.toString();
    }

    // 카드 매칭 준비
    this.strike = 0;
    this.ball = 0;
    int[] userCard = new int[3];
    userCard[0] = card1;
    userCard[1] = card2;
    userCard[2] = card3;
    System.out.printf("1번 카드 %-2d", card1);
    System.out.printf("2번 카드 %-2d", card2);
    System.out.printf("3번 카드 %-2d", card3);
    System.out.println();

    // 카드 매칭
    for (int i = 0; i < this.cardList.length; i++) {
      for (int j = 0; j < userCard.length; j++) {
        if (i == j && this.cardList[i] == userCard[j]) {
          strike++;
        } else if (i != j && this.cardList[i] == userCard[j]) {
          ball++;
        }
      }
    }

    if (strike == 3) {
      sb.append("3스트라이크, 아웃!");
      return sb.toString();
    } else {
      sb.append(this.strike);
      sb.append("스트라이크, ");
      sb.append(this.ball);
      sb.append("볼");
    }

    return sb.toString();
  }
}
