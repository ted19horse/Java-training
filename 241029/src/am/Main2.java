package am;

public class Main2 {
  public static void main(String[] args) {
    ChildEx2 t1 = new ChildEx2();

    Test2 t2 = new Test2();

    testM(t1);
    testM(t2);
  }

  public static void testM(InterEx2 n) {
    n.print();

    n.showData(); // 인스턴스 하위에 해당 메서드가 있지만 호출 불가

    if (n instanceof Test2) { // instanceof : n 의 인스턴스에 Test2가 있으면 true 반환, 강제형변환 가능
      Test2 tt = (Test2) n;
      tt.showData();
    }
  }
}
