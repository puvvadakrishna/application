//Amazon
//Ebay
An add click generates a json request to your app. Based on the source value, the other 2 elements are optional or mandate for different providers(Amazon/ebay)
Provide a approach for the validate of optional attributes based on source

{
        "source":"advert",
        "item":"iphone",
        "model":"i16",
        "discount":"10"
}

Hint to begin with:( consider scalablity/ & SOLID principles in the approach)

public abstract class OnlineShoppingValidator<T extends Validator> {

}





