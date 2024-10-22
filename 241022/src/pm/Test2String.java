package pm;

public class Test2String {
  public static void main(String[] args) {
    String s1 = "Test Java Example";

    // s1이 가르키는 객체의 내용에서 소문자 a를 모두 찾아 "*"로 변경
    String s2 = s1.replaceAll("a", "*");
    System.out.println(s1);
    System.out.println(s2);

    System.out.println("----- substring연습 -----");

    String s3 = s1.substring(5); // Java Example
    System.out.println(s3);

    /*
     * 문제
     * s1에서 대문자 J를 찾아서 인덱스 값을 추출 후 해당 위치부터 끝까지 문자열을 추출하여 출력하시오
     */

    int index = s1.indexOf("J");
    String s4 = s1.substring(index);
    System.out.println(s4);

    // 문자열에서 "Java" 만 추출
    String s5 = s1.substring(index, index + 4);
    System.out.println(s5);
  }
}
