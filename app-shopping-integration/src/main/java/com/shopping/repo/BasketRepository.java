package com.shopping.repo;

import com.shopping.entity.Order;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BasketRepository {

    private static final List<Order> orders = new ArrayList<>();

    public boolean add(Order order) {
        return orders.add(order);
    }

    public Order getOrder(Order order) {

        return orders.get(0);
    }
}
