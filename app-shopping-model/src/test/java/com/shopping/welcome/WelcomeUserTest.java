// package com.shopping.welcome;
//
// import com.shopping.amazon.util.InputReaderUtil;
// import com.shopping.customer.purchase.PurchaseSomething;
// import com.shopping.customerdetails.save.SaveCustomerData;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockedStatic;
// import org.mockito.Mockito;
// import org.mockito.junit.jupiter.MockitoExtension;
//
// import static org.junit.Assert.assertEquals;
// import static org.mockito.Mockito.when;
//
// @ExtendWith(MockitoExtension.class)
// public class WelcomeUserTest {
//    @InjectMocks
//    WelcomeUser wu;
//    @Mock
//    SaveCustomerData scd;
//    @Mock
//    PurchaseSomething ps;
//    @Test
//    void welcomeTest() {
//        try (MockedStatic<InputReaderUtil> utilities = Mockito.mockStatic(InputReaderUtil.class))
// {
//            utilities.when(InputReaderUtil::readConfirmation).thenReturn("y");
//            utilities.when(InputReaderUtil::readName).thenReturn("yash");
//            utilities.when(InputReaderUtil::readAddress).thenReturn("USA");
//            when(scd.saveNewUser("yash","USA")).thenReturn("yash");
//            when(ps.placeOrder("yash")).thenReturn(true);
//            assertEquals(true,wu.welcome());
//
//        }
//    }
//    @Test
//    void welcomeTest_WithNo() {
//        try (MockedStatic<InputReaderUtil> utilities = Mockito.mockStatic(InputReaderUtil.class))
// {
//            utilities.when(InputReaderUtil::readConfirmation).thenReturn("n");
//            utilities.when(InputReaderUtil::readName).thenReturn("somu");
//            when(ps.placeOrder("somu")).thenReturn(true);
//            assertEquals(true,wu.welcome());
//
//        }
//    }
// }
