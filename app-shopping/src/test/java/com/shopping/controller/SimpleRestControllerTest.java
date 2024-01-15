package com.shopping.controller;

import com.shopping.customerdetails.save.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SimpleRestController.class)
class SimpleRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void helloTest() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/amazon/hello?name=ramu");

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "hello ramu";
        assertEquals(expected, result.getResponse().getContentAsString());
    }

    @Test
    void getCustomerTest() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/amazon/customer?name=somu");
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "{\"customerName\":\"somu\",\"customerAddress\":\"guntur\",\"customerOrder\":null}";
        assertEquals(expected, result.getResponse().getContentAsString());
    }

    @Test
    void saveUserTest() throws Exception {
        String customer = "{\"customerName\":\"somu\",\"customerAddress\":\"guntur\",\"customerOrder\":null}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/amazon/save")
                .accept(MediaType.APPLICATION_JSON).content(customer)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.CREATED.value(), response.getStatus());

    }

}
