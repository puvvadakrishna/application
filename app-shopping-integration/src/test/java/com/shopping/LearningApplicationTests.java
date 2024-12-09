package com.shopping;

import io.cucumber.spring.CucumberContextConfiguration;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LearningApplicationTests {

    @Test
    void contextLoads() {}
}
