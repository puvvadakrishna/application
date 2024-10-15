package com.shopping.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;

import com.shopping.kafka.exceptions.CustomException;
import com.shopping.kafka.producer.AppConstants;
import com.shopping.kafka.producer.Order;

// @Service
@KafkaListener(topics = AppConstants.TOPIC_JSON, groupId = AppConstants.GROUP_ID)
public class HandlerConsumer {

  private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

  @KafkaHandler
  public void consume(@Payload Order message, Acknowledgment ack) throws CustomException {

    // throw new CustomException();

    LOGGER.info(String.format("Order received: %s", message));
    ack.acknowledge();
  }

  @KafkaHandler
  @RetryableTopic(
      backoff = @Backoff(value = 3000L),
      attempts = "3",
      autoCreateTopics = "true",
      include = CustomException.class,
      exclude = NullPointerException.class)
  public void consumerGroup(String message) throws CustomException {
    // throw new CustomException();

    LOGGER.info(String.format("String Message received: %s", message));
  }

  @KafkaHandler(isDefault = true)
  public void defaultHandler(Object message) {
    LOGGER.info(String.format("Default message received: %s", message));
  }
}
