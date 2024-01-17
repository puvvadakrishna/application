
package com.shopping.welcome;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.shopping.amazon.util.InputReaderUtil;
import com.shopping.customer.purchase.PurchaseSomething;
import com.shopping.customerdetails.save.SaveCustomerData;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class WelcomeUser {

	private static final Logger LOGGER = LoggerFactory.getLogger(WelcomeUser.class);
	private final SaveCustomerData scd;
	private final PurchaseSomething ps;

	public boolean welcome() {
		LOGGER.info("Hello welcome to Amazon,Are you new user ? y/n ");
		String input = InputReaderUtil.readConfirmation();
		if (input.equals("y")) {
			String result = newUser();
			return ps.placeOrder(result);
		} else {
			LOGGER.info("pls enter your name : ");
			String name = InputReaderUtil.readName();
			LOGGER.info("Welcome {}", name);
			return ps.placeOrder(name);

		}

	}

	private String newUser() {

		LOGGER.info("pls register your details : ");
		LOGGER.info("pls enter your name : ");
		String name = InputReaderUtil.readName();
		LOGGER.info("Pls enter your address : ");
		String address = InputReaderUtil.readAddress();
		LOGGER.info("Thank you for registration,pls continue shopping");
		return scd.saveNewUser(name, address);

	}

}
