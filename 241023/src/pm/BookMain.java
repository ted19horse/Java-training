package pm;

import java.util.Scanner;

public class BookMain {
  public static void main(String[] args) {
    // 도서관 객체 생성
    BookLibrary bl = new BookLibrary();
    bl.init();

    // 키보드로부터 검색할 도서명을 받기
    Scanner scan = new Scanner(System.in);
    System.out.println("검색할 도서명");
    String str = scan.nextLine(); // 한 줄 받기

    // 키보드로부터 입력받은 값(str)을 BookLibrary안에 있는 searchBook()이라는 함수를 호출할 때 인자로 전달
    String msg = bl.searchBook(str);
    System.out.println(msg);

    scan.close();
  }
}

// 사번 | 이름 | 직책 | 부서