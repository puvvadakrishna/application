package com.shopping.phone.iphone;

import java.util.List;
import org.springframework.stereotype.Component;
import com.shopping.exception.ProductNotFoundException;

@Component
public class CheckModelAvailabilityImpl implements CheckModelAvailability {

	static List<IphoneData> phoneData = List.of(new IphoneData("ip12", "10k", "white"),
			new IphoneData("ip13", "30k", "pink"), new IphoneData("ip14", "40k", "Black"),
			new IphoneData("ip15", "50k", "Pink"), new IphoneData("ip6", "60k", "Grey"));

	public IphoneData isModelAvailable(String modelNo) throws ProductNotFoundException {
		for (int i = 0; i < phoneData.size(); i++) {
			if (phoneData.get(i).getModelNo().equalsIgnoreCase(modelNo)) {
				return phoneData.get(i);
			}
		}
		throw (new ProductNotFoundException("OUT OF STOCK"));
	}
}
