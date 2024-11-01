package com.shopping.controller;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(SimpleRestController.class)
class SimpleRestControllerTest {
  @Autowired private MockMvc mockMvc;

  @Test
  void helloTest() throws Exception {

    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/amazon/hello?name=ramu");

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    String expected = "hello ramu";
    assertEquals(expected, result.getResponse().getContentAsString());
  }

  @Test
  void getCustomerTest() throws Exception {
    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/amazon/customer?name=somu");
    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    String expected =
        "{\"customerName\":\"somu\",\"customerAddress\":\"guntur\",\"customerOrder\":null}";
    assertEquals(expected, result.getResponse().getContentAsString());
  }

  @Test
  void saveUserTest() throws Exception {
    String customer =
        "{\"customerName\":\"somu\",\"customerAddress\":\"guntur\",\"customerOrder\":null}";
    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/amazon/save")
            .accept(MediaType.APPLICATION_JSON)
            .content(customer)
            .contentType(MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

    MockHttpServletResponse response = result.getResponse();
    assertEquals(HttpStatus.CREATED.value(), response.getStatus());
  }
}
