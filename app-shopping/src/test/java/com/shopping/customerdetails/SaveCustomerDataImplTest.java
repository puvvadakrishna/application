package com.shopping.customerdetails;

import com.shopping.customerdetails.save.SaveCustomerDataImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class SaveCustomerDataImplTest {
    SaveCustomerDataImpl scd = new SaveCustomerDataImpl();
    @Test
    void getNameAndAdressTest()
    {
        assertEquals("coventry",scd.getNameAndAdress("somu"));
    }
    @Test
    void getNameAndAdressTest_With_WrongData()
    {
        assertEquals("",scd.getNameAndAdress("Anj"));
    }

    @Test
    void saveNewUserTest()
    {

        assertEquals("yash",scd.saveNewUser("yash","USA"));
    }
}
