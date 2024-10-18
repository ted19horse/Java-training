package pm;

public class Test7 {
  public static void main(String[] args) {
    // A~Z 까지 중 하나가 선택된다.
    // "E" : "전자제품"
    // "S" : "스포츠용품"
    // "L" : "생활용품"
    // "F"||"G" : "식료품"
    // 그 외는 "미구분상품"
    // A(65) Z(90)

    int ran = (int) (Math.random() * 26 + 65);
    char code = (char) ran;

    String category = "미구분상품";

    // if (ran == 69)
    // category = "전자제품";
    // else if (ran == 83)
    // category = "스포츠용품";
    // else if (ran == 76)
    // category = "생활용품";
    // else if (ran == 70 || ran == 71)
    // category = "식료품";

    switch (ran) {
      case 69:
        category = "전자제품";
        break;
      case 83:
        category = "스포츠용품";
        break;
      case 76:
        category = "생활용품";
        break;
      case 70:
      case 71:
        category = "식료품";
        break;
    }

    String msg = ran + " Code:" + code + " category:" + category;
    System.out.println(msg);
  }
}
