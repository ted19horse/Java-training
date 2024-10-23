package pm;

public class BookLibrary {
  // 도서관을 의미하는 클래스
  // 이 도서관은 5개의 도서를 가진다.
  BookVO[] ar = new BookVO[5];

  // 도서객체(BookVO)를 5개 저장할 수 있는 공간
  // BookVO 5개가 만들어진 것은 아니다.

  // 책을 생성하여 배열에 저장하는 동작
  public void init() {
    BookVO b1 = new BookVO();
    b1.setName("이것이 자바다");
    b1.setPress("한빛미디어");
    b1.setPos("A-102");
    b1.setRent(false);

    BookVO b2 = new BookVO();
    b2.setName("UML 기초와 응용");
    b2.setPress("한빛아카데미");
    b2.setPos("A-100");
    b2.setRent(false);

    BookVO b3 = new BookVO();
    b3.setName("자바바이블");
    b3.setPress("한빛아카데미");
    b3.setPos("A-2");
    b3.setRent(true);

    BookVO b4 = new BookVO();
    b4.setName("이것이 우분투 리눅스다.");
    b4.setPress("한빛아카데미");
    b4.setPos("C-222");
    b4.setRent(true);

    BookVO b5 = new BookVO();
    b5.setName("스프링부트");
    b5.setPress("두빛아카데미");
    b5.setPos("D-122");
    b5.setRent(false);

    // 생성된 BookVO 객체들을 이대로 두면 현재 함수를 벗어남과 동시에 모두 소멸됨
    // 소멸되지 않도록 멤버변수(속성)인 배열에 저장하자.
    ar[0] = b1;
    ar[1] = b2;
    ar[2] = b3;
    ar[3] = b4;
    ar[4] = b5;
  }

  /*
   * 인자로 단어를 받아서 검색하는 동작(반환값은 개발자가 지정).
   * 이름 | 출판사 | 위치 | 대여가능여부\r\n
   * 이름 | 출판사 | 위치 | 대여가능여부
   */

  public String searchBook(String kwd) {
    // BookVO 내의 값을 얻어 결과지를 만드려면 StringBuffer가 필요
    StringBuffer sb = new StringBuffer();

    // param n이 포함된 도서들을 검색하기 위한 반복문이 필요
    for (int i = 0; i < ar.length; i++) {
      // 배열에 있는 도서객체들 중 하나를 가져온다.
      BookVO b = ar[i];

      // 도서명에 n의 값이 있는지? 판단하자!
      // int idx = b.getName().indexOf(n); // idx != -1 이면 검색되었음
      if (b.getName().contains(kwd)) {
        // 도서명이 n을 포함하면 true 이므로 StringBuffer 에 적재한다.
        sb.append(b.getName());
        sb.append(" | ");
        sb.append(b.getPress());
        sb.append(" | ");
        sb.append(b.getPos());
        sb.append(" | ");
        if (b.isRent()) {
          sb.append("대여중");
        } else {
          sb.append("대여가능");
        }

        sb.append("\r\n");
      }
    }

    return sb.toString();
  }
}
