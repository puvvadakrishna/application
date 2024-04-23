package com.shopping.service;

import com.shopping.entity.PhoneModel;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public interface PhoneService {

    PhoneModel savePhone(PhoneModel data);

    List<PhoneModel> savePhones(List<PhoneModel> data);

    PhoneModel getPhoneModelByModelNo(String modelNo);

    Long addPhone(PhoneModel pm);

    void deletePhone(String modelPrice);

    List<PhoneModel> findByModelColour(String modelColour);
}
