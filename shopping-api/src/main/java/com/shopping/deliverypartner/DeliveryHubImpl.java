package com.shopping.deliverypartner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DeliveryHubImpl implements DeliveryHub {

	private Logger log = LoggerFactory.getLogger(DeliveryHubImpl.class);

	@Override
	public String deliver(String customerName, String address) {
		log.info("IPhone delivered to {} address {} ", customerName, address);


		return "delivered to " +address;

	}
}
