package pm;

public class Test2DoWhile {
  public static void main(String[] args) {
    int i = 0;
    // int i = 20;
    int sum = 0;
    do {
      sum += i;
      System.out.printf("%-2d", i++);
    } while (i <= 10);
    System.out.println();
    System.out.print(sum);
  }
}
