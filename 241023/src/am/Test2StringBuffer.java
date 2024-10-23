package am;

public class Test2StringBuffer {
  public static void main(String[] args) {
    // 문자열 편집이 가능한 StringBuffer 객체 생성
    StringBuffer sb1 = new StringBuffer("JAVA");
    StringBuffer sb2 = sb1;

    if (sb1 == sb2) {
      System.out.println("sb1랑 sb2는 주소가 같다");
    } else {
      System.out.println("sb1랑 sb2는 주소가 다르다");
    }

    // sb1을 수정해도 같은 주소일까
    sb1.append(" Programming");
    System.out.println(sb2); // Java Programming

    // sb2의 index 0~2 의 텍스트를 삭제
    sb2.delete(0, 3);
    System.out.println(sb1);

    // 특정 인덱스에 "-"를 추가
    sb1.insert(2, "-");
    System.out.println(sb2);

    // 버퍼가 가지고 있는 문자열을 String 으로 변환하여 반환한다.
    String str = sb1.toString();
    System.out.println(str);
  }
}
