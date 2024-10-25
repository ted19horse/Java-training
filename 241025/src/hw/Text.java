package hw;

public class Text {
  public static void main(String[] args) {
    String s = new String("Java Training");
    int idx = s.indexOf("va");
    String ex = s.substring(idx, idx + 2);
    System.out.println(ex);

    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      // System.out.println(ch);
      if (ch == 'r') {
        count++;
      }
    }
    System.out.println("소문자 r의 갯수:" + count);
  }
}
