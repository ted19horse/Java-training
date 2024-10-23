package pm;

public class BookVO {
  // 도서를 의미하는 클래스

  private String name; // def: null
  private String press;
  private String pos;
  private boolean rent; // def: false

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPress() {
    return press;
  }

  public void setPress(String press) {
    this.press = press;
  }

  public String getPos() {
    return pos;
  }

  public void setPos(String pos) {
    this.pos = pos;
  }

  public boolean isRent() {
    return rent;
  }

  public void setRent(boolean rent) {
    this.rent = rent;
  }
}
