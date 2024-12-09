package com.example.useful;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerService {
    public static void main(String[] args) {
        System.out.println(getCustomer("alex").get());
    }

    public static Optional<Customer> getCustomer(String name) {

        CustomerData customerData = new CustomerData();
        List<Customer> customerList = customerData.getDetails();
        return details.stream()
                .filter(d -> d.getName().equals(name))
                .map(c -> new Customer())
                .findFirst();

        // output - ? alex .
    }

    public Customer getAddress(String name) {

        CustomerData customerData = new CustomerData();
        List<Customer> customerList = customerData.getCustomerData(name);
        for (int i = 0; i < customerList.size(); i++) {
            Customer c = customerList.get(i);
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    public Customer getCustomers(String name) {
        return null; // complete this
    }
}
