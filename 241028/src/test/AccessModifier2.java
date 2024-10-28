package test;

public class AccessModifier2 {

  @Override
  protected int DDB(int i) { // protected 접근제한자 이므로 동일 패키지이거나 자식이어야만 가능, 둘 다 아니므로 사용 불가능
    // TODO Auto-generated method stub
    return super.DDB(i);
  }
}
