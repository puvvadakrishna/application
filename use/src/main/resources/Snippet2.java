class Vechile {
  public String tyreShape() throws NullPointerException {
    return "square";
  }
}

public class Car extends Vechile {
  public static void main(String[] args) {
    Vechile veh = new Car();
    System.out.println(veh.tyreShape());
  }

  public String tyreShape() throws Exception {
    return "round";
  }
}

// output -
