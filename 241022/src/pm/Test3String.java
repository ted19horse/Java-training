package pm;

public class Test3String {
  public static void main(String[] args) {
    String s1 = "  Java Test   ";
    // 문자열의 길이는 공백을 포함
    int size = s1.length();
    System.out.println(size);

    // trim()을 사용하면 선/후행 공백을 제거
    String s2 = s1.trim();
    System.out.println(s2);

    // s1에서 문자 "a"의 index 값을 구하자
    int index = s1.indexOf("a");
    System.out.println(index);

    // s1에서 문자 "a"의 두번째부터 index 값을 구하자
    index = s1.indexOf("a", index + 1);
    System.out.println(index);

    System.out.println("--- 문자열로 변환 ---");
    int n = 100;
    // 위의 정수 n의 값이 뭔지 모르지만 몇 자리의 정수값인지
    String str = String.valueOf(n); // "100"
    System.out.println("str의 자릿수는 " + str.length());

    /*
     * valueOf 는 JVM에서 바로 사용하도록 static 으로 생성되어 있음.
     * valueOf(param) 에서 param 이 어떤 type 이던 간에 전부 String 으로 변경함.
     * 해당 기법을 Overloading(중복적용) 이라고 함.
     */
  }
}
