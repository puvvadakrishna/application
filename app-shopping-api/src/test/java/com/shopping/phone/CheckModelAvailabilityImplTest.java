package com.shopping.phone;

import static org.junit.Assert.assertEquals;

import com.shopping.entity.PhoneModel;
import com.shopping.exception.ProductNotFoundException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class CheckModelAvailabilityImplTest {

    @InjectMocks CheckModelAvailabilityImpl cmai;

    @Test
    void isModelAvailableTest() throws ProductNotFoundException {
        assertEquals(
                new PhoneModel("ip13", "30k", "pink").toString(),
                cmai.isModelAvailable("ip13").get().toString());
    }

    //   @Test
    void isModelAvailableTest_invalidtest() {
        assertEquals(Optional.empty(), cmai.isModelAvailable("ip19"));
    }
}
