//Amazon
//Ebay
An add click generates a json request to your app. Based on the request payload value, the few elements are optional or mandate for different providers(Amazon/ebay)
Provide a approach for the validate of optional attributes based on source

// request payload
{
        "provider":"amazon/ebay",
        "item":"iphone",
        "model":"i16",
        "discount":"10"  // optional for Amazon
}

Hint to begin with:( consider SOLID principles in the approach). if you wish,you can ignore the hint as well
public abstract class OnlineShoppingValidator<T extends RequestPayLoad> {
    abstract void validate(T request);
}
