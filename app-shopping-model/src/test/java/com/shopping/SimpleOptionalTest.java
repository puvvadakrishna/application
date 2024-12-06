package com.shopping;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

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
