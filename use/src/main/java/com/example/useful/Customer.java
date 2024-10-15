package com.example.useful;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
  private int id = 4;
  private String name = "rama";
  private String country = "India";
}
