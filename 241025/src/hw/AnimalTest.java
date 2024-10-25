package hw;

public class AnimalTest {
  public static void main(String[] args) {
    Animal a1 = new Animal();
    a1.setName("큰뿔소");
    a1.setAge(3);
    a1.setLive(true);

    System.out.println(a1.getName());
    if (a1.isLive()) {
      System.out.println("생존");
    } else {
      System.out.println("사망");
    }

    a1.setName("펭귄");
    System.out.println(a1.getName());
    if (a1.isLive()) {
      System.out.println("생존");
    } else {
      System.out.println("사망");
    }
  }
}
