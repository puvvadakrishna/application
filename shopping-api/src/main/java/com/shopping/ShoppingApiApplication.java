package com.shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.shopping.welcome.WelcomeUser;

@SpringBootApplication
public class ShoppingApiApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(ShoppingApiApplication.class, args);
		WelcomeUser wl =  applicationContext.getBean(WelcomeUser.class);
		wl.welcome();
	}

}
