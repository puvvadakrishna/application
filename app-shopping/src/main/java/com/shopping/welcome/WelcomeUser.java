package com.shopping.welcome;

import com.shopping.amazon.util.InputReaderUtil;
import com.shopping.customer.purchase.PurchaseSomething;
import com.shopping.customerdetails.save.SaveCustomerData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class WelcomeUser {

  private final SaveCustomerData scd;
  private final PurchaseSomething ps;

  public boolean welcome() {
    log.info("Hello welcome to Amazon,Are you new user ? y/n ");
    String input = InputReaderUtil.readConfirmation();
    if (input.equals("y")) {
      String result = newUser();
      return ps.placeOrder(result);
    } else {
      log.info("pls enter your name : ");
      String name = InputReaderUtil.readName();
      log.info("Welcome {}", name);
      return ps.placeOrder(name);
    }
  }

  private String newUser() {

    log.info("pls register your details : ");
    log.info("pls enter your name : ");
    String name = InputReaderUtil.readName();
    log.info("Pls enter your address : ");
    String address = InputReaderUtil.readAddress();
    log.info("Thank you for registration,pls continue shopping");
    return scd.saveNewUser(name, address);
  }
}
