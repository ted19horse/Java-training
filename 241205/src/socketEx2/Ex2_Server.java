package socketEx2;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Ex2_Server {
  public static void main(String[] args) throws IOException {
    ServerSocket ss = new ServerSocket(5000);
    System.out.println("Server started:" + ss.getLocalSocketAddress());

    Thread thread = new Thread(){
      @Override
      public void run() {
        while(true){
          Socket s;
          try {
            s = ss.accept();
            InetAddress ip = s.getInetAddress();
            String ipAddress = ip.getHostAddress();
            BufferedInputStream bis = new BufferedInputStream(s.getInputStream());

            String receiveMsg = new String(bis.readAllBytes());
            System.out.printf("%s: %s\n", ipAddress, receiveMsg);
            bis.close();
          } catch (IOException e) {
            throw new RuntimeException(e);
          }
        }
      }
    };
    thread.start();
  }
}
