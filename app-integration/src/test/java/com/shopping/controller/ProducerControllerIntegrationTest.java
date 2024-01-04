package com.shopping.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import org.apache.kafka.clients.consumer.Consumer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.servlet.resource.HttpResource;

import com.shopping.entity.Order;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EmbeddedKafka(topics = {"library-events"}, partitions = 3)
@TestPropertySource(properties = {"spring.kafka.producer.bootstrap-servers=${spring.embedded.kafka.brokers}",
        "spring.kafka.admin.properties.bootstrap.servers=${spring.embedded.kafka.brokers}"})
class ProducerControllerIntegrationTest {

    @Autowired
    TestRestTemplate template;

    private Consumer<Integer, String> consumer;

    @Test
    void publish() {

        Order order = Order.builder().name("rama").quantity(33).build();
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Order> entity = new HttpEntity<>(order, header);
        ResponseEntity<String> response = template.exchange("/api/v1/kafka/publish", HttpMethod.POST, entity, String.class);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    void publishPOJO() {
    }
}