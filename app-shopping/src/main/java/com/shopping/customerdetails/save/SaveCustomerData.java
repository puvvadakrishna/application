package com.shopping.customerdetails.save;

public interface SaveCustomerData {
    String getNameAndAdress(String model);

    String saveNewUser(String name, String adress);

}
