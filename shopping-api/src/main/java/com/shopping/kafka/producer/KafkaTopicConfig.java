package com.shopping.kafka.producer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic producerJsonTopic(){
        return TopicBuilder.name("producer_json")
                .build();
    }

    @Bean
    public NewTopic producerStringTopic(){
        return TopicBuilder.name("producer_string")
                .build();
    }
}