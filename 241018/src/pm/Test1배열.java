package pm;

public class Test1배열 {
  public static void main(String[] args) {
    // 문자 4개를 저장하는 배열 생성
    char[] ar1 = new char[4];
    // System.err.println(ar1[0]);

    // ar1[0] = 'A';
    // ar1[1] = 'B';
    // ar1[2] = 'C';
    // ar1[3] = 'D';

    for (int i = 0; i < ar1.length; i++) {
      ar1[i] = (char) (i + 65);
      System.out.print(ar1[i]);
      // printf 를 사용할 경우 char 형태는 %c
    }

    // 선언 할 때는 값 없이 가능
    char[] ar2;
    // 선언 후 초기화 할 때 길이만 입력도 가능
    ar2 = new char[4];
    // 선언 후 초기화 할 때 데이터 입력도 가능 - new 타입[] {목록}
    ar2 = new char[] { 'A', 'B', 'C', 'D' };
    // 선언 시 초기화 할 때는 바로 입력 가능
    char[] ar3 = { 'A', 'B', 'C', 'D' };

    System.out.print(ar2);
    System.out.print(ar3);
  }
}
