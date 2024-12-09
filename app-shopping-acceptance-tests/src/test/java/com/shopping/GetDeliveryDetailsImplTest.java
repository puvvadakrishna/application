package com.shopping;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.shopping.customerdetails.save.SaveCustomerData;
import com.shopping.delivery.GetDeliveryDetailsImpl;
import com.shopping.deliverypartner.DeliveryHub;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GetDeliveryDetailsImplTest {
    @InjectMocks GetDeliveryDetailsImpl gdd;
    @Mock SaveCustomerData scd;
    @Mock DeliveryHub dh;

    @Test
    void deliverOrderTest() {
        when(scd.getNameAndAdress(anyString())).thenReturn("London");
        when(dh.deliver(anyString(), anyString())).thenReturn("delivered to London");
        Assertions.assertTrue(gdd.deliverOrder("somu"));
    }

    @Test
    void deliverOrderTest_WithFalse_Value() {
        when(scd.getNameAndAdress(anyString())).thenReturn("");
        Assertions.assertFalse(gdd.deliverOrder("somu"));
    }
}
