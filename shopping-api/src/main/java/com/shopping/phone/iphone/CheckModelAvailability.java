package com.shopping.phone.iphone;

import com.shopping.exception.ProductNotFoundException;

public interface CheckModelAvailability {

	IphoneData isModelAvailable(String modelNo) throws ProductNotFoundException;
}
