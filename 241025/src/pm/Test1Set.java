package pm;

import java.util.HashSet;
import java.util.Iterator;

public class Test1Set {
  public static void main(String[] args) {
    // 중복을 허용하지 않는 Set 구조
    HashSet<Integer> s = new HashSet<>();
    s.add(100);
    s.add(99);
    s.add(120);
    s.add(99);
    System.out.println(s.size()); // 3

    s.remove(99);
    System.out.println(s.size()); // 2

    s.add(200);
    System.out.println(s.size()); // 3

    /*
     * Set 구조는 인덱스가 없으므로 통 안의 물고기와 같다.
     * 만약! Set 구조의 요소들을 반복처리하기 위해서는 iterator(반복자)를 사용해야 한다
     * 먼저 Set 구조로부터 Iterator를 얻어낸다.
     */
    Iterator<Integer> it = s.iterator();
    while (it.hasNext()) {
      int n = it.next();
      System.out.println(n);
    } // hasNext()는 현재 커서(반복자)의 위치에서 바로 다음 요소에 자원이 있으면 true, 없으면 false
  }
}
