package pm;

public class Test2배열 {
  public static void main(String[] args) {
    // 정수형 값을 10개 저장하는 배열을 생성
    int ar[] = new int[10];
    for (int i = 0; i < ar.length; i++) {
      if (i % 2 == 1)
        ar[i] = i;
      System.out.printf("%d ", ar[i]);
    }
  }
}
