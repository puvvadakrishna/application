
class Vechile {
    public String tyreShape() throws NullPointerException {
         return "square";
    }
}

public class Car extends Vechile {
    public static void main(String[] args) {
        Car veh = new Vechile();
        System.out.println(veh.tyreShape());
    }

    public String tyreShape() throws Exception  {
        return "round";
    }
}

//