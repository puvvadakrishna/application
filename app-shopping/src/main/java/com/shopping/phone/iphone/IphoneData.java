package com.shopping.phone.iphone;

public class IphoneData extends Phone {

	private String modelColour;
	private String modelNo;
	private String modelPrice;

	public IphoneData(String modelNo, String modelPrice, String modelColour) {

		this.modelNo = modelNo;
		this.modelPrice = modelPrice;
		this.modelColour = modelColour;
	}

	public String getModelColour() {
		return modelColour;
	}

	public void setModelColour(String modelColour) {
		this.modelColour = modelColour;
	}

	public String getModelNo() {
		return modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	public String getModelPrice() {
		return modelPrice;
	}

	public void setModelPrice(String modelPrice) {
		this.modelPrice = modelPrice;
	}

	@Override
	public String toString() {
		return "IphoneData [modelColour=" + modelColour + ", modelNo=" + modelNo + ", modelPrice=" + modelPrice + "]";
	}

}
