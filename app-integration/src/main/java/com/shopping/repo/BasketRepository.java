package com.shopping.repo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.shopping.entity.Order;
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
