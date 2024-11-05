package am2_Falling_keyword;

public class KeywordEx3 extends Thread {
  int x = 0;
  int y = 0;
  String txt;
  DownKeywordFrameEx3 d;

  public KeywordEx3(DownKeywordFrameEx3 d, int x, String txt) {
    this.d = d;
    this.x = x;
    this.txt = txt;
  }

  @Override
  public void run() {
    while (true) {
      y += 10;
      if (y > d.panelText.getHeight()) {
        break;
      }
      d.panelText.repaint();

      try {
        Thread.sleep(100);
      } catch (Exception e) {
        //
      }
    }
  }
}
