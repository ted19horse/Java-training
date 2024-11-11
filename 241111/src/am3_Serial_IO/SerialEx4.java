package am3_Serial_IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class SerialEx4 {
  public static void main(String[] args) throws Exception {
    // 이전의 예제에서 객체 쓰기할 것을 읽어와서 표현하자.

    String path = "d:/code/obj_test.stm";

    // 객체를 읽기할 스트림을 만들자
    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(path)));
    Object obj = ois.readObject();
    if (obj instanceof ArrayList) {
      @SuppressWarnings("unchecked")
      ArrayList<DrinkVO> list = (ArrayList<DrinkVO>) obj;

      for (DrinkVO drink : list) {
        System.out.printf("이름:%s 가격:%-4d\r\n", drink.getName(), drink.getPrice());
      }
    }
    if (ois != null) {
      ois.close();
    }
  }
}
