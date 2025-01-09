package src.main.java.com.example.useful.example;


import lombok.extern.slf4j.Slf4j;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

@Component
@Slf4j
public class PhoneServiceImpl implements PhoneService {
    private final PhoneModelRepository modelRepository;
    private final SimRepository simRepo;

    public PhoneServiceImpl(PhoneModelRepository modelRepository, SimRepository simRepo) {
        this.modelRepository = modelRepository;
        this.simRepo = simRepo;
    }

    public PhoneModel savePhone(PhoneModel model) {
        return modelRepository.save(updateColor(model));
    }

    public List<PhoneModel> savePhones(List<PhoneModel> models) {

        List<PhoneModel> model =
                models.stream().map(this::updateColor).collect(Collectors.toList());
        return modelRepository.saveAll(model);
    }

    @Override
    public List<PhoneModel> findByModelColour(String modelColour) {
        List<PhoneModel> pm = modelRepository.findByModelColour(modelColour);
        if (!pm.isEmpty()) {
            return pm;
        } else {
            throw new ModelNotFoundException("Not found :" + modelColour);
        }
    }

    public Sim savePhone(Sim model) {
        return simRepo.save(model);
    }

    @Cacheable(value = "testCache", key = "key1")
    public PhoneModel getPhoneModelByModelNo(String modelNo) {
        return modelRepository.findByModelNo(modelNo);
    }

    private PhoneModel updateColor(PhoneModel modle) {
        modle.setModelColour(modle.getModelColour().toUpperCase());
        return modle;
    }

    public Long addPhone(PhoneModel pm) {
        return modelRepository.save(pm).getId();
    }

    @Transactional
    public void deletePhone(String modelPrice) {
        modelRepository.deleteBymodelPrice(modelPrice);
    }
}
