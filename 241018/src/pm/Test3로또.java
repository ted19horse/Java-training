package pm;

public class Test3로또 {
  public static void main(String[] args) {
    // 로또 배열 선언
    int lotto[] = new int[6];

    // 번호 초기화
    int num = 0;

    System.out.println("Rolling Start");

    for (int i = 0; i < lotto.length; i++) {
      // 난수 발생
      num = (int) (Math.random() * 45 + 1);
      System.out.println(i + "번째 난수는 " + num);

      // 첫번째는 바로 난수 넣기
      if (i == 0) {
        lotto[i] = num;
      } else {
        // 두번째부터 이전 값 검사
        for (int j = 0; j < i; j++) {
          if (lotto[j] == num) { // 이전 값이 난수와 같으면
            System.out.println(j + "번째 값이 현재 난수와 같음..리롤");
            num = (int) (Math.random() * 45 + 1);
            j--;
          }
        }
        // 이전의 값이 전부 문제 없으면 값 입력
        lotto[i] = num;
        System.out.println(i + "번째 값은 " + num);
      }
    }

    String msg = "당첨번호는 ";
    for (int fi = 0; fi < lotto.length; fi++) {
      msg += lotto[fi];
      if (fi < lotto.length - 1)
        msg += ", ";
    }
    System.out.print(msg);

    // 증감식을 없애면 원하는 시점에서 다음으로 넘어갈 수 있다.
    // 흠..한번 해보긴 했는데 조금 위험할 듯..
    for (int i = 0; i < lotto.length;) {
      if (true)
        i++;
    }
  }
}
