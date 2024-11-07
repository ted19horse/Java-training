package pm3_Buffered_input;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class BufferedInputEx4 {
  public static void main(String[] args) {
    // 파일경로
    String path = "d:/code/test.txt";

    // 위 경로로 파일객체 생성
    File f = new File(path);

    if (f.exists()) {
      // 실제 존재할 경우만 Stream을 만든다.
      BufferedInputStream bis = null;

      try {
        // 읽기를 하기 위한 Stream 준비
        // Buffered는 임시메모리 라는 뜻
        // 때문에 Buffered는 다른 InputStream에 비해 느리다.(다른 InputStream에 비해서는)
        // 그러나 Buffered를 쓰는 이유는 데이터 유실이 0이기 때문이다.
        bis = new BufferedInputStream(new FileInputStream(f));
        int data = -1;
        int count = 0;

        byte[] buf = new byte[4096]; // 바구니 역활

        // 다음 코드의 내용은
        // 읽은 자원은 buf라는 배열에 저장되며
        // data는 읽은 수를 저장한다.(count와 같은 역활)
        while ((data = bis.read(buf)) != -1) {
          System.out.write(buf, 0, data);
          count++;
        }
        System.out.println();
        System.out.println(count + "회 반복됨");
      } catch (Exception e) {
      } finally {
        try {
          if (bis != null) {
            bis.close();
          }
        } catch (Exception e) {
        }
      }
    }
  }
}
