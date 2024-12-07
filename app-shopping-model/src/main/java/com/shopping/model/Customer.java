package com.shopping.model;

import java.io.Serializable;

import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable {

  private String name;
  private String address;
}
