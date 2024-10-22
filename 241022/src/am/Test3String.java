package am;

public class Test3String {
  public static void main(String[] args) {
    // 문자열 객체 생성
    // char[] strar = {'H','e','l','l','o'};
    // String str = new String(strar);
    String s1 = "sist";

    // s1에서 소문자 "s"가 있는지? 알아보자
    int idx = s1.indexOf("s");
    System.out.println("idx:" + idx);

    // s1에서 소문자 "s"를 뒤에서부터 찾아보자
    idx = s1.lastIndexOf("s");
    System.out.println("idx:" + idx);

    // 없는 문자를 검색하면 -1이 나옴
    idx = s1.lastIndexOf("A");
    System.out.println("idx:" + idx);

    char ch = s1.charAt(1);
    System.out.println("s1.charAt(1):" + ch);
  }
}
