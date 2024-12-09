package com.shopping.steps;

import static org.junit.Assert.assertEquals;

import com.shopping.vaidation.Validator;

import io.cucumber.java8.En;

public class Stepdefinitions implements En {

    String today;
    String actualAnswer;

    public Stepdefinitions() {

        Given(
                "^today is \"([^\"]*)\"$",
                (String day) -> {
                    today = day;
                });

        When(
                "I ask whether it's Friday yet",
                () -> {
                    actualAnswer = Validator.validate(today);
                });
        Then(
                "I should be told {string}",
                (String resultAnswer) -> {
                    assertEquals(actualAnswer, resultAnswer);
                });
        Given(
                "^today is Sunday$",
                () -> {
                    today = "Sunday";
                });
    }
}
