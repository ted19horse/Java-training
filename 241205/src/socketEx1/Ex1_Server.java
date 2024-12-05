package socketEx1;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex1_Server {
  public static void main(String[] args) throws IOException {
    // 서버는 접속을 받기 위해 반드시 ServerSocket이 있어야 한다.
    ServerSocket ss = new ServerSocket(5000);
    System.out.println("Server started:"+ss.getLocalPort());

    Thread thread = new Thread(){
      @Override
      public void run() {
        while(true){
          // 서버는 접속자를 받아들여야 한다.
          Socket s = null;
          try {
            s = ss.accept(); // 접속자가 생길때까지 대기상태 (기다린다.)
          } catch (IOException e) {
            throw new RuntimeException(e);
          }

          // Socket s가 결국 외부에서 접속한 클라이언트의 소켓 객체이다.
          InetAddress ip = s.getInetAddress();
          String clientIP = ip.getHostAddress(); // 접속자의 IP
          System.out.println("Client IP:"+clientIP);
        }
      }
    };
    thread.start();
  }
}