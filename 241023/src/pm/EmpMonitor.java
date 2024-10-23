package pm;

public class EmpMonitor {
  EmpVO[] empArr = new EmpVO[5];

  public void init() {
    EmpVO p1 = new EmpVO();
    p1.setNumber(102);
    p1.setName("김길동");
    p1.setPos("사원");
    p1.setDept("영업1팀");

    EmpVO p2 = new EmpVO();
    p2.setNumber(160);
    p2.setName("이김말이");
    p2.setPos("팀장");
    p2.setDept("개발2팀");

    EmpVO p3 = new EmpVO();
    p3.setNumber(291);
    p3.setName("이새롬");
    p3.setPos("부장");
    p3.setDept("행사1팀");

    EmpVO p4 = new EmpVO();
    p4.setNumber(292);
    p4.setName("송하영");
    p4.setPos("팀장");
    p4.setDept("행사1팀");

    EmpVO p5 = new EmpVO();
    p5.setNumber(271);
    p5.setName("박지원");
    p5.setPos("사원");
    p5.setDept("행사1팀");

    empArr[0] = p1;
    empArr[1] = p2;
    empArr[2] = p3;
    empArr[3] = p4;
    empArr[4] = p5;
  }

  public String searchEmp(String kwd) {
    StringBuffer sBuffer = new StringBuffer();

    for (int i = 0; i < empArr.length; i++) {

      EmpVO emp = empArr[i];

      if (emp.getName().contains(kwd)) {
        sBuffer.append(emp.getNumber());
        sBuffer.append(" | ");
        sBuffer.append(emp.getName());
        sBuffer.append(" | ");
        sBuffer.append(emp.getPos());
        sBuffer.append(" | ");
        sBuffer.append(emp.getDept());
        sBuffer.append("\r\n");
      }
    }

    return sBuffer.toString();
  }
}
