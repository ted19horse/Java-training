package pm;

public class Test1While {
  public static void main(String[] args) {
    int i = 0;
    int sum = 0;
    while (i <= 10) {
      sum += i;
      System.out.printf("%-2d", i++);
    }
    System.out.println();
    System.out.print(sum);
  }
}
