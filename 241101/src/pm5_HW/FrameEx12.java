package pm5_HW;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class FrameEx12 extends JFrame {
  /* Field */
  int x = 100, y = 100, w = 100, h = 50;
  Color c = Color.BLACK;

  /* Member Class */
  Canvas can = new Canvas() {
    @Override
    public void paint(Graphics g) {
      g.setColor(c);
      g.fillRect(x, y, w, h);
    }
  };

  /* Constructer */
  public FrameEx12() {
    /* Add canvas */
    this.add(can);

    /* Basement */
    this.setBounds(500, 100, 500, 500);
    this.setVisible(true);

    x = (can.getWidth() / 2) - (w / 2);
    y = can.getHeight() - 75;
    can.repaint();

    /* Event Listener */
    this.addKeyListener(new KeyListener() {
      @Override
      public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        int move = 5;
        switch (code) {
          case KeyEvent.VK_LEFT:
            x -= move;
            break;
          case KeyEvent.VK_RIGHT:
            x += move;
            break;
          case KeyEvent.VK_SPACE: {
            int r, g, b;
            r = (int) (Math.random() * 256);
            g = (int) (Math.random() * 256);
            b = (int) (Math.random() * 256);
            c = new Color(r, g, b);
            break;
          }
        }

        if (x < 0) {
          x = 0;
        } else if (x + w > can.getWidth()) {
          x = can.getWidth() - w;
        }

        can.repaint();
      }

      @Override
      public void keyReleased(KeyEvent e) {
      }

      @Override
      public void keyTyped(KeyEvent e) {
      }
    });
    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }

  public static void main(String[] args) {
    new FrameEx12();
  }
}
