package am3_Serial_IO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerialEx3 {
  public static void main(String[] args) throws Exception {
    // 저장할 음료 객체 생성
    DrinkVO d1 = new DrinkVO();
    d1.setName("Welchis");
    d1.setPrice(1000);

    DrinkVO d2 = new DrinkVO();
    d2.setName("Cydar");
    d2.setPrice(800);

    ArrayList<DrinkVO> list = new ArrayList<>();
    list.add(d1);
    list.add(d2);

    String path = "d:/code/obj_test.stm";

    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(path)));

    // 객체 쓰기
    oos.writeObject(list);
    oos.flush();
    oos.close();
  }
}
