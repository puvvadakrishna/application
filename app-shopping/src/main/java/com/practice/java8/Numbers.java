package com.practice.java8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
    private static final Logger LOGGER = LoggerFactory.getLogger(Numbers.class);

    public static void main(String[] args) {

        // Creating an ArrayList object of integer type
        ArrayList<Integer> al = new ArrayList<>();

        // Inserting elements to ArrayList class object
        // Custom input integer numbers
        al.add(2);
        al.add(6);
        al.add(9);
        al.add(4);
        al.add(20);
        al.stream().filter(i -> i % 2 == 0).forEach(System.out::println);
        List<Integer> res = al.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        LOGGER.info("Even numbers {}", res);
        List<Integer> result = al.stream().filter(i -> i % 2 == 0).map(i -> i * i).collect(Collectors.toList());
        LOGGER.info("Square of Even numbers {}", result);
        List<Integer> sortresult = al.stream().filter(i -> i % 2 == 0).sorted().map(i -> i * i).collect(Collectors.toList());
        LOGGER.info("Square of Even numbers {}", sortresult);
    }
}
