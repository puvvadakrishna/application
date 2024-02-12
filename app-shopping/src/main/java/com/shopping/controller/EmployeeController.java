package com.shopping.controller;

import com.shopping.entity.Employee;
import com.shopping.repo.EmployeeRepository;
import com.shopping.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class EmployeeController {


    private final EmployeeRepository employeeRepository;
    private final EmployeeService employeeService;


    @GetMapping("/all")
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }


    @GetMapping
    public Optional<Employee> getEmployees(@RequestParam Long id) {
        return employeeService.findById(id);
    }


    @PostMapping
    public Employee save(@RequestBody Employee emp) {
        return employeeService.save(emp);
    }
}