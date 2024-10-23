package pm;

import java.util.Scanner;

public class EmpMain {
  public static void main(String[] args) {
    // 클래스 호출
    EmpMonitor empMon = new EmpMonitor();

    // 초기화 메서드 실행
    empMon.init();

    // 스캐너 입력값 만들기
    System.out.println("사원명으로 검색하기");
    Scanner scan = new Scanner(System.in);
    String kwd = scan.nextLine();

    // 결과값 출력
    String result = empMon.searchEmp(kwd);
    System.out.println(result);

    scan.close();
  }
}
