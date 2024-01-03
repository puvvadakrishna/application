package com.shopping.customerdetails.save;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class SaveCustomerDataImpl implements SaveCustomerData {

	List<Customer> details = Arrays.asList(new Customer("somu", "coventry"), new Customer("Ram", "Hyderabad"),
			new Customer("Kush", "London"));

	public String getNameAndAdress(String name) {
		for (int i = 0; i < details.size(); i++) {
			Customer c = details.get(i);
			if (c.getCustomerName().equalsIgnoreCase(name)) {

				return c.getCustomerAddress();

			}
		}
		return "";
	}

	public String saveNewUser(String name, String adress) {
		details.set(1,new Customer(name, adress));
		return name;
	}

}
