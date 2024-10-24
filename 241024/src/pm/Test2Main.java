package pm;

public class Test2Main {
  public static void main(String[] args) {
    Test2Generic t1 = new Test2Generic(); // 인자가 없으면 "기본생성자(Default Generic)"
    t1.setName("John");
    t1.setAge(30);

    Test2Generic t2 = new Test2Generic();
    t2.setName("Jain");
    t2.setAge(22);

    /*
     * 생성자는 객체가 생성될 때 딱 한번 호출하여
     * 멤버변수들에 대한 초기화를 하면서
     * 메모리상에 객체가 생성되게 함
     * 
     * 만약 생성자를 정의하면 컴파일러에 의해 자동으로 만들어줬던 기본 생성자는
     * 더 이상 컴파일러가 만들어주지 않는다
     */

    // 만들어본 생성자를 이용하여 객체를 생성
    Test2Generic t3 = new Test2Generic("michale", 25);
    t3.setName("Kelly");
  }
}
