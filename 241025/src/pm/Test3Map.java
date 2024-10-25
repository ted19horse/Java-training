package pm;

import java.util.HashMap;

public class Test3Map {
  public static void main(String[] args) {
    // Map 구조: 키 = 값 을 하나의 쌍으로 저장하는 구조
    HashMap<Integer, String> map = new HashMap<>();

    String s1 = "쌍용교육센터";
    String s2 = "STIT";
    String s3 = "STIT";

    map.put(100, s1);
    map.put(200, s2);
    map.put(100, s3);

    System.out.println(map);
    System.out.println(map.size());

    // Map구조로부터 데이터 검출시에는 키 값을 알고 있어야 한다.
    String n1 = map.get(100);
    System.out.println("100:" + n1);

    String n2 = map.get(200);
    System.out.println("200:" + n2);

    if (n1 == n2) {
      System.out.println("n1 == n2");
    } else {
      System.out.println("n1 != n2");
    }
  }
}
