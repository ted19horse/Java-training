package pm;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {
  // 서버는 반드시 ServerSocket이 있어야한다.
  ServerSocket ss;
  ArrayList<CopyClient> list;

  public ChatServer() {
    list = new ArrayList<>(); // 접속자들이 저장될 곳
    try {
      ss = new ServerSocket(5000);
      System.out.println("Server started");
      while(true) {
        Socket s = ss.accept(); // 접속자가 발생할 때까지 대기

        // 접속자가 생기면 받은 소켓을 가지고 CopyClient 객체를 생성한다.
        CopyClient cc = new CopyClient(s, this);
        cc.start(); // thread 시작
        list.add(cc);
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  // 접속자 모두에게 메세지를 전달하는 기능
  public void sendProtocol(Protocol p) {
    for(CopyClient cc : list) {
      // 각 접속자들(cc)은 out 을 가지고 있다.
      try {
        cc.out.writeObject(p);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }

  // list 에서 특정 CopyClient 객체 삭제하는 기능
  public void removeClient(CopyClient cc) {
    list.remove(cc);
  }

  public static void main(String[] args) {
    new ChatServer();
  }
}
