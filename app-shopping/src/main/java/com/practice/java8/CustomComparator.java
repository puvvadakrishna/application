package com.practice.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomComparator {

    public static int compareByName(Person a, Person b) {

        return a.getName().compareTo(b.getName());
    }

    // Method 2
    // Static method to compare with age
    public static int compareByAge(Person a, Person b) {

        return a.getAge().compareTo(b.getAge());
    }

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("somu", 30));
        personList.add(new Person("somu", 35));
        personList.add(new Person("kush", 3));
        Collections.sort(personList, CustomComparator::compareByName);
        personList.stream().map(s -> s.getName()).forEach(System.out::println);
        Collections.sort(personList, CustomComparator::compareByAge);
        personList.stream().map(s -> s.getAge()).forEach(System.out::println);
    }
}