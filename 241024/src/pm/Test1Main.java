package pm;

public class Test1Main {
  public static void main(String[] args) {
    Test1Generic<String> t1 = new Test1Generic<String>();
    t1.setValue("SIST");
    System.out.println(t1.getValue()); // SIST

    Test1Generic<Integer> t2 = new Test1Generic<Integer>();
    t2.setValue(2000000);
  }
}
