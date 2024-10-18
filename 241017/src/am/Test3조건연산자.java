package am;
import java.util.Scanner;

/**
 * Test3조건연산자
 */
public class Test3조건연산자 {

  public static void main(String[] args) {
    // 키보드(System.in)에서 정수를 입력받기 위해 Scanner 객체 생성
    Scanner scan = new Scanner(System.in);

    // 화면에 "정수입력:" 문자열을 출력
    System.out.println("정수입력:");

    // 키보드와 연결된 장치로부터 숫자를 하나 입력 받아 변수 su1에 저장
    int su1 = scan.nextInt();

    // 일반 변수는 스택에 캐싱, 객체 변수는 힙에 캐싱

    // 입력된 값은 su1
    // su1이 100보다 크면 "잘못된 값" 아니면 "유효한 값"
    // System.out.println(su1 > 100 ? "잘못된 값" : "유효한 값");
    String result = su1 > 100 ? "잘못된 값" : "유효한 값";
    System.out.println(result);

    scan.close();
  }
}