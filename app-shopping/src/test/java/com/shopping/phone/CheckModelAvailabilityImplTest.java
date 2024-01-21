package com.shopping.phone;

import com.shopping.exception.ProductNotFoundException;
import com.shopping.entity.PhoneModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.Assert.*;

@ExtendWith(MockitoExtension.class)
class CheckModelAvailabilityImplTest {

    @InjectMocks
    CheckModelAvailabilityImpl cmai;

    @Test
    void isModelAvailableTest() throws ProductNotFoundException {
        assertEquals(new PhoneModel("ip13", "30k", "pink").toString(), cmai.isModelAvailable("ip13").get().toString());
    }

    //   @Test
    void isModelAvailableTest_invalidtest() {
        assertEquals(Optional.empty(), cmai.isModelAvailable("ip19"));
    }

}
