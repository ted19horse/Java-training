package am;

public class Test3Wrapper {
  public static void main(String[] args) {
    // 문자형 변수를 선언하자
    char ch = 'K';
    // Character c1 = new Character(ch); // Old Version , 명시적
    Character c2 = ch; // Recent Version - Auto Boxing , 암시적
    Character c3 = ch;
    if (c2 == c3) {
      System.out.println("c2 == c3");
    } else {
      System.out.println("c2 != c3");
    }

    int i = 100;
    // Integer i1 = new Integer(i); // O.V , 명시적
    Integer i2 = i; // R.V - Auto Boxing , 암시적
    Integer i3 = i;
    if (i2 == i3) {
      System.out.println("i2 == i3");
    } else {
      System.out.println("i2 != i3");
    }

    double d = 0.12;
    Double d1 = d; // 객체화, Auto Boxing, 암시적

    // 반대로 객체화 된 변수를 기본자료형으로 변환이 가능하다.
    double dd = d1; // 변수화, Unboxing
    System.out.println(dd);
  }
}
