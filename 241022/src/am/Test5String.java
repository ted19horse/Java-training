package am;

import java.util.Scanner;

public class Test5String {
  public static void main(String[] args) {
    // 키보드와 연결된 스캐너 생성
    Scanner scan = new Scanner(System.in);

    System.out.println("첫번째 문자열:");
    String msg1 = scan.nextLine(); // 한 줄 입력받기

    System.out.println("두번째 문자열:");
    String msg2 = scan.nextLine(); // 한 줄 입력받기

    // 두 개의 문자열(msg1, msg2)의 내용이 같은지 비교해 보자!
    if (msg1 == msg2) {
      System.out.println("서로 같다.");
    } else {
      System.out.println("서로 다르다.");
    }

    if (msg1.equals(msg2)) {
      System.out.println("서로 같다.");
    } else {
      System.out.println("서로 다르다.");
    }

    scan.close();
  }
}

// 1. 스캐너 입력값은 암시적 객체 생성이 되지 않고 바로 생성되었다
// 2. equals 는 각 주소 내부의 값을 비교한다.
/*
 * - 스트링 객체의 중요한 특징
 * 암시적 객체(String msg1 = "test";) 생성을 하면 기존 메모리에 할당되어 있는 동일한 값을 가진 '객체'가 있는지 먼저
 * 검색하고, 해당 주소를 부여한다.
 * 명시적 객체(String msg2 = new String("test")) 생성을 하면 메모리에 무조건 객체를 생성하고 값을 입력한다.
 * 
 * 명시적 객체 생성으로 텍스트를 생성한 후 암시적 객체 생성을 하면 객체 생성 방법이 다르기 때문에 주소를 참조하지 않고 새로운 객체를
 * 생성한다.
 * String 객체는 암시적/명시적 객체 생성 2가지의 생성방법을 가지며
 * 기존에 생성된 객체의 내용은 절대 바뀔수 없는 불변성을 가지고 있다.
 */
