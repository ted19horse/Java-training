package socketEx2;

import java.io.BufferedOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Ex2_Client {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the message to be sent:");
    String msg = sc.nextLine();

    if(msg != null && msg.trim().length() > 0) {
      // Send msg after connect sever if enter any type
      try {
        // connect server
        Socket socket = new Socket("192.168.10.99", 5000);

        // create stream for send msg to server
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());

        // send msg to server
        bos.write(msg.getBytes());
        bos.flush();
        bos.close();
        socket.close();
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
  }
}
