package com.shopping.controller;

import com.shopping.entity.Employee;
import com.shopping.repo.EmployeeRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping(path = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/all")
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping
    public Employee save(@RequestBody Employee emp) {
        return employeeRepository.save(emp);
    }

}