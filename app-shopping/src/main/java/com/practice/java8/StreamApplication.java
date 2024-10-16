package com.practice.java8;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
@Slf4j
public class StreamApplication {

    public static void main(String[] args) throws RuntimeException {

        List<String> list = Arrays.asList("9", "A", "Z", "1", "B", "Y", "4", "a", "c");
        List<Integer> listNumbers = Arrays.asList(9, 10, 2, 1, 3, 6, 4, 7, 8);
        List<String> sortedListtraditional = list.stream()
                .sorted((o1, o2) -> o2.compareTo(o1))
                .collect(Collectors.toList());
        sortedListtraditional.forEach(System.out::println);
        List<String> sortedList = list.stream().sorted().collect(Collectors.toList());
        List<String> sortedListReverseOrder = list.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        log.info("**1**");
        sortedListReverseOrder.forEach(System.out::println);
        log.info("**2**");
        sortedList.forEach(System.out::println);
        List<Integer> numberSort = listNumbers.stream().sorted().collect(Collectors.toList());
        log.info("**3**");
        numberSort.forEach(System.out::println);
    }
}