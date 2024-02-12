package com.shopping.service;

import com.shopping.entity.PhoneModel;
import com.shopping.exception.ModelNotFoundException;
import com.shopping.repo.PhoneModelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
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

        List<PhoneModel> model = models.stream().map(this::updateColor).collect(Collectors.toList());
        return modelRepository.saveAll(model);
    }

    @Cacheable(value = "testCache", key = "{#modelNo}")
    @Override
    public PhoneModel getPhoneModelByModelNo(String modelNo) {

        log.info("--------------------------------------------------------------------------");
        log.info("-----------cache not worked, trying to load from database-----------------");
        log.info("--------------------------------------------------------------------------");


        return modelRepository.findByModelNo(modelNo);
    }

    private PhoneModel updateColor(PhoneModel modle) {
        modle.setModelColour(modle.getModelColour().toUpperCase());
        return modle;
    }

    public Long addPhone(PhoneModel pm)
    {
        return modelRepository.save(pm).getId();
    }

    public void deletePhone(String modelPrice)
    {
        modelRepository.deleteBymodelPrice(modelPrice);
    }

    @Override
    public List<PhoneModel> findByModelColour(String modelColour) {
        List<PhoneModel> pm = modelRepository.findByModelColour(modelColour);
        if (!pm.isEmpty()) {
            return pm;
        } else {
            throw new ModelNotFoundException("colour not found :"+modelColour);
        }
    }
}
