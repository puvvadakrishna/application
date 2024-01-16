package com.shopping.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import com.shopping.kafka.exceptions.CustomException;
import com.shopping.kafka.producer.AppConstants;
import com.shopping.kafka.producer.Order;
@Service
public class Consumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    //method to also get the headers , sent by producter-messages
    @KafkaListener(topics = AppConstants.TOPIC_JSON, containerFactory = "kafkaListenerContainerFactory",
            groupId = AppConstants.GROUP_ID)
    public void consume(@Payload Order message,
                        @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                        Acknowledgment ack) throws CustomException {

        LOGGER.info("Order received: {}", message);
        //LOGGER.info("key received: {}", key);
        LOGGER.info("topic received: {}", topic);
        //LOGGER.info("partition received: %s", partition);

        //throw new CustomException();

        LOGGER.info(String.format("Order received: %s", message));
        ack.acknowledge();
    }

    //@KafkaListener(topics = AppConstants.TOPIC_JSON, containerFactory = "kafkaListenerContainerFactory",
    //        groupId = AppConstants.GROUP_ID)
    //@RetryableTopic(
    //        backoff = @Backoff(value = 3000L),
    //        attempts = "3",
    //        autoCreateTopics = "true",
    //        include = CustomException.class, exclude = NullPointerException.class)
    public void consumerGroup(String message) throws CustomException {
        //throw new CustomException();

        LOGGER.info(String.format("String Message received: %s", message));
    }

    //@KafkaListener(topics = AppConstants.TOPIC_JSON, containerFactory = "kafkaListenerContainerFactory",
    //        groupId = AppConstants.GROUP_ID)
    public void defaultHandler(Object message) {
        LOGGER.info(String.format("Default message received: %s", message));
    }
}


