package am;

public class Test2Car {
  /*
   * 자동차를 의미하는 클래스다.
   * 자동차의 많은 특징들 중 필요한 것만 변수로 정의하자
   */
  int speed; // 기본값은 0

  public void starting() {
    /*
     * speed가 0이면 1로 증가
     * 아니면 무조건 0으로 저장
     */
    if (speed == 0) {
      speed = 1;
    } else {
      speed = 0;
    }
  } // starting 함수의 끝
}
