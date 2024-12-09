package com.cucumber;

public class Validator {

  public static String validate(String today) {

    return "Friday".equals(today) ? "yes" : "nope";
  }
}
