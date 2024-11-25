//Amazon
//Ebay
An add click generates a json request to your app. Based on the source value, the other 2 elements are optional or mandate
        Provide a psudo code for the validate of optional attributes based on source

{
        "source":"advert",
        "item":"iphone",
        "model":"i16"
}

Hint to begin with:

public abstract class OnlineShoppingValidator<T extends Validator> {

}
