package pm;

public class MainEx1 {
  public static void main(String[] args) {
    // AbsEx1 ex1 = new AbsEx1();
    /*
     * 추상클래스는 직접 인스턴스를 생성할 수 없다.
     * 추상클래스를 사용하기 위해서는 자식클래스를 생성한 후 상속하여야만 사용이 가능하다.
     */
    // 같은 인스턴스 내 상위 자료형으로 변경 가능
    AbsEx1Child ex1 = new AbsEx1Child();
    AbsEx1 ex2 = new AbsEx1Child();

    ex1.test1();
    ex2.test1();
  }
}
