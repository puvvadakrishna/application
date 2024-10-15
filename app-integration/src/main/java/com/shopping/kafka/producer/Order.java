package com.shopping.kafka.producer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Order {

  private String id;

  private String name;
}
