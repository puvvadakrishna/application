public interface AnimalService{
    void eat();
}
public Animal1 implements AnimalService{

}
public Animal2 implements AnimalService{
}
// If a request is to Controller and controller need to call Animal.eat(),
1 .how do you approach this?
public class Controller{ 
    private AnimalService animalService = new Animal1();
    animalService.eat()

    AnimalService
    
}



