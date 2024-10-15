package com.example.useful;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class DatabaseUtil {

    static final List<Customer> details =
            Arrays.asList(
                    new Customer(1, "alex", "Newyork"),
                    new Customer(2, "aman", "India"),
                    new Customer(3, "andy", "London"));

    public Customer getAddress(String name) {
        for (int i = 0; i < details.size(); i++) {
            Customer c = details.get(i);
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    public Customer getCustomers(String name) {
        return null; // complete this
    }










    public static Optional<Customer> getCustomer(String name) {
        return details.stream()
                .filter(d -> d.getName().equals(name))
                .map(c -> new Customer())
                .findFirst();
    }

    public static void main(String[] args) {
        System.out.println(getCustomer("alex"));
    }
}
