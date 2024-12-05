package pm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ChatClient extends JFrame {
  Thread t = new Thread(){
    @Override
    public void run() {
      // 항상 in.readObject 를 수행해야 한다.
      bk:while (true) {
        try {
          Object obj = in.readObject();
          if (obj != null) {
            Protocol protocol = (Protocol) obj;
            // protocol 이 가지는 cmd 값이 뭐냐?에 따라 작업을 구분
            switch (protocol.getCmd()) {
              case 2: {
                chat_area.append(protocol.getMsg());
                chat_area.append("\n"); // 줄바꿈
                break;
              }
              case 3: {
                break bk;
              }
            }
          }
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }

      try {
        if (in != null) in.close();
        if (out != null) out.close();
        if (socket != null) socket.close();
        System.exit(0);
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
  };

  CardLayout cardLayout;

  JPanel login_p, login_p2, p1, p2, chat_p, south_p;
  JButton login_btn, send_btn;
  JTextArea chat_area;
  JTextField nickName_tf, input_tf;
  Socket socket;
  ObjectOutputStream out;
  ObjectInputStream in;

  public ChatClient() {
    // Login 화면 구성
    login_p = new JPanel(new BorderLayout());
    login_p2 = new JPanel(new GridLayout(2,1));

    p1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    p1.add(new JLabel("Username:"));
    p1.add(nickName_tf = new JTextField(12));

    p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    p2.add(login_btn = new JButton("Login"));

    login_p2.add(p1);
    login_p2.add(p2);

    login_p.add(login_p2, BorderLayout.SOUTH);

    // Chat 화면 구성
    chat_p = new JPanel(new BorderLayout());
    chat_area = new JTextArea();
    chat_p.add(new JScrollPane(chat_area));
    south_p = new JPanel(new BorderLayout());
    south_p.add(input_tf = new JTextField());
    south_p.add(send_btn = new JButton("Send"), BorderLayout.EAST);
    chat_p.add(south_p, BorderLayout.SOUTH);

    // 현재 프레임의 레이아웃을 카드 레이아웃으로 설정
    setLayout(cardLayout = new CardLayout());
    getContentPane().add(login_p, "login");
    getContentPane().add(chat_p, "chat");

    this.setBounds(350, 50, 500, 600);
    this.setVisible(true);

    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        if(socket != null && out != null) {
          // 서버에 접속된 상태일 때
          // 접속을 해제하기 위해 3번 Protocol 객체 생성
          Protocol p = new Protocol();
          p.setCmd(3);
          try {
            out.writeObject(p); // 접속해제를 위한 Protocol
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        } else {
          // 서버에 접속하지 않았을 때
          System.exit(0);
        }
      }
    });

    // 로그인 버튼을 클릭할 때 사용자가 입력한 대화명을 가져온다.
    login_btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String nickname = nickName_tf.getText().trim();
        if(nickname.isEmpty()) {
          JOptionPane.showMessageDialog(ChatClient.this, "Please enter a nickname");
          nickName_tf.setText(""); // 청소
          nickName_tf.requestFocus(); // 커서 놓기
        } else {
          try {
            // 접속 수행
            // 192.168.10.105
            // 192.168.10.102
            socket = new Socket("192.168.10.103", 5000);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            t.start();
            Protocol p = new Protocol();
            p.setCmd(1);
            p.setMsg(nickname); // 대화명
            out.writeObject(p);
            cardLayout.show(getContentPane(), "chat");
          } catch (Exception ex) {
            throw new RuntimeException(ex);
          }
        }
      }
    });

    send_btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String msg = input_tf.getText().trim();
        if(!msg.isEmpty()) {
          try {
            Protocol p = new Protocol();
            p.setCmd(2);
            p.setMsg(msg); // 대화명
            out.writeObject(p);
            input_tf.setText("");
            input_tf.requestFocus();
          } catch (Exception ex) {
            throw new RuntimeException(ex);
          }
        }
      }
    });
  }

  public static void main(String[] args) {
    new ChatClient();
  }
}
