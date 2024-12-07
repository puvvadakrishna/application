package com.shopping.customerdetails.save;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.shopping.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class SaveCustomerDataImpl implements SaveCustomerData {

  List<Customer> details =
      Arrays.asList(
          new Customer("somu", "coventry"),
          new Customer("Ram", "Hyderabad"),
          new Customer("Kush", "London"));

  public String getNameAndAdress(String name) {
    return details.stream()
        .filter(i -> i.getCustomerName().equalsIgnoreCase(name))
        .map(i -> i.getCustomerAddress())
        .collect(Collectors.joining(", "));
  }

  public String saveNewUser(String name, String adress) {
    details.set(1, new Customer(name, adress));
    return name;
  }
}
