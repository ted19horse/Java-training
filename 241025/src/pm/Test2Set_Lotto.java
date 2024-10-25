package pm;

import java.util.Iterator;
import java.util.TreeSet;

public class Test2Set_Lotto {
  public static void main(String[] args) {

    // HashSet<Integer> lotto = new HashSet<>(); // 기본적으로 정렬을 지원하지 않음
    TreeSet<Integer> lotto = new TreeSet<>(); // 기본적으로 오름차순 정렬을 지원

    int ran = (int) (Math.random() * 45 + 1);

    while (lotto.size() < 6) {
      lotto.add(ran);
      ran = (int) (Math.random() * 45 + 1);
    }
    System.out.println(lotto);

    // 반복문을 이용하려면 Iterator화 시켜서 반복처리 해야한다.
    Iterator<Integer> it = lotto.iterator();
    while (it.hasNext()) {
      int su = it.next();
      System.out.printf("%-3d", su);
    }
  }
}
