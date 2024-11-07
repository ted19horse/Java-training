package pm_Input;

import java.io.IOException;
import java.io.InputStream;

public class InputEx2 {
  public static void main(String[] args) {
    // 키보드(System.in)와 연결된 스트림 얻기
    InputStream key = System.in;

    System.out.println("입력:");

    int i = 0;
    while (i < 4) {
      try {
        int code = key.read(); // key.read()를 사용하면 입력받은 문자를 순서대로 읽는다.
        System.out.println(code + ":" + (char) code);
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        i++;
      }
    }
    System.out.println("프로그램 끝!");
  }
}
