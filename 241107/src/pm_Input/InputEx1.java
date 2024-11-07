package pm_Input;

import java.io.IOException;
import java.io.InputStream;

public class InputEx1 {
  public static void main(String[] args) {
    // 키보드(System.in)와 연결된 스트림 얻기
    InputStream key = System.in;

    System.out.println("입력:");

    try {
      int code = key.read();
      System.out.println(code); // 키보드로부터 받은 값을 출력
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
