package am;

public class Test4Pen {
  // 속성들
  String color = "검정";
  String comp = "모나미";
  int price = 2000;

  // 동작들
  public void setColor(String newColor) {
    this.color = newColor;
    // void method 라서 return 사용 불가
  }

  public String getColor() {
    return this.color;
    // getter method 는 return 하려는 값의 자료형과 같아야 함.
  }
}
