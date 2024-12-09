package com.snippet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.List;

public class StreamsMatcher {
    @Test
    public void test() {

        List<Integer> a = List.of();
        List<Integer> b = List.of(1, 2, 3);

        assertFalse(a.stream().anyMatch(b::contains));
        assertTrue(a.stream().allMatch(b::contains));
        assertFalse(b.stream().allMatch(a::contains));
        assertTrue(a.stream().noneMatch(b::contains));

        assertFalse(a.stream().anyMatch(value -> b.contains(value)));
        assertTrue(a.stream().allMatch(value -> b.contains(value)));
        assertFalse(b.stream().allMatch(value -> a.contains(value)));
        assertTrue(a.stream().noneMatch(value -> b.contains(value)));
        assertFalse(b.stream().anyMatch(value -> a.contains(value)));
    }
}
