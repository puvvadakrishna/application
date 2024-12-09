package com.shopping.controller;

import com.shopping.model.Employee;
import com.shopping.repo.EmployeeRepository;
import com.shopping.service.EmployeeService;
import com.shopping.validator.PayLoadValidatorRunner;

import lombok.AllArgsConstructor;

import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    private final EmployeeService employeeService;
    private final PayLoadValidatorRunner payLoadValidatorRunner;

    @GetMapping("/all")
    @Secured("ROLE_USER")
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping
    public Optional<Employee> getEmployees(@RequestParam Long id) {
        return employeeService.findById(id);
    }

    @PostMapping
    @Secured("ROLE_USER")
    public Employee save(@RequestBody Employee emp) {
        payLoadValidatorRunner.validateRequestPayLoad(emp);
        return employeeService.save(emp);
    }
}
