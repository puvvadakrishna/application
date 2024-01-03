package com.shopping.customerdetails.save;

import java.io.Serializable;

public class Customer implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private String customerName;
	private String customerAddress;
	private String customerOrder;

	public Customer(String customerName, String customerAddress) {
		this.customerName = customerName;
		this.customerAddress = customerAddress;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerOrder() {
		return customerOrder;
	}

	public void setCustomerOrder(String customerOrder) {
		this.customerOrder = customerOrder;
	}

	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", customerAddress=" + customerAddress + ", customerOrder="
				+ customerOrder + "]";
	}

}
