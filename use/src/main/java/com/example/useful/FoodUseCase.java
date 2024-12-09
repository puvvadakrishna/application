public enum Food{

    CHICKEN(false),
    POTATO(true);

    private final boolean isVegan;
    private Food(String isVegan) {
        this.isVegan = isVegan;
    }
    public String getIsVegan() {
        return isVegan;
    }
}

public interface AnimalService{
    void consume();
}
public Cow implements AnimalService{
    @Override
    void consume(){

    }
}
public Cat implements AnimalService{

    @Override
    void consume(){

    }
}

/*

If a request is to Controller with a input(string) need to call to call the applicable implemetion based on the request data

how do you approach this? you could change the pseduo code/ add / remove any methods

 */
public class Controller{

    @PostMapping("/consume")
    public boolean consumeFood(Food food)
    {

    }

}




