package am;

public class Test2For {
  public static void main(String[] args) {
    // 1~10 반복문 완성
    // 3의 배수는 출력 안함
    for (int i = 1; i <= 10; i++) {
      if (i % 3 != 0 && i < 10)
        System.out.printf("%d%s ", i, ", ");
      else if (i == 10)
        System.out.print(i);
    }
  }
}
