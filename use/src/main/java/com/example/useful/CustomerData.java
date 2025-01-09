package src.main.java.com.example.useful;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
public class CustomerData {

    static final List<Customer> details =
            Arrays.asList(
                    new Customer(1, "alex", "Newyork"),
                    new Customer(2, "aman", "India"),
                    new Customer(3, "andy", "London"));

    public static List<Customer> getDetails() {
        return details;
    }
}
