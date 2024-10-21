package am;

public class Test4For {
  public static void main(String[] args) {
    // 구구단 2~9 중 난수 하나 발생시켜서
    // 해당 난수의 구구단을 출력
    // ex 3
    // 3단
    // -----
    // 3*1=3
    // 3*2=6
    // 3*3=9
    // 3*4=12
    // 3*5=15
    // 3*6=18
    // 3*7=21
    // 3*8=24
    // 3*9=27

    int ran = (int) (Math.random() * 8 + 2);
    String title = ran + "단";
    System.out.println(title);
    System.err.println("-----");
    for (int i = 1; i < 10; i++) {
      // String Tmsg = ran + "x" + i + "=" + (ran * i);
      // System.out.println(Tmsg);
      System.out.printf("%d*%d=%d \r\n", ran, i, (ran * i));
    }
  }
}
