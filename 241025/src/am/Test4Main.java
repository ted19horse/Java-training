package am;

public class Test4Main {
  public static void test(int n) {
    n++;
    System.out.println(n); // 101
  }

  public static void main(String[] args) {
    int value = 100;

    Test4Main.test(value); // CallByValue, 값을 복사하여 전달

    System.out.println(value); // 100
  }
}
