package am;

public class Test1For {
  public static void main(String[] args) {
    for (int i = 1; i <= 10; i++) {
      if (i < 10)
        System.out.printf("%d%s ", i, ",");
      else
        System.out.printf("%d", i);
    }
  }
}
