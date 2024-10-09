package com.shopping.controller;

import org.springframework.stereotype.Component;

@Component
public class DataService {
    public String getDataById(String id) {
        return "hello-" + id;
    }
}
