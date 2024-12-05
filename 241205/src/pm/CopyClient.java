package pm;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class CopyClient extends Thread{
  Socket socket;
  ObjectInputStream in;
  ObjectOutputStream out;
  String ip, nickName;
  ChatServer server;

  public CopyClient(Socket socket, ChatServer server) {
    this.socket = socket; // 접속자의 소켓정보
    this.server = server; // 서버의 주소, Thread에서 사용함
    try {
      out = new ObjectOutputStream(socket.getOutputStream());
      in = new ObjectInputStream(socket.getInputStream());
      ip = socket.getInetAddress().getHostAddress();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void run() {
    // thread가 해야할 일
    // 언제 어느 때에 원격에 있는 클라이언트가 서버로 자원을 보낼지 모르므로
    // 항상 read()를 수행하여 자원이 넘어 올때를 기다려야 한다.
    bk:while (true) {
      try {
        Object obj = in.readObject();
        if (obj != null) {
          Protocol protocol = (Protocol) obj;
          // protocol이 가지는 cmd값이 뭐냐?에 따라 작업을 구분
          switch (protocol.getCmd()) {
            case 3: {
              // 원격의 Client 에 있는 Thread 를 소멸시키기 위한 메세지 전송
              out.writeObject(protocol);
              break bk;
            }
            case 1: {
              // 서버에 접속한 경우는
              // 사용자가 입력한 대화명을 얻어내어 nickName 에 저장
              this.nickName = protocol.getMsg();
              // 환영메세지 보내기 위해 Protocol 객체를 하나 생성
              Protocol p = new Protocol();
              p.setCmd(2);
              p.setMsg("*** "+nickName+" is entered. ***");
              server.sendProtocol(p);
              break;
            }
            case 2: {
              // 채팅 메세지 전송
              // 접속자 모두에게 채팅메세지 보내기
              protocol.setMsg(nickName + protocol.getMsg());
              server.sendProtocol(protocol);
              break;
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
      // 서버에 ArrayList 에서 현재 객체 삭제
      // 서버의 다른 접속자들에게 현재 객체가 접속 해제한다는 메세지 보내기
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
