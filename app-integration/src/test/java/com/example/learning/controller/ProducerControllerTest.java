package com.example.learning.controller;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.example.learning.kafka.producer.Producer;
import com.example.learning.kafka.producer.Order;
// test slice
@WebMvcTest(KafkaProducerController.class)
class ProducerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private Producer producer;

    @Test
    void publish() throws Exception {

        when(producer.sendMessageSync(isA(Order.class))).thenReturn(null);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/kafka/publish").content("{\n" +
                        "    \"id\": \"123\",\n" +
                        "    \"name\": \"123\"\n" +
                        "}").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
}