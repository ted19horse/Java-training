package am_File_Out;

import java.io.File;
import java.io.FileOutputStream;

public class FileOutEx1 {
  public static void main(String[] args) {
    // 파일에 저장하기 위해 파일의 경로로 File객체를 준비하자!
    File f = new File("d:/code/abc.txt");
    FileOutputStream fos = null;

    try {
      fos = new FileOutputStream(f);
      // 스트림 생성시 파일이 무조건 만들어짐
      // 같은 파일이 있다면 rewrite됌
    } catch (Exception e) {
      e.printStackTrace();
      try {
        fos.close();
      } catch (Exception e1) {
        e1.printStackTrace();
      }
    }
  }
}
