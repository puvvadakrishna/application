package com.shopping.kafka.producer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
public class Producer {

  private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

  @Autowired private KafkaTemplate kafkaTemplate;

  public void sendMessageAsync(Order order) throws ExecutionException, InterruptedException {
    CompletableFuture<SendResult<String, Order>> result =
        (CompletableFuture<SendResult<String, Order>>)
            kafkaTemplate.send(AppConstants.TOPIC_JSON, order.getId(), order);
    // kafkaTemplate.send(AppConstants.TOPIC_JSON, "test-message");
    // kafkaTemplate.send(AppConstants.TOPIC_JSON, 1);
    // result.get();-- to hold the sync call until message is sent
    result.whenComplete(
        (sendResult, throwable) -> {
          if (throwable != null) {
            failure(throwable);
          } else {
            success(sendResult, order);
          }
        });
  }

  public SendResult<String, Order> sendMessageSync(Order order)
      throws ExecutionException, InterruptedException {

    List<Header> headers = new ArrayList<>();
    headers.add(new RecordHeader("kafka_receivedTopic", AppConstants.TOPIC_JSON.getBytes()));
    ProducerRecord<String, Order> record =
        new ProducerRecord<>(AppConstants.TOPIC_JSON, null, order.getId(), order, headers);

    // producer.send(record);

    SendResult<String, Order> result = (SendResult<String, Order>) kafkaTemplate.send(record).get();
    // kafkaTemplate.send(AppConstants.TOPIC_JSON, "test-message");
    // kafkaTemplate.send(AppConstants.TOPIC_JSON, 1);
    // result.get();-- to hold the sync call until message is sent
    success(result, order);

    return result;
  }

  private void success(SendResult<String, Order> sendResult, Order order) {
    LOGGER.info(
        "Message sent to kafka {} and at partition {}",
        order,
        sendResult.getRecordMetadata().partition());
  }

  private void failure(Throwable throwable) {
    LOGGER.info("Failed to send the message with error {}", throwable.getMessage());
  }
}
