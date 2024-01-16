package com.shopping.customer.purchase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.shopping.amazon.AmazonShopping;
import com.shopping.amazon.util.InputReaderUtil;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PurchaseSomethingImpl implements PurchaseSomething {

	private Logger log = LoggerFactory.getLogger(PurchaseSomethingImpl.class);

	private AmazonShopping as;

	public boolean placeOrder(String details) {
		log.info("pls enter the phone model  : ");
		String phone = InputReaderUtil.readModel();
		return as.orderPhone(phone, details);

	}

}
