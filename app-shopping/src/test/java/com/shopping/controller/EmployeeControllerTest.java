package com.shopping.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.shopping.entity.Employee;
import com.shopping.repo.EmployeeRepository;
import com.shopping.service.EmployeeService;
import com.shopping.validator.PayLoadValidatorRunner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(value = EmployeeController.class)
class EmployeeControllerTest {
  @Autowired private MockMvc mockMvc;
  @MockBean private UserDetailsService userDetailsService;
  @MockBean private EmployeeRepository employeeRepository;
  @MockBean private EmployeeService employeeService;
  @MockBean private PayLoadValidatorRunner payLoadValidatorRunner;

  @Test
  @WithMockUser(
      username = "user",
      roles = {"USER"})
  void saveEmployee() throws Exception {

    String payLoad = "{\"id\":\"10\",\"name\":\"rama\"}";
    when(employeeService.save(any())).thenReturn(new Employee());

    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/employee")
                .content(payLoad)
                .contentType("application/json")
                .with(csrf())) // CSRF token is required
        .andExpect(status().isOk());
//        .andExpect(content().string(""));
  }
}
