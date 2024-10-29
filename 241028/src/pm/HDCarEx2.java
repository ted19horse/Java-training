package pm;

public class HDCarEx2 extends CarEx2 {
  public void print() {
    System.out.println("HDCarEx2");
  }

  @Override
  public int DB(int i) {
    // TODO Auto-generated method stub
    int ni = super.DB(i) * 2;
    return ni;
  }
}
