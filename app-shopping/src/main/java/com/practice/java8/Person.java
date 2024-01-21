package com.practice.java8;

import lombok.Getter;

@Getter
public class Person {

    private String name;
    private Integer age;

    // Constructor
    public Person(String name, int age) {
        // This keyword refers to current instance itself
        this.name = name;
        this.age = age;
    }
}
