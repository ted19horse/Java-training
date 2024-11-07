package am_File;

import java.io.File;

public class FileEx1 {
  public static void main(String[] args) {
    // 자바에서 File객체는
    // 파일뿐만 아니라 폴더(디렉토리)를 객체화 시키는 클래스다.
    // 실제 존재하지 않아도 File객체로 생성이 가능하다.

    String path = "d:/Code"; // 원하는 폴더의 경로 준비

    File f = new File(path);

    // 생성된 파일객체가 파일인지? 디렉토리인지? 판단하자!

    if (f.isDirectory()) {
      System.out.println("폴더입니다.");

      // 하위에 있는 자식 요소들을 모두 배열로 얻어낼 수 있다.
      // File객체는 해당 요소가 폴더인지 파일인지 구분이 가능하다.
      File[] subFileArr = f.listFiles();
      for (File sfe : subFileArr) {
        if (!sfe.isDirectory()) {
          System.out.printf("\t-%s\r\n", sfe.getName());
        }
      }
      System.out.println("-------------------------------");

      // 하위에 있는 자식 요소들을 모두 배열로 얻어낼 수 있다.
      // 다만 String으로 파일명만 문자열로 가지므로 요소를 특정할 수 없다.
      String[] subStringArr = f.list();
      for (String sse : subStringArr) {
        System.out.printf("\t-%s\r\n", sse);
      }

    } else {
      System.out.println("파일입니다.");
    }

    if (f.exists()) {
      System.out.println("존재합니다.");
    } else {
      System.out.println("없습니다.");
    }
  }
}
