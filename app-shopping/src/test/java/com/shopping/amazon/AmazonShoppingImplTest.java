package com.shopping.amazon;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.shopping.amazon.util.InputReaderUtil;
import com.shopping.delivery.GetDeliveryDetails;
import com.shopping.exception.ProductNotFoundException;
import com.shopping.phone.CheckModelAvailability;
import com.shopping.entity.PhoneModel;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class AmazonShoppingImplTest {

    @InjectMocks
    AmazonShoppingImpl as;

    @Mock
    private GetDeliveryDetails getDeliveryDetails;
    @Mock
    private CheckModelAvailability checkModelAvailability;

    @Test
    void orderPhone_with_confirmation_yes() throws ProductNotFoundException {
        when(getDeliveryDetails.deliverOrder(anyString())).thenReturn(true);
        when(checkModelAvailability.isModelAvailable(anyString())).thenReturn(Optional.of(new PhoneModel("ip13", "2000", "white")));
        try (MockedStatic<InputReaderUtil> utilities = Mockito.mockStatic(InputReaderUtil.class)) {
            utilities.when(InputReaderUtil::readConfirmation).thenReturn("Y");
            boolean result = as.orderPhone("ip13", "somu");

            assertEquals(true, result);
        }
    }

    @Test
    void orderPhone_with_confirmation_No() throws ProductNotFoundException {

        when(checkModelAvailability.isModelAvailable(anyString())).thenReturn(Optional.of(new PhoneModel("ip13", "2000", "white")));
        try (MockedStatic<InputReaderUtil> utilities = Mockito.mockStatic(InputReaderUtil.class)) {
            utilities.when(InputReaderUtil::readConfirmation).thenReturn("N");
            boolean result = as.orderPhone("ip13", "somu");

            assertFalse(result);
        }
    }

    @Test
     void whenDerivedExceptionThrown_thenAssertionSucceeds() {
        try {
            when(checkModelAvailability.isModelAvailable(anyString())).thenThrow(new ProductNotFoundException("OUT OF STOCK"));
        } catch (ProductNotFoundException e) {
            throw new RuntimeException(e);
        }
        assertFalse(as.orderPhone("ip2213", "somu"));
    }
}

