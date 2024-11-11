package am2_Serial;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class SerialEx2 {
  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws Exception {
    // 이전의 예제에서 객체 쓰기할 것을 읽어와서 표현하자.

    String path = "d:/code/obj_test.stm";

    // 객체를 읽기할 스트림을 만들자
    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(path)));
    Object obj = ois.readObject();
    if (obj instanceof ArrayList) {
      ArrayList<String> list = (ArrayList<String>) obj;

      for (String str : list) {
        System.out.printf("%s\r\n", str);
      }
    }
    if (ois != null) {
      ois.close();
    }
  }
}
