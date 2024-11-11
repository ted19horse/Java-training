package am3_Serial_IO;

import java.io.Serializable;

// public class DrinkVO {
public class DrinkVO implements Serializable {
  String name;
  int price;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }
}
