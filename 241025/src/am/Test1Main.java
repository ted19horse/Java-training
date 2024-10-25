package am;

public class Test1Main {
  public static void main(String[] args) {
    // 원하는 클래스(Test1Gen)를 생성하자
    Test1Gen<String> t1 = new Test1Gen<String>();
    t1.setValue("SIST");
    System.out.println(t1.getValue());

    // 때에 따라 같은 클래스로 다른 자료형을 저장할 때가 있다.
    // Generic Type 을 쓸 떄는 객체자료형을 써야 한다.
    Test1Gen<Long> t2 = new Test1Gen<>();
    t2.setValue(2100000L);
    System.out.println(t2.getValue());

    Test1Gen<Float> t3 = new Test1Gen<>();
    t3.setValue(3.14F);
    System.out.println(t3.getValue());
  }
}
