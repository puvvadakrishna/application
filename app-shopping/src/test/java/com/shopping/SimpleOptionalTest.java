package com.shopping;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

// @SpringBootTest
class SimpleOptionalTest {
  @Test
  void opp() {

    int min1 = Arrays.stream(new int[] {1, 2, 3, 4, 5}).min().orElse(0);
    assertEquals(1, min1);
  }

  @Test
  void oppFalse() {
    int min2 = Arrays.stream(new int[] {}).min().orElse(0);
    assertEquals(0, min2);
  }
}
