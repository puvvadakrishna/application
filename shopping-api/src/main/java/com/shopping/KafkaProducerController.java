package com.shopping;

import java.util.concurrent.ExecutionException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.kafka.producer.KafkaProducer;
import com.shopping.kafka.producer.Order;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaProducerController {

    private KafkaProducer kafkaProducer;

    public KafkaProducerController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping("/publish")
    public ResponseEntity<Order> publish(@RequestParam("message") String message) throws ExecutionException, InterruptedException {
        return ResponseEntity.ok(Order.builder().name("rama").id("12").build());
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publishPOJO(@RequestBody Order order) throws ExecutionException, InterruptedException {
        kafkaProducer.sendMessage(order);
        return ResponseEntity.ok("Message sent to kafka topic");
    }
}