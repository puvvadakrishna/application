package com.shopping.kafka.consumer;

import java.util.Objects;
import org.apache.kafka.common.TopicPartition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.ContainerCustomizer;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.util.backoff.BackOff;
import org.springframework.util.backoff.FixedBackOff;

import com.shopping.kafka.exceptions.CustomException;
import com.shopping.kafka.producer.ProducerConfiguration;
@Configuration
public class ConsumerConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerConfiguration.class);
    protected final KafkaProperties properties;
    @Autowired
    KafkaTemplate kafkaTemplate;

    @Value("${kafka.backoff.interval}")
    private Long interval;

    @Value("${kafka.backoff.max_failure}")
    private Long maxAttempts;

    @Value("${kafka.backoff.retry.topic}")
    private String retryTopic;

    @Value("${kafka.backoff.DLT}")
    private String deadLetterTopic;

    public ConsumerConfiguration(KafkaProperties properties) {
        this.properties = properties;
    }

    @Bean
    public DefaultErrorHandler errorHandler() {
        BackOff fixedBackOff = new FixedBackOff(interval, maxAttempts);
        //DefaultErrorHandler errorHandler = new DefaultErrorHandler((consumerRecord, e) -> {
        //    LOGGER.info("Error handler block :{}", consumerRecord.value());
        //}, fixedBackOff);
        //errorHandler.addNotRetryableExceptions(NullPointerException.class);

        DefaultErrorHandler defaultErrorHandler = new DefaultErrorHandler(
                //consumerRecordRecoverer
                publishingRecoverer(), fixedBackOff
                //expBackOff
        );
        defaultErrorHandler.addRetryableExceptions(CustomException.class);
        defaultErrorHandler.addNotRetryableExceptions(NullPointerException.class);

        defaultErrorHandler.setRetryListeners((record, ex, deliveryAttempt) -> LOGGER.info("Error handler block deliveryAttempt:{} for message  :{}", deliveryAttempt, record.value()));

        return defaultErrorHandler;
    }

    public DeadLetterPublishingRecoverer publishingRecoverer() {

        DeadLetterPublishingRecoverer recoverer = new DeadLetterPublishingRecoverer(kafkaTemplate, (r, e) -> {
            LOGGER.error("Exception in publishing Recoverer to topic:{} and error message {}:", retryTopic, deadLetterTopic, e);
            if (e.getCause() instanceof InterruptedException) {
                return new TopicPartition(retryTopic, r.partition());
            } else {
                return new TopicPartition(deadLetterTopic, r.partition());
            }
        });

        return recoverer;
    }

    @Bean
    ConcurrentKafkaListenerContainerFactory<?, ?> kafkaListenerContainerFactory(ConcurrentKafkaListenerContainerFactoryConfigurer configurer, ObjectProvider<ConsumerFactory<Object, Object>> kafkaConsumerFactory, ObjectProvider<ContainerCustomizer<Object, Object, ConcurrentMessageListenerContainer<Object, Object>>> kafkaContainerCustomizer) {
        ConcurrentKafkaListenerContainerFactory<Object, Object> factory = new ConcurrentKafkaListenerContainerFactory();
        configurer.configure(factory, kafkaConsumerFactory.getIfAvailable(() -> {
            return new DefaultKafkaConsumerFactory(this.properties.buildConsumerProperties());
        }));
        Objects.requireNonNull(factory);
        kafkaContainerCustomizer.ifAvailable(factory::setContainerCustomizer);
        factory.setCommonErrorHandler(errorHandler());
        factory.getContainerProperties().setAckCount(ContainerProperties.AckMode.MANUAL.ordinal());
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);
        factory.setConcurrency(1);
        return factory;
    }
}
