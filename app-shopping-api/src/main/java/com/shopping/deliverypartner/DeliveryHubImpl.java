package com.shopping.deliverypartner;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DeliveryHubImpl implements DeliveryHub {

    @Override
    public String deliver(String customerName, String address) {
        log.info("IPhone delivered to {} address {} ", customerName, address);
        return "delivered to " + address;
    }
}
