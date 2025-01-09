package src.main.java.com.example.useful;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Customer {
    private int id = 5;
    private String name = "Alex";
    private String country = "Finland";
}
