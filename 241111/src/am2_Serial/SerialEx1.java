package am2_Serial;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerialEx1 {
  public static void main(String[] args) throws FileNotFoundException, IOException {
    // 객체를 파일에 저장하기

    ArrayList<String> list = new ArrayList<>();
    list.add("대한민국");
    list.add("쌍용교육센터");

    String path = "d:/code/obj_test.stm";

    // 객체를 파일에 저장하기 위해 FileOutputStream과 ObjectOutputStream이
    // 연결되어 만들어져야 한다.

    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(path)));

    oos.writeObject(list); // 객체 쓰기
    oos.flush();
    oos.close();
  }
}
