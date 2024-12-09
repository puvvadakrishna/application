package com.shopping.controller;

import com.shopping.kafka.producer.Producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/bean")
public class DynamicBeanInvockationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

    @Autowired private Map<String, com.shopping.controller.OrderProcesser> orderProcesserMap;

    @GetMapping
    public ResponseEntity<String> publish(@RequestParam("message") String message) {
        return ResponseEntity.status(HttpStatus.OK).body(orderProcesserMap.get(message).test());
    }
}
