package com.example.useful;

import lombok.AllArgsConstructor;
import lombok.Data;
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
