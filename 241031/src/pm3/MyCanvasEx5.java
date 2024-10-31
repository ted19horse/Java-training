package pm3;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MyCanvasEx5 extends Canvas implements MouseMotionListener {
  /* Field */
  int x = -100, y, l = 10;
  CanvasEx5 p;
  Color c = Color.BLACK;

  public void setColor(Color c) {
    this.c = c;
  }

  public void setBrush(Integer l) {
    this.l = l;
  }

  /* Constructer */
  public MyCanvasEx5(CanvasEx5 p) {
    this.p = p;
    this.addMouseMotionListener(this);
  }

  /* Event handler */
  @Override
  public void update(Graphics g) {
    paint(g);
  }

  @Override
  public void paint(Graphics g) {
    g.setColor(c);
    g.fillOval(x - (l / 2), y - (l / 2), l, l);
  }

  @Override
  public void mouseDragged(MouseEvent e) {
    x = e.getX();
    y = e.getY();
    this.repaint();
  }

  @Override
  public void mouseMoved(MouseEvent e) {

  }
}
