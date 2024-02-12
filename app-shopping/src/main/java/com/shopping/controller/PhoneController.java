package com.shopping.controller;


import com.shopping.exception.ProductNotFoundException;
import com.shopping.phone.CheckModelAvailability;
import com.shopping.entity.PhoneModel;
import com.shopping.repo.PhoneModelRepository;
import com.shopping.service.PhoneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("phone")
public class PhoneController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PhoneController.class);
    private CheckModelAvailability cma;

    private final PhoneModelRepository modelRepository;

    private final PhoneService phoneservice;

    public PhoneController(PhoneModelRepository modelRepository, PhoneService phoneservice) {
        this.modelRepository = modelRepository;
        this.phoneservice = phoneservice;
    }

    @GetMapping("/model")
    public Optional<PhoneModel> getModel(@RequestParam String modelNo) throws ProductNotFoundException {
        return cma.isModelAvailable(modelNo);
    }

    @GetMapping("/all")
    public List<PhoneModel> getModels() {
        return modelRepository.findAll();
    }

    @PostMapping("/save")
    public PhoneModel saveModelInRepo(@RequestBody PhoneModel data) {
        return phoneservice.savePhone(data);
    }

    @PostMapping("/saveall")
    public List<PhoneModel> saveInRepo(@RequestBody List<PhoneModel> data) {
        return phoneservice.savePhones(data);
    }

    @GetMapping("/findmodelno")
    public PhoneModel getModelByModelNo(@RequestParam String modelNo) {
        return phoneservice.getPhoneModelByModelNo(modelNo);
    }

    @GetMapping("/findmodelcolour")
    public List<PhoneModel> getModelByColour(@RequestParam String modelColour) {
        return phoneservice.findByModelColour(modelColour);
           }

    @GetMapping("/findmodelprice")
    public List<PhoneModel> getModelByPrice(@RequestParam String modelPrice) {
        return modelRepository.findBymodelPrice(modelPrice);
    }

    @GetMapping("/{id}")
    public Optional<PhoneModel> getById(@PathVariable Long id) throws ProductNotFoundException {
        Optional<PhoneModel> res = modelRepository.findById(id);
        LOGGER.info("{}", res);
        if (res.isEmpty()) {
            throw new ProductNotFoundException("Requested resource is not found " + id);
        }
        return res;
    }
    @PutMapping("/savemodelno")
    public ResponseEntity<String> update(@RequestBody  PhoneModel pm)
    {
        Long id = phoneservice.addPhone(pm);
        return new ResponseEntity<>("New phone added to Database : " + id, HttpStatus.CREATED);

    }
    @DeleteMapping("/patients")
    public ResponseEntity<String> deletePhoneData(@RequestParam String modelPrice) {
        phoneservice.deletePhone(modelPrice);
        return new ResponseEntity<>("Phone deleted "+modelPrice, HttpStatus.CREATED);
    }

}