package am3_Out_Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class OutFrameEx4 extends JFrame {
  JTextArea ta;

  // 메뉴 관련 객체들 선언
  JMenuBar bar;
  JMenu file_m;
  JMenuItem new_item, save_item, exit_item;

  // 저장시 사용할 스트림
  BufferedOutputStream bos = null;
  File selectedFile;

  public OutFrameEx4() {
    // 메뉴에 관련된 객체들 생성 - 순서는 무관
    bar = new JMenuBar();

    file_m = new JMenu("파일");
    new_item = new JMenuItem("새 파일");
    save_item = new JMenuItem("저장");
    exit_item = new JMenuItem("종료");

    // 생성된 메뉴관련 객체들을 배치한다.
    // JMenuItem --> JMenu --> JMenuBar --> 현재 창
    file_m.add(new_item);
    file_m.add(save_item);
    file_m.addSeparator(); // 구분선
    file_m.add(exit_item);

    bar.add(file_m);

    this.setJMenuBar(bar);

    this.add(new JScrollPane(ta = new JTextArea()));

    this.setBounds(1000, 100, 600, 600);
    this.setVisible(true);

    // 이벤트 감지자 등록
    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        // System.exit(0);
        closed();
      }
    });

    exit_item.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // System.exit(0); // 프로그램 종료
        closed();
      }
    });

    save_item.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // 저장을 눌렀을 때만 수행하는 곳!
        // 경로지정을 안해줘도 나오지만 호출 속도가 더 느려짐
        JFileChooser jfc = new JFileChooser("d:/code");
        // jfc.showSaveDialog(this); // << 여기서 this는 ActionListener를 구현한 무명객체이다.
        int cmd = jfc.showSaveDialog(OutFrameEx4.this);
        // 사용자가 저장 승인을 눌렀는지 확인해야 한다.
        if (cmd == JFileChooser.APPROVE_OPTION) {
          // 멤버변수 selectedFile에 선택된 파일을 저장한다.
          selectedFile = jfc.getSelectedFile();

          try {
            bos = new BufferedOutputStream(new FileOutputStream(selectedFile));
            // JtextArea에 있는 모든 문자열을 가져온다.
            String str = ta.getText();
            byte[] ar = str.getBytes();

            bos.write(ar, 0, ar.length);
            bos.flush(); // 스트림의 모든 자원들 방출~~!
          } catch (Exception exc) {
            exc.printStackTrace();
          }
        }
      }
    });
  }

  private void closed() {
    // 종료하기 전에 사용된 스트림들 모두 닫기
    try {
      if (bos != null) {
        bos.close();
      }
      // if(bis != null) {
      // bis.close();
      // }
    } catch (Exception exc2) {
      exc2.printStackTrace();
    }
    System.exit(0);
  }

  public static void main(String[] args) {
    new OutFrameEx4();
  }
}
