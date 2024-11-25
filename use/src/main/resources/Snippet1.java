class Vehicle {
  public String tyreShape() throws NullPointerException {
    return "square";
  }
}
public class Car extends Vehicle {
  public static void main(String[] args) {
    Car car = new Vechile();
    System.out.println(car.tyreShape());
  }
  public String tyreShape() throws Exception {
    return "round";
  }
}

// output - ?