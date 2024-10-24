package vendingMachine;

public class VendingMachine {

  // 자판기 리스트 기본값
  DrinkVO[] list = new DrinkVO[4];

  // 자판기에 들어있는 거스름돈(총 금액)
  int charge;

  // 음료수를 뽑을 수 있는 상태
  boolean pickable;

  public boolean isPickable() {
    return pickable;
  }

  public void init() {
    DrinkVO drink1 = new DrinkVO();
    drink1.setNumber("1");
    drink1.setName("레쓰비");
    drink1.setPrice(500);
    drink1.setAvailable(false);

    DrinkVO drink2 = new DrinkVO();
    drink2.setNumber("2");
    drink2.setName("사이다");
    drink2.setPrice(700);
    drink2.setAvailable(false);

    DrinkVO drink3 = new DrinkVO();
    drink3.setNumber("3");
    drink3.setName("콜라");
    drink3.setPrice(800);
    drink3.setAvailable(false);

    DrinkVO drink4 = new DrinkVO();
    drink4.setNumber("4");
    drink4.setName("웰치스");
    drink4.setPrice(900);
    drink4.setAvailable(false);

    list[0] = drink1;
    list[1] = drink2;
    list[2] = drink3;
    list[3] = drink4;
  }

  // selector, 자판기의 잔돈을 갱신하고 뽑을 수 있는 음료 리스트 제공
  public String selecter(int coin) {
    StringBuffer msg = new StringBuffer(); // 메세지 초기화
    this.charge = coin; // 자판기의 잔돈은 현재 투입금과 같다
    this.pickable = false; // 음료수 뽑기 가능여부 초기화

    if (coin < 500) {
      msg.append("뽑을 수 없습니다. 잔돈: ");
      msg.append(this.charge);
    }

    for (int i = 0; i < list.length; i++) { // 음료수 전부를 확인해서
      if (list[i].getPrice() <= coin) { // 가격이 넣은 돈보다 적으면
        this.pickable = true; // 자판기에서 음료수를 뽑을 수 있는 상태가 되고
        list[i].setAvailable(true); // 해당 음료수는 뽑기 가능

        if (msg.length() != 0 && msg.indexOf(", ") != msg.length() - 2) { // 메세지 뒤에 ", " 표시가 없으면 추가
          msg.append(", ");
        }

        msg.append(list[i].getNumber());
        msg.append(":");
        msg.append(list[i].getName());
        msg.append("(");
        msg.append(list[i].getPrice());
        msg.append("원)");
      }
    }

    return msg.toString();
  }

  // picker, 자판기에서 음료수를 뽑고 메세지를 제공
  public String picker(String select, int pick) {
    StringBuffer msg = new StringBuffer(); // 메세지 초기화

    /*
     * 1. 선택한 음료의 숫자가 범위를 초과하거나
     * 2. 해당 숫자의 음료가 뽑기 불가능할 경우
     * 뽑을 수 없다는 메세지를 반환
     */
    if (pick < 1 || pick > list.length || !list[pick - 1].isAvailable()) {
      msg.append("뽑을 수 없습니다. 잔돈: ");
      msg.append(this.charge);
      return msg.toString();
    }

    // 음료를 선택하는데 문제가 없다면 자판기 안의 잔돈(거스름돈)에서 음료수 값을 제외
    this.charge -= list[pick - 1].getPrice();

    msg.append(list[pick - 1].getName());
    msg.append(" 잔돈: ");
    msg.append(this.charge);

    return msg.toString();
  }
}
