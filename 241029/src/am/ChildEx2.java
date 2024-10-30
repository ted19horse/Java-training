package am;

public class ChildEx2 extends ParentEx2 implements InterEx2 {

  @Override
  public void print() {
    System.out.println("ChildEx2 print");
  }

  @Override
  public void test() {
    System.out.println("ChildEx2 test");
  }
}
