package com.shopping.controller;

import org.springframework.stereotype.Component;

@Component
public class ExternalOrderProcessor implements OrderProcesser {

    public String test() {

        return this.getClass().getName();
    }
}
