package am_File2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class FileEx2 extends JFrame implements ActionListener {
  JPanel north_p;
  JTextField input_tf;
  JButton ok_bt, back_bt;

  JList<String> list;

  public FileEx2() {
    this.add(new JScrollPane(list = new JList<>()));

    north_p = new JPanel();
    input_tf = new JTextField(20);
    ok_bt = new JButton("Check");
    back_bt = new JButton("Back");

    north_p.add(new JLabel("Path:"));
    north_p.add(input_tf);
    north_p.add(ok_bt);
    north_p.add(back_bt);

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
    back_bt.addActionListener(this);

    // 더블클릭 이벤트 만들기
    list.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {

          /* getModel().getElementAt(index) 보다 getSelectedValue() 가 훨씬 간결하다 */
          // int index = list.locationToIndex(e.getPoint());
          // String selectedString = list.getModel().getElementAt(index);
          String selectedString = list.getSelectedValue();

          String enteredString = input_tf.getText();
          StringBuffer newString = new StringBuffer(enteredString);
          newString.append("/");
          newString.append(selectedString);
          input_tf.setText(newString.toString());

          // 이번 강의에서는 actionPerformed를 재호출하는 것보다
          // 반복되는 코드를 메서드화 하는데 초점이 맞춰져 있다.
          // actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED,
          // "MouseDoubleClick"));
          viewList();
        }
      }
    });
  }

  public static void main(String[] args) {
    new FileEx2();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == back_bt) {
      // 현재 input_tf에서 경로 문자열을 가져온다.
      String path = input_tf.getText();

      // 경로는 예를들어 이런 형식이다. "d:/code/java/work"
      // 가장 오른쪽에 있는 "/"를 찾아 index값을 얻어낸다.
      int lastIndex = path.lastIndexOf("/");

      // 검색된 "/"의 뒷부분은 필요없으므로 0~lastIndex까지 문자열을 추출한다.
      input_tf.setText(path.substring(0, lastIndex));
    }
    viewList();
  }

  public void initTextList() {
    input_tf.setText(""); // 청소
    list.setListData(new String[0]);
  }

  private void viewList() {
    // 1. input_tf에 사용자가 입력한 경로를 가져온다.
    String path = input_tf.getText().trim();
    if (path.length() > 3) {
      // 잘 입력한 경우! 일단 파일객체로 생성
      File file = new File(path);

      // 존재여부 확인 + 폴더인지 판단
      if (file.exists()) {
        // 경로가 존재하는 경우
        if (file.isDirectory()) {
          // 폴더의 하위요소들 모두 가져오기
          String[] ar = file.list();

          // 받은 배열을 JList에 넣어준다.
          list.setListData(ar);
        }
        // 존재하지만 파일인 경우
        else {
          JOptionPane.showMessageDialog(this, "폴더명을 입력하세요.");
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
