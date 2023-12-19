package com.example.learning.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.retry.annotation.Backoff;
import com.example.learning.kafka.exceptions.CustomException;
import com.example.learning.kafka.producer.Order;
//@Service
//@KafkaListener(topics = AppConstants.TOPIC_JSON,
//        groupId = AppConstants.GROUP_ID)
public class Consumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @KafkaHandler
    public void consume(@Payload Order message) throws CustomException {

        //throw new CustomException();

        LOGGER.info(String.format("Order received: %s", message));
    }

    @KafkaHandler
    @RetryableTopic(
            backoff = @Backoff(value = 3000L),
            attempts = "3",
            autoCreateTopics = "true",
            include = CustomException.class, exclude = NullPointerException.class)
    public void consumerGroup(String message) throws CustomException {
        //throw new CustomException();

        LOGGER.info(String.format("String Message received: %s", message));
    }

    @KafkaHandler(isDefault = true)
    public void defaultHandler(Object message) {
        LOGGER.info(String.format("Default message received: %s", message));
    }
}


