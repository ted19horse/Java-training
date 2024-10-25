package am;

public class Test3CallBy {
  // 정수를 인자로 받아서 증가한 후 출력하는 동작
  public void test(int n) {
    ++n; // 받은 인자값을 1 증가
    System.out.println(n);
  }
}
