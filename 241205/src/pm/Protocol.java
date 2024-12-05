package pm;

import java.io.Serializable;

public class Protocol implements Serializable {
  int cmd; // 1: 접속, 2: 메세지, 3: 종료
  String msg;

  public int getCmd() {
    return cmd;
  }

  public void setCmd(int cmd) {
    this.cmd = cmd;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }
}
