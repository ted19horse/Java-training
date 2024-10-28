package pm;

public class CarEx2 {
  // 자동차를 의미하는 클래스
  String model; // 모델명
  int price; // 가격
  String maker; // 제조사

  // 모델명 변경하는 기능
  public void setModel(String model) {
    this.model = model;
    System.out.println("모델변경수행, " + model);
  }

  public void print() {
    System.out.println("CarEx2");
  }

  public int DB(int i) {
    int ni = i * 2;
    return ni;
  }

  protected int DDB(int i) {
    int ni = i * 4;
    return ni;
  }
}
