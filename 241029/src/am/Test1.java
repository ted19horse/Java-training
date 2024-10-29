package am;

public class Test1 implements InterEx1 {

  /*
   * 인터페이스를 오버라이딩 할 때는 접근제한자를 무조건 public 으로 해야한다.
   * default, protected, private 은 전부 오류남.
   * 반환형, 메서드명, 인자의 자료형과 수는 같아야 한다.
   */
  @Override // 어노테이션, 컴파일러가 오버라이딩이 제대로 되었는지 확인한다.
  public void print() {
    // TODO Auto-generated method stub
    System.out.println("재정의했어요!");
  }

}
