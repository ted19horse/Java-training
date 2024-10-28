package tstyle;

public class Baseball {
  int[] com;
  int[] user;

  public void setUser(int[] user) {
    // 배열은 객체이므로, CallByReferance 가 적용되어 주소값만 전달된다.
    this.user = user;
  }

  /*
   * 생성자 기본 특성
   * 접근제한자는 되도록 public
   * 반환형을 아예 쓰지 않으며
   * 이름은 반드시 클래스명과 동일하게
   */
  public Baseball() {
    com = new int[3];
    user = new int[3];

    initCom();
  } // 생성자의 끝

  // com배열 초기화
  public void initCom() {
    for (int i = 0; i < com.length;) {
      // 난수 1 발생
      com[i] = (int) (Math.random() * 9 + 1);

      // 중복값 체크, 중복이 있으면 true로 변경
      boolean chk = false;

      // 중복체크
      for (int j = 0; j < i; j++) {
        if (com[i] == com[j]) {
          // 중복값이 난수면
          chk = true;
          break; // 가까운 반복문 탈출
        }
      }

      // 현재 중복값이 아닐때
      if (!chk) {
        ++i;
      }
    }
  }

  /*
   * 같은 자리에 같은 값을 가진 경우를 우린 Strike로 지정
   * 이게 몇개나 있는지 알아내는 기능
   */
  public int strikeCount() {
    int count = 0;

    for (int i = 0; i < com.length; i++) {
      // com배열과 user배열간에 같은 자리에 같은 값이 있으면 count 증가
      if (com[i] == user[i]) {
        count++;
      }
    }
    return count;
  }

  /*
   * com 배열과 user배열간의 서로 다른 자리의 값들 중
   * 같은 값이 존재하는지 판단하고 count
   */
  public int ballCount() {
    int count = 0;

    for (int i = 0; i < com.length; i++) {
      // i보다 1칸 뒤 비교
      if (com[i] == user[(i + 1) % com.length]) {
        count++;
      }
      // i보다 2칸 뒤 비교
      if (com[i] == user[(i + 2) % com.length]) {
        count++;
      }
    }

    return count;
  }
}
