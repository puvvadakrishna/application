package com.shopping.validator;

import com.shopping.entity.Employee;

public class PermenantEmployeePayLoadValidator extends PayLoadValidator<Employee> {

  @Override
  boolean shouldValidate(Employee payload) {

    return payload.getEmploymentType().equalsIgnoreCase("CONTRACT");
  }

  @Override
  void validatePayLoad(Employee payload) {

    
  }
}
