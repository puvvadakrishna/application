package com.shopping.phone;

import com.shopping.exception.ProductNotFoundException;
import com.shopping.phone.iphone.CheckModelAvailabilityImpl;
import com.shopping.entity.PhoneModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.*;

@ExtendWith(MockitoExtension.class)
public class CheckModelAvailabilityImplTest {
    CheckModelAvailabilityImpl cmai = new CheckModelAvailabilityImpl();

    @Test
    void isModelAvailableTest() throws ProductNotFoundException {
       assertEquals(new PhoneModel("ip13", "30k", "pink").toString(),cmai.isModelAvailable("ip13").toString());
    }
    @Test
    void isModelAvailableTest_Exception() throws ProductNotFoundException {
        Exception exception = assertThrows(ProductNotFoundException.class, () -> {
            cmai.isModelAvailable("ip20");
        });
        String expectedMessage = "OUT OF STOCK";
        String actualMessage = exception.getMessage();
        //assertTrue(actualMessage.contains(expectedMessage));
        assertEquals("OUT OF STOCK",exception.getMessage());
    }
}
