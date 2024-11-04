package com.shopping.basket;

import com.shopping.entity.Order;
import com.shopping.repo.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BasketService {
  @Autowired private BasketRepository repository;

  public boolean add(Order order) {
    return repository.add(order);
  }

  public Order get(Order order) {
    return repository.getOrder(order);
  }
}
