package am;
import java.util.Scanner;

/**
 * Test1복습
 */
public class Test1복습 {
  public static void main(String[] args) {
    
    // 화면에 "숫자입력:" 문자열 출력
    System.out.println("숫자입력:");

    // 사용자 직접 숫자를 입력하는 객체생성
    Scanner scan = new Scanner(System.in);
    int su = scan.nextInt();

    // 결과값에 조건연산 후 출력
    int result = (su > 100) ? su%100 : su;
    System.err.println(result);

    scan.close();
  }
}