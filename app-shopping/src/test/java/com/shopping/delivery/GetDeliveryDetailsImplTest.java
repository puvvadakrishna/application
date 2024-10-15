package com.shopping.delivery;

import com.shopping.customerdetails.save.SaveCustomerData;
import com.shopping.deliverypartner.DeliveryHub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GetDeliveryDetailsImplTest {
  @InjectMocks GetDeliveryDetailsImpl gdd;
  @Mock SaveCustomerData scd;
  @Mock DeliveryHub dh;

  @Test
  void deliverOrderTest() {
    when(scd.getNameAndAdress(anyString())).thenReturn("London");
    when(dh.deliver(anyString(), anyString())).thenReturn("delivered to London");
    assertEquals(true, gdd.deliverOrder("somu"));
  }

  @Test
  void deliverOrderTest_WithFalse_Value() {
    when(scd.getNameAndAdress(anyString())).thenReturn("");
    assertEquals(false, gdd.deliverOrder("somu"));
  }
}
