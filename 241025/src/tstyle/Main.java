package tstyle;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // do {
    // 원하는 객체 생성
    Baseball bb = new Baseball();
    for (int i = 0; i < bb.com.length; i++) {
      System.out.printf("[%d]", bb.com[i]);
    }
    System.out.println();
    int s_count = 0;
    int b_count = 0;
    int try_num = 0;

    // 사용자 값 입력
    do {
      System.out.println("입력");
      // 사용자 입력 대기
      ++try_num;
      Scanner scan = new Scanner(System.in);
      String str = scan.next();

      if (str.length() != bb.com.length) {
        System.out.println("잘못 입력하셨습니다.");
        scan.close();
        return;
      } else {
        // 입력한 문자열이 3자면 한글자씩 가져와서 배열 생성
        int[] ar = new int[3];
        boolean chk = true;

        for (int i = 0; i < ar.length; i++) {
          char ch = str.charAt(i); // 1번째 숫자, ex)"1" --> 49
          if (ch >= '0' && ch <= '9') {
            int n = ch - 48;
            ar[i] = n;
          } else {
            chk = false;
            break;
          }
        }

        if (chk) {
          /*
           * 입력값이 모두 숫자
           * for문에서 ar 배열에 값 저장 완료
           * ar 배열을 인자로 스트라이크를 판단
           */
          bb.setUser(ar);
          /*
           * 현재 영역의 ar 배열주소를 Baseball.user에 저장.
           * 스트라이크 수를 받기 위해서.
           */
          s_count = bb.strikeCount();
          b_count = bb.ballCount();
          System.out.printf("%d회차:%d스트라이크, %d볼\r\n", try_num, s_count, b_count);

          if (s_count == 3) {
            System.out.println("다시 하시겠습니까?(y/n)");
            str = scan.next();

            // 사용자가 입력한 값이 n 또는 N이 아닐 경우는 무조건 다시 수행
            if (str.equalsIgnoreCase("n")) {
              break;
            }
            // n 또는 N이 아니면 try_num 초기화, Baseball에 있는 com 배열도 초기화 해야함
            try_num = 0;
            bb.initCom();
          }
        }
      }
      scan.close();
      // } while (s_count != 3);
    } while (true);

    // // 다시 하시겠습니까?(Y/N) 을 출력, n만 아니면 무조건 다시 시작
    // System.out.println("다시 하시겠습니까?(y/n)");
    // coun = scan.next().charAt(0);
    // } while (coun != 'n');

  }
}
