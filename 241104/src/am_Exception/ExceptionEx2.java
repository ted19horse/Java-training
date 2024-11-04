package am_Exception;

import java.util.Scanner;

public class ExceptionEx2 {
  public static void main(String[] args) {
    // 예외란
    // 예상하지 못한 이벤트(오류)가 발생한 것을 의미
    // ex) NullPointerException / ArithmeticException / By 0
    // 그냥 오류가 아니라 가벼운 오류 (개발자에 의해 수정이 가능한 가벼운 오류)

    int res = 100;
    Scanner scan = new Scanner(System.in);
    System.out.println("값 입력:");
    int su = scan.nextInt(); // 정수 하나 입력

    try {
      // 예외가 발생 가능한 영역
      System.out.println("받은 값으로 나누기:" + (res / su));
    } catch (ArithmeticException e) {
      // System.out.println("문제가 발생해서 catch 로 옴");
      su = 1;
      System.out.println("받은 값으로 나누기(예외):" + (res / su));

      // scan.close();
      // return;
    } catch (Exception e) {
      /* 모든 오류를 캐치하는 형태 */
      /*
       * Catch 를 여러번 써서 다양한 형태의 Exception 을 catch 가능하다.
       * 다만 Exception 을 먼저 캐치하면 Arithmetic 같이 하위 예외는 캐치되지 않기 때문에
       * 순서에 상관은 있다.
       */
      System.out.println("Exception 에서의 처리");
    } finally {
      /*
       * 예외 발생여부에 상관없이 무조건 실행하는 파트
       * try/catch 에서 return 을 하더라도 "무조건" 수행
       */
      System.out.println("Finally, 무조건 수행하는 영역이며 return 있어도 실행");
    }

    System.out.println("프로그램 끝~~~!");
    scan.close();
  }
}
