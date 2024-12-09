package com.shopping.phone;

import com.shopping.entity.PhoneModel;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Component
public class CheckModelAvailabilityImpl implements CheckModelAvailability {

    static List<PhoneModel> phoneData =
            List.of(
                    new PhoneModel("ip12", "10k", "white"),
                    new PhoneModel("ip13", "30k", "pink"),
                    new PhoneModel("ip14", "40k", "Black"),
                    new PhoneModel("ip15", "50k", "Pink"),
                    new PhoneModel("ip6", "60k", "Grey"));

    public Optional<PhoneModel> isModelAvailable(String modelNo) {

        Predicate<PhoneModel> phoneModelPredicate =
                phoneModel -> phoneModel.getModelNo().equalsIgnoreCase(modelNo);

        return Optional.ofNullable(
                phoneData.stream().filter(phoneModelPredicate).findFirst().orElse(null));
    }
}
