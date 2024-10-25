package hw;

public class Array {
  public static void main(String[] args) {
    int[][] arr = new int[4][4];
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        if (i == j) {
          arr[i][j] = 1;
        }
        System.out.printf("%2d", arr[i][j]);
      }
      System.out.println();
    }

    /*
     * 오토박싱 : 기본자료형을 객체자료형에 넣을 때 자동으로 "객체화" 시켜줌
     * 언박싱 : 객체자료형을 기본자료형에 넣을 떄 자동으로 "변수화" 시켜줌
     */
    Integer i1 = new Integer(0);
    int i2 = 100;
    i1 = i2; // 오토박싱
    Integer i3 = new Integer(0);
    int i4 = 100;
    i4 = i3; // 언박싱
  }
}
