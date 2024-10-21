package pm;

public class Test3다중If문 {
  public static void main(String[] args) {
    // int score = (int) (Math.random() * 101); // 0부터 100까지 난수발생
    // 70 ~ 100 : 우수
    // 50 ~ 69 : 보통
    // 50 미만 : 노력

    // String msg = "";

    // if (70 <= score && score <= 100)
    // msg = "우수";
    // else if (50 <= score && score < 70)
    // msg = "보통";
    // else
    // msg = "노력";

    // System.err.println("점수는 " + score + "점 입니다. 등급은 " + msg + " 입니다.");

    int score2 = (int) (Math.random() * 100 + 1);
    String grade = "";

    // if (100 >= score2 && score2 >= 90) {
    // grade = "A";
    // if (score2 >= 95)
    // grade += "+";
    // else
    // grade += '-';
    // } else if (89 >= score2 && score2 >= 80) {
    // grade = "B";
    // if (score2 >= 85)
    // grade += "+";
    // else
    // grade += '-';
    // } else if (79 >= score2 && score2 >= 70) {
    // grade = "C";
    // if (score2 >= 75)
    // grade += "+";
    // else
    // grade += '-';
    // } else
    // grade = "재수강";

    if (score2 >= 95) {
      grade = "A+";
    } else if (score2 >= 90) {
      grade = "A-";
    } else if (score2 >= 85)
      grade = "B+";
    else if (score2 >= 80)
      grade = "B-";
    else if (score2 >= 75)
      grade = "C+";
    else if (score2 >= 70)
      grade = "C-";
    else
      grade = "재수강";

    System.out.println("점수는 " + score2 + " 점 입니다. 등급은 " + grade + "입니다.");
  }
}
