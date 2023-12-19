package com.shopping.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.shopping.kafka.producer.AppConstants;
import com.shopping.kafka.producer.Order;

import org.springframework.messaging.handler.annotation.Payload;
@Service
//@KafkaListener(topics = AppConstants.TOPIC_JSON,
//        groupId = AppConstants.GROUP_ID)
public class KafKaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafKaConsumer.class);

    @KafkaHandler
    public void consume(@Payload Order message) {
        LOGGER.info(String.format("Order received: %s", message));
    }

    @KafkaHandler
    public void consumerGroup(String message) {
        LOGGER.info(String.format("String Message received: %s", message));
    }

    @KafkaHandler(isDefault = true)
    public void defaultHandler(Object message) {
        LOGGER.info(String.format("Default message received: %s", message));
    }
}


