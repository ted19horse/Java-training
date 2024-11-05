package pm2_Shooting_bar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {
  /* Field */
  JPanel panelPalette;
  int x = 270, y = 400, w = 60, h = 20;
  ArrayList<Bullet> list = new ArrayList<Bullet>();

  /* Constructer */
  public Frame() {
    panelPalette = new JPanel() {
      @Override
      protected void paintComponent(Graphics g) {
        /* Double buffer */
        Image img = createImage(this.getWidth(), this.getHeight());
        Graphics ig = img.getGraphics();
        // color setting available
        ig.setColor(Color.BLACK);
        ig.fillRect(Frame.this.x, Frame.this.y, Frame.this.w, Frame.this.h);

        // list 안의 Bullet 들을 전부 그리기
        for (int i = 0; i < list.size(); i++) {
          Bullet b = list.get(i);
          ig.setColor(b.color);
          ig.fillOval(b.x, b.y, b.w, b.h);
        }

        g.drawImage(img, 0, 0, this);
      }
    };
    this.add(panelPalette);

    /* Basement */
    this.setBounds(1000, 100, 600, 500);
    this.setVisible(true);

    /* Event listener */
    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    this.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        int mv = 10;
        switch (code) {
          case KeyEvent.VK_LEFT:
            Frame.this.x -= mv;
            if (Frame.this.x < 0) {
              Frame.this.x = 0;
            }
            break;
          case KeyEvent.VK_RIGHT:
            Frame.this.x += mv;
            if (Frame.this.x > Frame.this.panelPalette.getWidth() - Frame.this.w) {
              Frame.this.x = Frame.this.panelPalette.getWidth() - Frame.this.w;
            }
            break;
          case KeyEvent.VK_SPACE:
            Bullet b = new Bullet(Frame.this, Frame.this.x + (Frame.this.w / 2), Frame.this.y);
            list.add(b);
            b.start();
            break;
        }
        Frame.this.panelPalette.repaint();
      }
    });
  }

  public static void main(String[] args) {
    new Frame();
  }
}
