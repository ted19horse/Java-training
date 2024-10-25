package am;

import java.util.ArrayList;

public class Test5Main {
  // public static void test(ArrayList<Integer> n) {
  public void test(ArrayList<Integer> n) {
    n.add(202);
    n.add(200);
  }

  // Varargs 개념(가변길이 매개변수?)
  public void test2(int... n) {
    System.out.println("Varargs개념의 지역변수(n)는 배열개념이 된다.");
    System.out.println("Argument length:" + n.length);

    for (int i = 0; i < n.length; i++) {
      System.out.println(n[i]);
    }
  }
  // Method OverLoading 기법, 같은 이름의 메서드가 매개변수의 타입, 개수, 순서에 따라 다르게 선언 가능
  /*
   * public void test2(int n, int n2) {
   * System.out.println(++n);
   * System.out.println(++n2);
   * }
   */

  public static void main(String[] args) {
    ArrayList<Integer> al = new ArrayList<>();

    al.add(404);

    System.out.println(al.size()); // 1

    // Test5Main.test(al); // CallByReferance, 주소를 복사하여 전달
    Test5Main t = new Test5Main();
    t.test(al); // static이 아니면 클래스를 생성해야 사용 가능

    System.out.println(al.size()); // 3

    t.test2(10);
    t.test2(1, 10, 100);
  }
}
