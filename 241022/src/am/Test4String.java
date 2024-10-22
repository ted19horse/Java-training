package am;

import java.util.Scanner;

public class Test4String {
  public static void main(String[] args) {
    // 키보드와 연결된 스캐너 생성
    Scanner scan = new Scanner(System.in);
    System.out.println("문자열 입력:");

    String msg = scan.nextLine(); // 사용자가 엔터를 입력할 때 까지 대기

    // 사용자가 입력한 값이 String형의 변수 msg 에 저장되었다.
    int len = msg.length(); // 입력한 문자열의 길이를 얻어낸다.

    // ;laksduf0894e
    System.out.println("총 문자열 길이는 " + len);

    int count = 0;
    for (int i = 0; i < len; i++) {
      char ch = msg.charAt(i);
      if ('0' <= ch && ch <= '9') {
        count += 1;
      }
      System.out.printf("%s ", ch);
    }
    System.out.println();
    System.out.print("숫자의 개수는 총 " + count);

    scan.close();
  }
}
