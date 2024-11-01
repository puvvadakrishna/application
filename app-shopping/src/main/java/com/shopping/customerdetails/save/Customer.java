package com.shopping.customerdetails.save;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Customer implements Serializable {

  private static final long serialVersionUID = 1L;
  private String customerName;
  private String customerAddress;
  private String customerOrder;

  public Customer(String customerName, String customerAddress) {
    this.customerName = customerName;
    this.customerAddress = customerAddress;
  }
}
