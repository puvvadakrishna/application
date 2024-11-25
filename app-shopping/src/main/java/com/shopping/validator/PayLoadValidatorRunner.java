package com.shopping.validator;

import java.util.List;

public class PayLoadValidatorRunner {

  List<PayLoadValidator> validatorList;

  public void validateRequestPayLoad(RequestPayLoad payload) {

    validatorList.stream()
        .filter(validator -> validator.shouldValidate(payload))
        .findFirst()
        .ifPresent(validator -> validator.validatePayLoad(payload));
  }
}
