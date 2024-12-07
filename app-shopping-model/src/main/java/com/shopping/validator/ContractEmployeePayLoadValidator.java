package com.shopping.validator;

import com.shopping.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class ContractEmployeePayLoadValidator extends PayLoadValidator<Employee> {

  @Override
  boolean shouldValidate(Employee payload) {

    return payload.getEmploymentType().equalsIgnoreCase("CONTRACT");
  }

  @Override
  void validatePayLoad(Employee payload) {

    if (payload.getId() == 10) {
      throw new RuntimeException("Id can't be for a Contract employee");
    }
  }
}
