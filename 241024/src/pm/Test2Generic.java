package pm;

public class Test2Generic {
  // 멤버변수
  private String name;
  private int age;

  /*
   * 생성자 정의 (이름과 나이를 모두 받아서 저장)
   * 생성자는 반환형을 명시하지 않고
   * 생성자의 이름은 반드시 클래스명과 동일해야 함!
   */
  public Test2Generic(String n, int a) {
    this.name = n;
    this.age = a;
  }

  public Test2Generic() {
  } // 기본생성자

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
