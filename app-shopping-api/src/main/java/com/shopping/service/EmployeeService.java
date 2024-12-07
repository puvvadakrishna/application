package com.shopping.service;

import com.shopping.model.Employee;
import com.shopping.exception.RecordNotFoundException;
import com.shopping.repo.EmployeeRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeService {

  private final EmployeeRepository employeeRepository;

  public Employee save(Employee emp) {

    emp.setLastname(emp.getLastname() + " funny!!");
    return employeeRepository.save(emp);
  }

  public Optional<Employee> findById(Long id) {

    Optional<Employee> emp = employeeRepository.findById(id);
    if (emp.isPresent()) {
      return emp;
    } else {
      throw new RecordNotFoundException("id:" + id);
    }
  }
}
