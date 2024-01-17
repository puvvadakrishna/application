package com.shopping.deliverypartner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DeliveryHubImpl implements DeliveryHub {

	private static final Logger LOGGER = LoggerFactory.getLogger(DeliveryHubImpl.class);

	@Override
	public String deliver(String customerName, String address) {
		LOGGER.info("IPhone delivered to {} address {} ", customerName, address);


		return "delivered to " +address;

	}
}
