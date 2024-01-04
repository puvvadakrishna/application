package com.shopping.entity;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class Order {

    private String name;
    private int quantity;
}
