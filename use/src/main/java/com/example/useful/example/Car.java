package src.main.java.com.example.useful.example;


class Vehicle {
    public String tyreShape() throws Exception {
        return "square";
    }
}

public class Car extends Vehicle {
    public static void main(String[] args) throws Exception {
        Vehicle veh = new Car();
        System.out.println(veh.tyreShape());
    }

    public String tyreShape() throws NullPointerException {
        return "round";
    }
}

// output - ?
