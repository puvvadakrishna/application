package com.shopping.controller;

import com.config.TestSecurityConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

@WebMvcTest(value = SampleControllerTest.class)
class SampleControllerTest {
  @Autowired private MockMvc mockMvc;
  @MockBean private UserDetailsService userDetailsService;

  @Test
  void getCustomerTest() throws Exception {
    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/amazon/customer?name=somu");
    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
    String expected =
        "{\"customerName\":\"somu\",\"customerAddress\":\"guntur\",\"customerOrder\":null}";
    assertEquals(expected, result.getResponse().getContentAsString());
  }

}
