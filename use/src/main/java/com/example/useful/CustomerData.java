package com.example.useful;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
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
