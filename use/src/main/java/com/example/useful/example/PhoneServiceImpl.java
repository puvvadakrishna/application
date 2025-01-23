package src.main.java.com.example.useful.example;

import lombok.extern.slf4j.Slf4j;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public PhoneModel savePhone(PhoneModel phoneModel) {

        if (phoneModel.getModelNo() == null || phoneModel.getModelNo().isEmpty()) {
            throw new IllegalArgumentException("INVALID_MODEL_NO");
        }
        if (phoneModel.getModelColour().equalsIgnoreCase("BLACK")) {
            throw new IllegalArgumentException("INVALID_MODEL_COLOR");
        }
        updateColor(phoneModel);
        return modelRepository.save(phoneModel);
    }

    @Override
    public List<PhoneModel> findByModelColour(String modelColour) {
        if (modelColour.equalsIgnoreCase("BLACK")) {
            throw new IllegalArgumentException("INVALID_MODEL_COLOR");
        }
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

    public List<PhoneModel> savePhones(List<PhoneModel> models) {

        for (PhoneModel model : models) {
            updateColor(model);
        }
        return modelRepository.saveAll(models);
    }

    private void updateColor(PhoneModel modle) {

        if (modle != null) {
            logColorUpdate(modle);
            modle.setModelColour(modle.getModelColour().toUpperCase());
        }
    }

    private void logColorUpdate(PhoneModel modle) {
        if (modle != null) {
            log.info("Updating color for model : " + modle.getModelNo());
        }
    }

    public Long addPhone(PhoneModel pm) {
        return modelRepository.save(pm).getId();
    }

    @Transactional
    public void deletePhone(String modelPrice) {
        modelRepository.deleteBymodelPrice(modelPrice);
    }
}
