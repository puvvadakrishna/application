package com.shopping.controller;

import com.shopping.customerdetails.save.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("amazon")
public class SimpleRestController {

    @GetMapping("/hello")
    public ResponseEntity<String> hello(@RequestParam String name) {

        return ResponseEntity.ok().body("hello " + name);
    }

    @GetMapping("/customer")
    public ResponseEntity<Customer> getCustomer(@RequestParam String name) {

        return ResponseEntity.ok().body(new Customer(name, "guntur"));
    }


    @PostMapping("/save")
    public ResponseEntity<Customer> saveUser(@RequestBody Customer customer) {

       // return ResponseEntity.status(HttpStatus.CREATED).body(customer);
            return ResponseEntity.created(null).build();
    }
  }
