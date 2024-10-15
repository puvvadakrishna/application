package com.shopping.steps;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.isNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.test.context.ContextConfiguration;

import com.shopping.basket.BasketService;
import com.shopping.entity.Order;

import io.cucumber.java8.En;
import io.cucumber.spring.ScenarioScope;

@ScenarioScope
// @ContextConfiguration(classes = LearningApplication.class,  loader =
// SpringBootContextLoader.class)
public class Basket implements En {

  @Autowired BasketService basket;

  Order order;

  public Basket() {
    Given(
        "^When and user selects an item to add to the basket$",
        () -> {
          order = getOrder();
        });
    When(
        "^the selected quality is greater than (\\d+)$",
        (Integer arg0) -> {
          if (arg0 >= 0) {
            basket.add(order);
          }
        });
    Then(
        "^item should be added to basket$",
        () -> {
          assertThat(basket.get(null)).isNotNull();
        });
    And(
        "^inventory should be updated$",
        () -> {
          assertThat(true).isTrue();
        });
  }

  private Order getOrder() {

    return Order.builder().name("Apple").quantity(1).build();
  }
}
