package am;

public class Test1StringBuffer {
  public static void main(String[] args) {

    String s1 = new String("Test");

    StringBuffer sb = new StringBuffer(s1);

    // 문자열 s1을 가지고 문자열을 수정하자
    String s2 = s1.concat("123");
    System.out.println("s1:" + s1); // Test
    System.out.println("s2:" + s2); // Test123

    // 같은 작업을 sb에 해보자.
    StringBuffer sb2 = sb.append("123");
    System.out.println("sb:" + sb); // Test123
    System.out.println("sb2:" + sb2); // Test123

    if (sb == sb2) {
      System.out.println("sb랑 sb2는 주소가 같다");
    } else {
      System.out.println("sb랑 sb2는 주소가 다르다");
    }
  }
}
