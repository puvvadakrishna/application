package com.shopping.customer.purchase;

import com.shopping.amazon.AmazonShopping;
import com.shopping.amazon.util.InputReaderUtil;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PurchaseSomethingImpl implements PurchaseSomething {

  private static final Logger LOGGER = LoggerFactory.getLogger(PurchaseSomethingImpl.class);

  private final AmazonShopping as;

  public boolean placeOrder(String details) {
    LOGGER.info("pls enter the phone model  : ");
    String phone = InputReaderUtil.readModel();
    return as.orderPhone(phone, details);
  }
}
