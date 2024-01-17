package com.shopping.phone.iphone;

import java.util.List;
import java.util.Optional;

import com.shopping.entity.PhoneModel;
import org.springframework.stereotype.Component;
import com.shopping.exception.ProductNotFoundException;


@Component
public class CheckModelAvailabilityImpl implements CheckModelAvailability {

    static List<PhoneModel> phoneData = List.of(new PhoneModel("ip12", "10k", "white"),
            new PhoneModel("ip13", "30k", "pink"), new PhoneModel("ip14", "40k", "Black"),
            new PhoneModel("ip15", "50k", "Pink"), new PhoneModel("ip6", "60k", "Grey"));

    public  Optional<PhoneModel> isModelAvailable(String modelNo) {
        return Optional.ofNullable(phoneData.stream().filter(i -> i.getModelNo().equalsIgnoreCase(modelNo))
                .findFirst()
                .orElse(null));

    }
}
