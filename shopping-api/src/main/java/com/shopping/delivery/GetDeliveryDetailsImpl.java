package com.shopping.delivery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.customerdetails.save.SaveCustomerData;
import com.shopping.deliverypartner.DeliveryHub;
import com.shopping.welcome.WelcomeUser;

@Service
public class GetDeliveryDetailsImpl implements GetDeliveryDetails {
	private Logger log = LoggerFactory.getLogger(GetDeliveryDetailsImpl.class);
	@Autowired
	private SaveCustomerData scd;
	@Autowired
	private DeliveryHub dh;

	public boolean deliverOrder(String customerName) {

		String customerAdress = scd.getNameAndAdress(customerName);
		if (customerAdress.equals("")) {
			log.info("Pls enter correct details");
			return false;

		} else {
			dh.deliver(customerName, customerAdress);
			return true;
		}
	}
}
