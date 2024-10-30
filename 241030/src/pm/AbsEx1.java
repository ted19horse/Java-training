package pm;

// abstract 가 붙으면 추상클래스가 된다. new 를 사용하여 객체를 새로 만들 수 없고, 상속(extends)만 가능하다.
abstract public class AbsEx1 {
  // 속성들...(변수,상수)
  String msg;
  // 변수 앞에 final 이 붙으면 상수로 선언된다
  // static 이 붙으면 같은 객체를 여러개 만들어도 하나의 값만 생성된다.
  final static int V100 = 100;

  // final 이 method 에 붙으면 재정의(OverRiding)가 불가능
  // final 이 Class 에 붙으면 상속(extends)이 불가능, 종단클래스 라고 부름
  public int getV100() {
    return 0;
  }

  // 비어있는 경우 EmptyMethod 라고 함
  public void test() {
  }

  // 추상메서드는 아래처럼 표현 가능
  // Interface 에는 상수와 추상메서드만 기재 가능하기 때문에 abstract 가 필요없음
  // Class 에는 추상메서드를 사용하려면 클래스명과 함수명 앞에 abstract 를 붙여야함
  abstract public void test1();
}
