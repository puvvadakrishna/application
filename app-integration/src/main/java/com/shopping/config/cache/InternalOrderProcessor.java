package com.shopping.controller;

import org.springframework.stereotype.Component;

@Component
public class InternalOrderProcessor implements OrderProcesser {

  public String test() {

    return this.getClass().getName();
  }
}
