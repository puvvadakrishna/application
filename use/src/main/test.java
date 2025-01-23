package src.main;

import org.springframework.stereotype.Component;

interface Animal {
    void eat();
}

@Component
class Rat implements Animal {

    public void eat() {
        System.out.println("Rat eats");
    }

}
@Component
class Cow implements Animal {
    public void eat() {
        System.out.println("Cow eats");
     }
}



class ConsumerService {

       boolean foodConsumer (String food, boolean isVegan) {
     
        //        .eat(); ?
        return true;
    }
}
