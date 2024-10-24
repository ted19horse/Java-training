package homework;

import java.util.Scanner;

public class EmpMain {
  public static void main(String[] args) {
    // 클래스 호출
    EmpCompany empMon = new EmpCompany();

    // 초기화 메서드 실행
    empMon.init();

    // 스캐너 입력값 만들기
    Scanner scan = new Scanner(System.in);

    System.out.println("선택:");
    System.out.println("사번검색:1, 이름검색:2, 직책검색:3, 부서검색:4");
    int cmd = scan.nextInt();

    switch (cmd) {
      case 1: // 사번검색
        System.out.println("검색할 사번:");
        break;
      case 2: // 이름검색
        System.out.println("검색할 사원:");
        break;
      case 3: // 직책검색
        System.out.println("검색할 직책:");
        break;
      case 4: // 부서검색
        System.out.println("검색할 부서:");
        break;
      default: // 예외처리
        System.out.println("지원하지 않는 코드입니다. " + cmd);
        scan.close();
        return;
    }

    String kwd = scan.next();

    // 결과값 출력
    String msg = empMon.searchEmp(cmd, kwd);
    System.out.println(msg);

    scan.close();
  }
}
