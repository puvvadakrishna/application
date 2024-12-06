package com.cucumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java8.En;

public class Learning implements En {

  String today;

  String actualAnswer;

  public Learning() {
    // TODO Auto-generated constructor stub
    Given(
        "today is Sunday",
        () -> {
          today = "Sunday";
        });

    When(
        "I ask whether it's Friday yet",
        () -> {
          actualAnswer = Validator.validate(today);
        });

    Then(
        "I should be told {string}",
        (String answer) -> {
          assertEquals(actualAnswer, answer);
        });

    Given(
        "today is {string}",
        (String day) -> {
          today = day;
        });
  }
}
