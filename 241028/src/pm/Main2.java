package pm;

public class Main2 {
  public static void main(String[] args) {
    HDCarEx2 car1 = new HDCarEx2(); // Heap 에 새로운 객체 생성

    KIACarEx2 car2 = new KIACarEx2(); // Heap 에 새로운 객체 생성

    CarEx2 car3 = new CarEx2(); // Heap 에 새로운 객체 생성

    // test 함수 호출
    test(car1, "현대"); // print에서 HDCarEx2
    test(car2, "기아"); // print에서 KIACarEx2
    test(car3, "자동차"); // print에서 CarEx2

    test1(car1, 1); // HDCarEx2, DB가 OverRiding되서 4가 나옴.
    test1(car3, 1); // CarEx2, DB가 OverRiding안되서 2가 나옴.
  }

  public static void test(CarEx2 n, String m) {
    n.setModel(m);
    n.print();
  }

  public static void test1(CarEx2 n, int i) {
    int ni = n.DB(i);
    System.out.println(ni);
  }

  /*
   * 클래스별로 동일한 부모를 가질 경우
   * 메서드의 인자로 받을 객체자료형을 부모자료형으로 지정하면
   * 메서드를 호출할 때 제공하는 인자의 객체자료형이 자식이더라도 사용이 가능하다.
   * 
   * -->
   * 
   * 메서드의 인자로 전달할 때 2차자료형이 변하기 때문에 사용이 가능하다.
   * 2차자료형 변수명 = new 1차자료형;
   * HDCarEx2 car1 = new HDCarEx2();
   * KIACarEx2 car2 = new KIACarEx2();
   * 
   * -->
   * 
   * 메서드에 인자로 전달할 때 2차자료형을 부모의 자료형으로 범위제한을 변경하여 전달할 수 있다.
   * public static void test(CarEx2 n) {}
   * 
   * -->
   * 
   * 범위(2차자료형)을 부모로 제한하였어도 생성(1차자료형)을 자식으로 했을때,
   * 오버라이딩(다형성, 재정의) 된 메서드가 있다면 자식의 메서드를 호출한다.
   */
}
