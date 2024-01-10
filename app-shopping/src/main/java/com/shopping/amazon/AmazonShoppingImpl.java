package com.shopping.amazon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopping.amazon.util.InputReaderUtil;
import com.shopping.delivery.GetDeliveryDetails;
import com.shopping.exception.ProductNotFoundException;
import com.shopping.phone.iphone.CheckModelAvailability;
import com.shopping.phone.iphone.IphoneData;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AmazonShoppingImpl implements AmazonShopping {

    private Logger log = LoggerFactory.getLogger(AmazonShoppingImpl.class);

    private GetDeliveryDetails gd;
    private CheckModelAvailability sid;


    public boolean orderPhone(String phoneModel, String details) {
        try {

            IphoneData phone = sid.isModelAvailable(phoneModel);
            log.info("selected product details are {}", phone);
            log.info("Do you want to purchase Y/N");
            String input = InputReaderUtil.readConfirmation();
            if (input.equalsIgnoreCase("y")) {
                return gd.deliverOrder(details);
            } else {
                log.info("Do you want to look another phone?Y/N : ");
            }
        } catch (ProductNotFoundException e) {
            log.error(e.getMessage());
        }
        return false;
    }

}
