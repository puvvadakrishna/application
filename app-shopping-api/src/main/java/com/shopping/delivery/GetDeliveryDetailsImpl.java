package com.shopping.delivery;

import com.shopping.customerdetails.save.SaveCustomerData;
import com.shopping.deliverypartner.DeliveryHub;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GetDeliveryDetailsImpl implements GetDeliveryDetails {
  private static final Logger LOGGER = LoggerFactory.getLogger(GetDeliveryDetailsImpl.class);

  private final SaveCustomerData scd;

  private final DeliveryHub dh;

  public GetDeliveryDetailsImpl(SaveCustomerData scd, DeliveryHub dh) {
    this.scd = scd;
    this.dh = dh;
  }

  public boolean deliverOrder(String customerName) {

    String customerAdress = scd.getNameAndAdress(customerName);
    if (customerAdress.isEmpty()) {
      LOGGER.info("Pls enter correct details");
      return false;

    } else {
      dh.deliver(customerName, customerAdress);
      return true;
    }
  }
}
