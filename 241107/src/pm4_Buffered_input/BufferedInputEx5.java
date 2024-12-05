package pm4_Buffered_input;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class BufferedInputEx5 extends JFrame implements ActionListener {
  JPanel north_p;
  JTextField input_tf;
  JButton ok_bt, back_bt;

  JTextArea textArea;

  public BufferedInputEx5() {
    this.add(new JScrollPane(textArea = new JTextArea()));
    textArea.setEditable(false);

    north_p = new JPanel();
    input_tf = new JTextField(20);
    ok_bt = new JButton("Check");

    north_p.add(new JLabel("Path:"));
    north_p.add(input_tf);
    north_p.add(ok_bt);

    this.add(north_p, BorderLayout.NORTH);

    this.setBounds(1000, 100, 500, 700);
    this.setVisible(true);

    /* E.L */
    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    // 확인버튼에게 이벤트 감지자 등록
    // 확인 버튼 클릭할 때마다 현재객체(this) 에서 actionPerfomred를 자동 호출
    ok_bt.addActionListener(this);
    input_tf.addActionListener(this); // textField에서 enter입력시 이벤트 발생으로 인식
  }

  public static void main(String[] args) {
    new BufferedInputEx5();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    viewList();
  }

  public void initTextList() {
    input_tf.setText(""); // 청소
    textArea.setText("");
  }

  private void viewList() {
    // 1. input_tf에 사용자가 입력한 경로를 가져온다.
    String path = input_tf.getText().trim();
    if (path.length() > 3) {
      // 잘 입력한 경우! 일단 파일객체로 생성
      File file = new File(path);

      // 존재여부 확인 + 폴더인지 판단
      if (file.exists()) {
        // 존재하지만 폴더인 경우
        if (file.isDirectory()) {
          JOptionPane.showMessageDialog(this, "파일명을 입력하세요.");
        }
        // 존재하지만 파일인 경우
        else {

          /* 해석 */
          /* 임시 메모리를 가지는 InputStream을 생성, BufferedInputStream */
          BufferedInputStream bis = null;
          /* 모든 InputStream은 생성시에 Exception발생이 가능하므로 예외처리가 필수 */

          /* 모든 ~~~InputStream은 I/O 단위를 byte로 사용함. */
          /* 그러므로 byte[] 배열을 생성하며, 이미지 등의 파일도 처리하기 때문에 4kb를 일반적으로 사용 */
          byte[] buf = new byte[4096];

          /* 몇개의 글자를 읽어들였는지 int size 변수를 사용할 수 있음 */
          int size = 0;
          try {
            /* BufferedInputStream 생성시에 인자로 InputStream이 필요함 */
            /* 모든 ~~~InputStream은 InputStream을 상속받음 */
            /* 이 경우에는 File의 내용을 입력받기 때문에 FileInputStream을 사용 */
            bis = new BufferedInputStream(new FileInputStream(file));

            /* 해당 Stream을 read()하면 해당 위치 데이터의 byte값을 읽는다. */
            /* 최상위 InputStream 안의 마커가 자동으로 현재 입력중인 데이터의 위치값을 기록한다 */
            /* bis(BufferedInputStream).read()를 하면 해당 InputStream의 데이터를 byte단위로 하나씩 입력받는다 */
            /* byte값은 0~255 사이이며, -1인 경우 해당하는 byte가 없으므로 더 이상의 입력데이터가 없다 */
            /* read()에 인자로 배열을 주면 해당 배열에 입력받은 byte를 입력한다 */
            while ((size = bis.read(buf)) != -1) {
            }

            String content = new String(buf, 0, size);
            textArea.setText(content);
            textArea.updateUI();
          } catch (Exception e) {
            e.printStackTrace();
          } finally {
            try {
              if (bis != null) {
                bis.close();
              }
            } catch (Exception e) {
            }
          }
        }
      } else {
        // 경로가 존재하지 않음
        JOptionPane.showMessageDialog(this, "경로가 존재하지 않습니다.");
      }
    } else {
      // 유효성검사 통과 못함.
      // 경고창을 보여준다.
      JOptionPane.showMessageDialog(this, "유효하지 않는 값입니다.");
      initTextList();
    }
  }
}
