package homework;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class MyDialog extends JDialog {
  JTextArea ta;
  Test jf;

  BufferedInputStream bis;

  public MyDialog(Test jf, File file) {
    this.jf = jf;

    this.add(new JScrollPane(ta = new JTextArea()));

    this.setBounds(1000, 200, 500, 450);
    this.setVisible(true);

    // 선택된 파일을 읽어서 JTextArea에 표현하는 동작을 호출한다.
    readFile(file);

    // 이벤트 감지자
    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        // System.exit(0); // 프로그램이 종료되므로 잘못된 코드
        dispose(); // 현재 창만 닫기
      }
    });
  }

  public void readFile(File f) {
    // 모든 InputStream 은 생성, 사용, 닫기를 할 때 예외처리를 해야한다.
    // 멤버변수 selectedFile을 가지고 스트림을 생성한다.
    try {
      bis = new BufferedInputStream(new FileInputStream(f));
      byte[] buf = new byte[2048];
      int size = -1;
      // JTextArea에 기존 데이터들이 있을 수 있으니 청소 먼저 하자!
      ta.setText("");

      while ((size = bis.read(buf)) != -1) {
        // 실제 자원들은 buf라는 배열에 저장되어 있다.
        // buf의 0번지~size가 기억하는 수만큼 가져와서 문자열로 생성한다.
        String str = new String(buf, 0, size);
        ta.append(str);
      }
    } catch (Exception e1) {
      // 예외 발생내용을 순차적으로 스택형태로 출력해달라는 명령어
      e1.printStackTrace();
      try {
        bis.close();
      } catch (Exception e2) {
        e2.printStackTrace();
      }
    }
  }
}
