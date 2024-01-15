package com.shopping.phone.iphone;

import com.shopping.entity.PhoneModel;
import com.shopping.exception.ProductNotFoundException;

public interface CheckModelAvailability {

	PhoneModel isModelAvailable(String modelNo) throws ProductNotFoundException;
}
