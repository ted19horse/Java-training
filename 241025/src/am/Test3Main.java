package am;

public class Test3Main {
  public static void main(String[] args) {
    int value = 100;

    /*
     * Test3CallBy라는 클래스 안에 있는 test 메서드 호출
     * 이 때 반드시 해당 클래스를 먼저 생성
     */

    /*
     * static 에서는 static 만 호출 가능하다고 했는데 클래스 생성을 하면 static 이 되는가?
     * CallByValue 는 기본자료형을 인자로 전달하며, 인자 전달 과정에서 값이 복사되므로 수정시 연관이 없다
     * CallByReferance 는 객체자료형을 인자로 전달하며, 인자 전달 과정에서 참조하는 주소를 전달하므로 수정시 원본도 수정된다
     */

    Test3CallBy t1 = new Test3CallBy();
    t1.test(value); // 101

    System.out.println(value);

    /*
     * 동일 클래스 내에 있을 때
     * static 내부에서 다른 변수나 메서드를 호출하려면 static 이어야만 가능하다.
     */

    test(value); // 호출시에 해당 메서드에 static 없으면 오류남

    System.out.println(nn); // 호출시에 해당 변수에 static 없으면 오류남
  }

  private static void test(int n) { // static 빼면 오류남
    n++;
    System.out.println(n);
  }

  private static int nn = 200; // static 빼면 오류남
}
