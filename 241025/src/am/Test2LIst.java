package am;

import java.util.ArrayList;

public class Test2LIst {
  public static void main(String[] args) {
    // List structure
    ArrayList<Integer> al = new ArrayList<>(3); // 기본 길이가 3인 배열을 생성

    // 현재 List 구조의 사이즈를 얻어내자
    System.out.println(al.size());

    int size = al.size();
    System.out.println(size); // 0

    al.add(100);
    size = al.size();
    System.out.println(size); // 1

    for (int i = 1; i < 11; i++) {
      al.add(i);
    }
    size = al.size();
    System.out.println(size); // 11

    for (int i = 0; i < al.size(); i++) {
      int val = al.get(i);
      System.out.printf("%-4d", val);
    }
    System.out.println();

    al.remove(1); // ArrayList[i] 를 없애는 것과 같다.
    for (int i = 0; i < al.size(); i++) {
      int val = al.get(i);
      System.out.printf("%-4d", val);
    }
    System.out.println();

    al.add(3, 400);
    for (int i = 0; i < al.size(); i++) {
      int val = al.get(i);
      System.out.printf("%-4d", val);
    }
    System.out.println();

    // 특정 객체가 ArrayList에 포함되어 있는지? 검사하는 함수
    boolean chk = al.contains(99); // false
    System.out.println(chk);

    // 특정 객체가 ArrayList에 포함되어 있는지? 검사하는 함수
    chk = al.contains(400); // true
    System.out.println(chk);

    int index = al.indexOf(400);
    if (index != -1) {
      al.remove(index);
    }
    for (int i = 0; i < al.size(); i++) {
      int val = al.get(i);
      System.out.printf("%-4d", val);
    }
    System.out.println();

    al.clear(); // 모두 삭제
    System.out.println(al.size());

    /*
     * List 구조에서 알아야 될 함수들
     * add : 추가
     * get : 추출
     * remove : 삭제
     * size : 용량
     * clear : 초기화
     * contains : 존재 확인
     * isEmpty : 비었는지 확인
     */

    /*
     * List 구조에서 자료형을 같은 패키지 내의 클래스로 지정할 수 있다.
     * 다만 Test1Gen<D>처럼 제네릭 타입을 사용하는 클래스는
     * 제네릭 타입을 지정할 경우 해당 타입의 데이터만 사용이 가능하고
     * 제네릭 타입을 지정 안하면 모든 타입의 데이터를 사용 가능하다.
     */

    /*
     * Test1Gen<String> t1 = new Test1Gen<String>();
     * Test1Gen<Long> t2 = new Test1Gen<>();
     * Test1Gen<Float> t3 = new Test1Gen<>();
     */

    // 자료형 미설정 > 모든 자료형 입력 가능
    /*
     * ArrayList<Test1Gen> ar1 = new ArrayList<>();
     * ar1.add(t1);
     * ar1.add(t2);
     * ar1.add(t3);
     */

    // 자료형 설정 > 특정 자료형만 사용 가능
    /*
     * ArrayList<Test1Gen<String>> ar2 = new ArrayList<>();
     * ar2.add(t1);
     * ar2.add(t2);
     * ar2.add(t3);
     */
  }
}
