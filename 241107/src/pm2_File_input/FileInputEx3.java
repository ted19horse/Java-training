package pm2_File_input;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputEx3 {
  public static void main(String[] args) {
    // 파일의 경로
    String path = "d:/code/test.txt";

    // 준비된 경로를 가지고 File 객체를 생성하자!
    File f = new File(path);

    // 해당 경로의 파일이 실제 존재할 경우에만...
    // 스트림을 생성한다.
    if (f.exists()) {
      FileInputStream fis = null;
      try {
        fis = new FileInputStream(f);
        int data = -1;
        int count = 0; // 반복회차를 알기위한 변수

        // 연결된 파일로부터 읽기를 수행하는 반복문: 더 이상 읽을 것이 없으면 -1을 받는다.
        while ((data = fis.read()) != -1) {
          // System.out.printf("%c", data); // 한글 깨짐
          System.out.write(data); // Eclipse 는 안깨짐, vscode 는 깨짐
          count++;
        }

        System.out.println();
        System.out.println("count:" + count);
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        try {
          if (fis != null) {
            fis.close();
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
