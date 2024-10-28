package pm;

public class Main1 {
  public static void main(String[] args) {
    // 자식클래스 (인스턴스) 생성
    Child1 c1 = new Child1();
    c1.getData();

    // 자식클래스 (인스턴스) 생성 + 사용범위 한정
    Parent1 c2 = new Child1();
    c2.getData();

    // 부모클래스 (인스턴스) 생성 + 사용범위 한정
    Parent1 p1 = new Parent1();
    p1.getData();

    /*
     * 모든 클래스를 생성할 때는 Object 부터 생성시 선언한 클래스까지 묶인 인스턴스를 생성한다
     * 2차자료형 변수명 = 생성자 1차자료형
     * 1)Child1 c1 = new 2)Child1();
     * ( Object > Parent1 > Child1 ) 1) Child1 까지 사용 가능한 2) Child1 인스턴스 생성
     * 1)Parent1 c1 = new 2)Child1();
     * ( Object > Parent1 | > Child1 ) 1) Parent1 까지 사용 가능한 2) Child1 인스턴스 생성
     * 1)Object c1 = new 2)Child1();
     * ( Object | > Parent1 > Child1 ) 1) Parent1 까지 사용 가능한 2) Child1 인스턴스 생성
     */
  }
}
