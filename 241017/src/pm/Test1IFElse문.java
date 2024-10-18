package pm;

public class Test1IFElse문 {
  public static void main(String[] args) {
    // 난수 발생
    // double d1 = Math.random(); // 0.0~0.9999999 중의 난수 받기

    // 1부터 100까지의 수들 중의 값으로 변환하자
    // int ran = (int) (d1 * 100 + 1);

    // Math.random()*범위+시작수
    int ran = (int) (Math.random() * 100 + 1);
    System.out.println(ran);

    // ran의 값이 60 이상이면 "합격", 아니면 "불합격"
    if (ran >= 60) {
      System.err.println("합격");
    } else {
      System.out.println("불합격");
    } // if문의 끝
  }
}
