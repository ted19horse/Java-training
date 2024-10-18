package am;
import java.util.Scanner;

public class Test4if문 {
  public static void main(String[] args) {
    // 제어문
    /*
     * - 분기문(비교문)
     * 1) if문 : 단순if, if~else, 다중if
     * 2) switch
     * 
     * - 반복문
     * 1) for
     * 2) while
     * 3) do while
    */

    Scanner scan = new Scanner(System.in);
    System.out.println("숫자입력:");

    int su1 = scan.nextInt();
    // [조건] su1이 10 이상이면 화면에 "10이상" 출력

    if(su1 >= 10) System.out.println("10이상 입니다.");
    System.out.println("끝~!");

    scan.close();
  }
}
