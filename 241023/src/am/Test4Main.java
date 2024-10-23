package am;

public class Test4Main {
  public static void main(String[] args) {
    // 다른 클래스의 메서드를 호출하려면 해당 클래스를 호출해야 한다.
    // 클래스이름 변수이름 = new 호출
    Test4Pen pen = new Test4Pen();

    String penColor;

    penColor = pen.getColor();
    System.out.println(penColor);

    pen.setColor("빨강");

    penColor = pen.getColor();
    System.out.println(penColor);

    penColor = pen.color; // 직접 접근
    penColor = pen.getColor(); // 메서드를 통한 접근

    /*
     * 메서드를 통한 접근에는 동기화를 설정하여 데이터 호출 순서를 정할 수 있지만
     * 클래스 변수를 직접 호출하는 경우에는 동기화 설정이 불가능하다.
     */

    Test4Pen b = new Test4Pen();
    String c2 = b.getColor();
    System.out.println(c2); // 검정

    b.setColor("파랑");
    c2 = b.getColor();
    System.out.println(c2); // 검정

    c2 = pen.getColor();
    System.out.println(c2); // 빨강
  }
}
