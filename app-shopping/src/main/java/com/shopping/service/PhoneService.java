package com.shopping.service;

import com.shopping.entity.PhoneModel;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface PhoneService {

  PhoneModel savePhone(PhoneModel data);

  List<PhoneModel> savePhones(List<PhoneModel> data);

  PhoneModel getPhoneModelByModelNo(String modelNo);

  Long addPhone(PhoneModel pm);

  void deletePhone(String modelPrice);

  List<PhoneModel> findByModelColour(String modelColour);
}
