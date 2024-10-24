package pm;

public class Test1Generic<Type> { // 클래스 설계단계에서 <> 꺾쇠 안에는 Type이든, Key든, Source든, 원하는 이름으로 인자를 설정 가능
  Type value;

  public Type getValue() {
    return value;
  }

  public void setValue(Type value) {
    this.value = value;
  }

}
