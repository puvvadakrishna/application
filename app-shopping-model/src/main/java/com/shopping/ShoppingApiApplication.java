package com.shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ShoppingApiApplication {

  public static void main(String[] args) {
    ApplicationContext applicationContext =
        SpringApplication.run(ShoppingApiApplication.class, args);
  }
}
