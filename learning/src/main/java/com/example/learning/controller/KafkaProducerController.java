package com.example.learning.controller;

import java.util.concurrent.ExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.learning.kafka.producer.Order;
import com.example.learning.kafka.producer.Producer;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaProducerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

    private final Producer producer;

    public KafkaProducerController(Producer producer) {
        this.producer = producer;
    }

    @GetMapping("/publish")
    public ResponseEntity<Order> publish(@RequestParam("message") String message) throws ExecutionException, InterruptedException {
        return ResponseEntity.ok(Order.builder().name("rama").id("12").build());
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publishPOJO(@RequestBody Order order) throws ExecutionException, InterruptedException {
        LOGGER.info("Before sending the message..");
        producer.sendMessageSync(order);
        LOGGER.info("After sending the message..");
        return ResponseEntity.status(HttpStatus.CREATED).body("Message sent to kafka topic");
    }
}