package com.shopping.amazon;

import com.shopping.amazon.util.InputReaderUtil;
import com.shopping.delivery.GetDeliveryDetails;
import com.shopping.entity.PhoneModel;
import com.shopping.exception.ProductNotFoundException;
import com.shopping.phone.CheckModelAvailability;

import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AmazonShoppingImpl implements AmazonShopping {

    private static final Logger LOGGER = LoggerFactory.getLogger(AmazonShoppingImpl.class);

    private final GetDeliveryDetails gd;

    private final CheckModelAvailability sid;

    public boolean orderPhone(String phoneModel, String details) {
        try {

            Optional<PhoneModel> phone = sid.isModelAvailable(phoneModel);
            if (phone.isPresent()) {
                LOGGER.info("selected product details are {}", phone);
                LOGGER.info("Do you want to purchase Y/N");
                String input = InputReaderUtil.readConfirmation();
                if (input.equalsIgnoreCase("y")) {
                    return gd.deliverOrder(details);
                } else {
                    LOGGER.info("Do you want to look another phone?Y/N : ");
                }
            }
        } catch (ProductNotFoundException e) {
            LOGGER.error(e.getMessage());
        }
        return false;
    }
}
