package com.shopping.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class PayLoadValidatorRunner {

  private final List<PayLoadValidator> validatorList;

  public void validateRequestPayLoad(RequestPayLoad payload) {

    validatorList.stream()
        .filter(validator -> validator.shouldValidate(payload))
        .findFirst()
        .ifPresent(validator -> validator.validatePayLoad(payload));
  }
}
