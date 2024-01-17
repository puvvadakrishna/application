package com.shopping.service;

import com.shopping.entity.PhoneModel;
import com.shopping.repo.PhoneModelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneServiceImpl implements PhoneService {

   private final PhoneModelRepository modelRepository;

    public PhoneServiceImpl(PhoneModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    public PhoneModel savePhone(PhoneModel model) {
        return modelRepository.save(updateColor(model));
    }

    @Override
    public List<PhoneModel> savePhones(List<PhoneModel> models) {

       List<PhoneModel> model = models.stream().map(modle->updateColor(modle)).collect(Collectors.toList());
        return modelRepository.saveAll(model);
    }

    private PhoneModel updateColor(PhoneModel modle) {
        modle.setModelColour(modle.getModelColour().toUpperCase());
        return modle;
    }

}
