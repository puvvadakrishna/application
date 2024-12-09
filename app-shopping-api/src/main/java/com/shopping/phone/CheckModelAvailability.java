package com.shopping.phone;

import com.shopping.entity.PhoneModel;
import com.shopping.exception.ProductNotFoundException;

import java.util.Optional;

public interface CheckModelAvailability {

    Optional<PhoneModel> isModelAvailable(String modelNo) throws ProductNotFoundException;
}
