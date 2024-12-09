package com.shopping.vaidation;

import org.springframework.stereotype.Component;

@Component
public class Validator {

    public Validator() {
        System.out.println("Constructor invocked.....");
    }

    public static String validate(String today) {

        return "Friday".equals(today) ? "yes" : "nope";
    }
}
