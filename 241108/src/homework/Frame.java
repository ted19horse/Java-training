package homework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Frame extends JFrame {
  /* Field */

  JMenuBar menuBar = new JMenuBar();
  JMenu menu = new JMenu("File");
  JMenuItem menuItemNewFile = new JMenuItem("New file");
  JMenuItem menuItemOpen = new JMenuItem("Open");
  JMenuItem menuItemSave = new JMenuItem("Save");
  JMenuItem menuItemExit = new JMenuItem("Exit");

  JTextArea ta = new JTextArea();

  File selectedFile;

  BufferedInputStream bis;
  BufferedOutputStream bos;

  /* Constructer */
  public Frame() {
    /* Set menubar, menuItem > menu > menuBar > window */
    menu.add(menuItemNewFile);
    menu.add(menuItemOpen);
    menu.add(menuItemSave);
    menu.addSeparator();
    menu.add(menuItemExit);

    menuBar.add(menu);

    this.setJMenuBar(menuBar);

    this.add(new JScrollPane(ta));

    this.setBounds(1000, 100, 500, 700);
    this.setVisible(true);

    /* Event Listener */
    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        closeWindow();
      }
    });

    menuItemNewFile.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Frame.this.selectedFile = null;
        Frame.this.setTitle("");
        Frame.this.ta.setText("");
      }
    });

    menuItemOpen.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser("d:/code");
        int cmd = jfc.showOpenDialog(Frame.this);
        if (cmd == JFileChooser.APPROVE_OPTION) {
          Frame.this.ta.setText("");
          Frame.this.selectedFile = jfc.getSelectedFile();
          Frame.this.setTitle(selectedFile.getName());

          try {
            bis = new BufferedInputStream(new FileInputStream(selectedFile));
            byte[] buf = new byte[2048];
            int size = -1;
            while ((size = bis.read(buf)) != -1) {
              String txt = new String(buf, 0, size);
              Frame.this.ta.append(txt);
            }
          } catch (Exception exc) {
            exc.printStackTrace();
          }
        }
      }
    });

    menuItemSave.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (Frame.this.selectedFile == null) {
          JFileChooser jfc = new JFileChooser("d:/code");
          int cmd = jfc.showSaveDialog(Frame.this);
          if (cmd == JFileChooser.APPROVE_OPTION) {
            Frame.this.selectedFile = jfc.getSelectedFile();
            Frame.this.setTitle(selectedFile.getName());
          } else {
            return;
          }
        }
        saveFile(selectedFile);
      }
    });

    menuItemExit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        closeWindow();
      }
    });
  }

  private void saveFile(File selectedFile) {
    try {
      bos = new BufferedOutputStream(new FileOutputStream(selectedFile));
      String txt = Frame.this.ta.getText();
      byte[] buf = txt.getBytes();
      bos.write(buf);
      bos.flush();
    } catch (Exception exc) {
      exc.printStackTrace();
    }
  }

  private void closeWindow() {
    try {
      if (bis != null) {
        bis.close();
      }
      if (bos != null) {
        bos.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.exit(0);
  }

  public static void main(String[] args) {
    new Frame();
  }
}
