package com.shopping.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(value = SecuredController.class)
class SecuredControllerTest {
  @Autowired private MockMvc mockMvc;
  @MockBean private UserDetailsService userDetailsService;

  @Test
  @WithMockUser(
      username = "user",
      roles = {"USER"})
  void helloTest() throws Exception {

    mockMvc
        .perform(get("/").param("id", "123"))
        .andExpect(status().isOk())
        .andExpect(content().string("hello-123"));
  }
}
