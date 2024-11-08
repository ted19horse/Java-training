package am2_Buffered_Out;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class BufferedOutEx3 {
  public static void main(String[] args) {
    // 파일에 Buffered스트림을 이용하여 자원 쓰기를 하자!
    String path = "d:/code/abc.txt";

    File f = new File(path);

    if (!f.exists()) { // 파일이 존재하지 않을 경우는 return하여 프로그램 종료
      return;
    }

    BufferedOutputStream bos = null;
    Scanner scan = new Scanner(System.in);

    try {
      bos = new BufferedOutputStream(new FileOutputStream(f));

      // 키보드로부터 문자열을 받아서 저장하자!
      System.out.println("입력:");
      // String msg = scan.next(); // 키보드에서 아무거나 입력하기(단어, 스페이스 미포함)
      String msg = scan.nextLine(); // 키보드에서 아무거나 입력하기(단어, 스페이스 미포함)

      byte[] bar = msg.getBytes();

      bos.write(bar, 0, bar.length);
      bos.flush();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      scan.close();
      try {
        bos.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
