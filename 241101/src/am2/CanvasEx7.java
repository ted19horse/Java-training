package am2;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.ArrayList;

public class CanvasEx7 extends Canvas {
  // 클릭할 때마다 타원(OvalEx2)를 생성하여 저장할 곳이 필요
  // 이 때 배열로 선언하면 안되는 이유는 몇 개를 저장할 지 모르기 때문에
  ArrayList<OvalEx2> list;

  @Override
  public void paint(Graphics g) {
    // 타원(OvalEx2)들이 저장된 list를 반복문을 이용하여 그린다.
    for (int i = 0; i < list.size(); i++) {
      // 리스트로부터 하나씩 요소를 가져온다
      OvalEx2 ov = list.get(i);

      // 붓 색상 변경
      g.setColor(ov.c);

      // 타원 그리기
      g.fillOval(ov.x, ov.y, ov.wh, ov.wh);
    }
  }

  public CanvasEx7() {
    list = new ArrayList<OvalEx2>();
  }
}
