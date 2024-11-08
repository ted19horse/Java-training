package am_File_Out;

import java.io.File;
import java.io.FileOutputStream;

public class FileOutEx2 {
  public static void main(String[] args) {
    // 파일에 저장할 문자열
    String str = "헬로월드";

    File f = new File("d:/code/abc.txt");

    FileOutputStream fos = null;

    try {
      fos = new FileOutputStream(f);
      // 준비된 OutputStream을 통해 쓰기 수행!
      // 먼저 저장할 문자열 객체를 byte[]로 변환한다.
      byte[] ar = str.getBytes();
      fos.write(ar, 0, ar.length); // 쓰기!
      fos.flush(); // OutputStream을 비우는 동작인데, 다르게 말하면
      // Stream에 있는 자원을 지금 당장 방출하라는 뜻
    } catch (Exception e) {
      e.getStackTrace();
      try {
        fos.close();
      } catch (Exception e2) {
      }
    }
  }
}
