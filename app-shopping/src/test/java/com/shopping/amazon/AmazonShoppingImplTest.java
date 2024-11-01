package com.shopping.amazon;


import com.shopping.delivery.GetDeliveryDetails;
import com.shopping.phone.CheckModelAvailability;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AmazonShoppingImplTest {

  @InjectMocks AmazonShoppingImpl as;

  @Mock private GetDeliveryDetails getDeliveryDetails;
  @Mock private CheckModelAvailability checkModelAvailability;

  // @Test
  // void orderPhone_with_confirmation_yes() throws ProductNotFoundException {
  //    when(getDeliveryDetails.deliverOrder(anyString())).thenReturn(true);
  //    when(checkModelAvailability.isModelAvailable(anyString())).thenReturn(new IphoneData("ip13",
  // "2000", "white"));
  //    try (MockedStatic<InputReaderUtil> utilities = Mockito.mockStatic(InputReaderUtil.class)) {
  //        utilities.when(InputReaderUtil::readInput).thenReturn("Y");
  //        boolean result = as.orderPhone("ip13", "somu");
  //
  //        assertEquals(true, result);
  //    }
  // }

}
