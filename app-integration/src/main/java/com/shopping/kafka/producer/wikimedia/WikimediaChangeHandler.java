package com.shopping.kafka.producer.wikimedia;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;

public class WikimediaChangeHandler implements EventHandler {

  private final Logger log = LoggerFactory.getLogger(WikimediaChangeHandler.class.getSimpleName());
  String topic;
  private KafkaTemplate kafkaTemplate;

  public WikimediaChangeHandler(KafkaTemplate<String, String> kafkaTemplate, String topic) {
    this.kafkaTemplate = kafkaTemplate;
    this.topic = topic;
  }

  @Override
  public void onOpen() {
    // nothing here
  }

  @Override
  public void onClosed() {
    kafkaTemplate.destroy();
  }

  @Override
  public void onMessage(String event, MessageEvent messageEvent) {
    log.info(messageEvent.getData());
    // asynchronous
    kafkaTemplate.send(new ProducerRecord<>(topic, messageEvent.getData()));
  }

  @Override
  public void onComment(String comment) {
    // nothing here
  }

  @Override
  public void onError(Throwable t) {
    log.error("Error in Stream Reading", t);
  }
}
