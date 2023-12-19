package com.shopping.kafka.producer;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendMessage(Order order) throws ExecutionException, InterruptedException {
        LOGGER.info(String.format("Message sent -> %s", order));
        kafkaTemplate.send(AppConstants.TOPIC_JSON, order).get();
        kafkaTemplate.send(AppConstants.TOPIC_JSON, "test-message").get();
        kafkaTemplate.send(AppConstants.TOPIC_JSON, 1).get();
        //LOGGER.info("kafka producer response: {}", future.toString());

    }
}