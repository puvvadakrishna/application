package src.main.java.com.example.useful.example;

import java.util.List;

public interface PhoneService {

    PhoneModel savePhone(PhoneModel data);

    List<PhoneModel> savePhones(List<PhoneModel> data);

    PhoneModel getPhoneModelByModelNo(String modelNo);

    Long addPhone(PhoneModel pm);

    void deletePhone(String modelPrice);

    List<PhoneModel> findByModelColour(String modelColour);
}
