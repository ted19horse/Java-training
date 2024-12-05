package pm2;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MyCanvasEx4 extends Canvas implements MouseMotionListener {
  int x = -50, y, wh = 30;

  public MyCanvasEx4() {
    // 이벤트 감지자 등록
    this.addMouseMotionListener(this);
  }

  @Override
  public void update(Graphics g) {
    // 현재 그림 상태를 그대로 유지하여 paint 를 호출하도록 하면 기존 그림을 지우지 못한다.
    paint(g);
  }

  @Override
  public void paint(Graphics g) {
    // Canvas 에 있는 paint 메서드를 override 한다.
    g.fillOval(x - (wh / 2), y - (wh / 2), wh, wh);
  }

  @Override
  public void mouseDragged(MouseEvent e) {
    // 마우스를 누른 상태로 끌고 다닐 때 호출되는 영역
    x = e.getX();
    y = e.getY();
    this.repaint();
    /*
     * repaint() -> update() -> paint()
     * 호출 -> 지우기 -> 그리기
     */
  }

  @Override
  public void mouseMoved(MouseEvent e) {
    // 마우스를 누르지 않은 상태로 끌고 다닐 때 호출되는 영역
  }

}
