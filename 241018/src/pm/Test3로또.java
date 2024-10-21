package pm;

public class Test3로또 {
  public static void main(String[] args) {
    // 로또 배열 선언
    int lotto[] = new int[6];

    // 변수 초기화
    String msg = "";
    boolean chk = true;

    System.out.println("Rolling Start");

    for (int i = 0; i < lotto.length;) { // 로또번호 입력을 위한 반복문
      lotto[i] = (int) (Math.random() * 45 + 1); // 난수 발생
      chk = true;
      msg = "No." + i + " num: " + lotto[i];
      System.out.println(msg);

      for (int j = 0; j < i; j++) { // 로또번호 중복확인을 위한 반복문
        // i = 0 일 때 j(0) < i(0) 성립이 되지 않으므로 자동으로 체크를 하지 않음
        if (lotto[i] == lotto[j]) { // 이전 값이 난수와 같으면 난수 발생으로 돌아가기
          msg = lotto[i] + " same as No." + j + " " + lotto[i] + ", Reroll";
          System.out.println(msg);
          chk = false;
          break;
        }
      }

      if (chk)
        i++;
    }

    msg = "당첨번호는 ";
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
