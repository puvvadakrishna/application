package com.shopping.phone.iphone;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class IphoneData extends Phone {

	private String modelColour;
	private String modelNo;
	private String modelPrice;



	public IphoneData(String modelNo, String modelPrice, String modelColour) {

		this.modelNo = modelNo;
		this.modelPrice = modelPrice;
		this.modelColour = modelColour;
	}
	@Override
	public String toString() {
		return "IphoneData{" +
				"modelColour='" + modelColour + '\'' +
				", modelNo='" + modelNo + '\'' +
				", modelPrice='" + modelPrice + '\'' +
				'}';
	}

}
