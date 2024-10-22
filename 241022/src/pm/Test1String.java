package pm;

public class Test1String {
  public static void main(String[] args) {
    /*
     * - 스트링 객체의 중요한 특징
     * 
     * String 객체는 암시적/명시적 객체 생성 2가지의 생성방법을 가지며
     * 기존에 생성된 객체의 내용은 절대 바뀔수 없는 불변성을 가지고 있다.
     * JS식으로 설명하면 String 객체로 텍스트를 생성하면 const 로 생성된다.(내용 변경 불가능)
     * 
     * 암시적 객체(String msg1 = "test";) 생성을 하면 기존 메모리에 할당되어 있는 동일한 값을 가진 '객체'가 있는지 먼저
     * 검색하고, 해당 주소를 부여한다.
     * 명시적 객체(String msg2 = new String("test")) 생성을 하면 메모리에 무조건 객체를 생성하고 값을 입력한다.
     * 
     * 명시적 객체 생성으로 텍스트를 생성한 후 암시적 객체 생성을 하면 객체 생성 방법이 다르기 때문에 주소를 참조하지 않고 새로운 객체를
     * 생성한다.
     * 
     * 객체끼리 비교연산자를 사용시 주소값을 비교한다. (Obj == Obj)
     */

    String msg1 = "test"; // new 를 사용하지 않는 암시적 객체 생성
    String msg2 = new String("test"); // 명시적 객체 생성, unique
    String msg3 = new String("test"); // 명시적 객체 생성, unique
    String str = "test"; // new 를 사용하지 않는 암시적 객체 생성

    if (msg1 == msg2) { // 암시적 객체 생성 == 명시적 객체 생성 >> false
      System.out.println("msg1 과 msg2 는 주소가 같다");
    } else {
      System.out.println("msg1 과 msg2 는 주소가 다르다");
    }

    if (msg1.equals(msg2)) { // 암시적 객체 생성 == 명시적 객체 생성 >> false
      System.out.println("msg1 과 msg2 는 값이 같다");
    } else {
      System.out.println("msg1 과 msg2 는 값이 다르다");
    }

    if (msg2 == msg3) { // 명시적 객체 생성 == 명시적 객체 생성 >> false
      System.out.println("msg2 과 msg3 는 주소가 같다");
    } else {
      System.out.println("msg2 과 msg3 는 주소가 다르다");
    }

    if (msg2 == msg3) { // 명시적 객체 생성 == 명시적 객체 생성 >> false
      System.out.println("msg2 과 msg3 는 값이 같다");
    } else {
      System.out.println("msg2 과 msg3 는 값이 다르다");
    }

    /*
     * 암시적 객체 생성 == 암시적 객체 생성 >> true , 메모리를 먼저 검색 후,
     * 암시적으로 생성됬으면서 내용이 같은 String 객체의 주소를 참조한다.
     */
    if (msg1 == str) {
      System.out.println("msg1 과 str 는 주소가 같다");
    } else {
      System.out.println("msg1 과 str 는 주소가 다르다");
    }

    /*
     * concat 을 사용시 기존 String msg1 은 const(상수:불변)이기 때문에 새로운 객체를 생성하였으나,
     * 해당 주소지를 별도의 변수에 할당하지 못했다.
     */
    msg1.concat("123");
    System.out.println("concat한 주소를 다시 msg1 변수에 할당하지 않았을 때 msg1의 값은 " + msg1);

    /*
     * concat 을 사용시 기존 String msg1 은 const(상수:불변)이기 때문에 새로운 객체를 생성하였으며,
     * 이에 따라 msg1 에는 새로운 주소지가 할당되었다.
     */
    msg1 = msg1.concat("123");
    System.out.println("concat한 주소를 다시 msg1 변수에 할당했을 때 msg1의 값은 " + msg1);

    if (msg1 == str) {
      System.out.println("msg1 과 str 는 주소가 같다");
    } else {
      System.out.println("msg1 과 str 는 주소가 다르다");
    }

    String msg4 = "test";
    String msg5 = "test";
    if (msg4 == msg5) {
      System.out.println("msg4 과 msg5 는 주소가 같다");
    } else {
      System.out.println("msg4 과 msg5 는 주소가 다르다");
    }

    msg4 = msg4.concat("123");
    msg5 = msg5.concat("123");
    if (msg4 == msg5) {
      System.out.println("msg4 과 msg5 는 주소가 같다");
    } else {
      System.out.println("msg4 과 msg5 는 주소가 다르다");
    }
  }
}
