package com.example.learning.basket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.learning.entity.Order;
import com.example.learning.repo.BasketRepository;
@Component
public class BasketService {
    @Autowired
    private BasketRepository repository;

    public boolean add(Order order) {
        return repository.add(order);
    }

    public Order get(Order order) {
        return repository.getOrder(order);
    }
}
