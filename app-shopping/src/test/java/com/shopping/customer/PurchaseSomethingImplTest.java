//package com.shopping.customer;
//
//import com.shopping.amazon.AmazonShopping;
//import com.shopping.amazon.util.InputReaderUtil;
//import com.shopping.customer.purchase.PurchaseSomethingImpl;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockedStatic;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.when;
//@ExtendWith(MockitoExtension.class)
//public class PurchaseSomethingImplTest {
//    @InjectMocks
//    PurchaseSomethingImpl psi;
//    @Mock
//    AmazonShopping as;
//    @Test
//    void placeOrderTest()
//    {
//        try(MockedStatic<InputReaderUtil> utilities = Mockito.mockStatic(InputReaderUtil.class))
//        {
//            utilities.when(InputReaderUtil::readModel).thenReturn("ip13");
//            when(as.orderPhone(anyString(),anyString())).thenReturn(true);
//            assertEquals(true,psi.placeOrder("somu"));
//        }
//    }
//}
