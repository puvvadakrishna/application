package com.shopping.controller;

import com.shopping.exception.ProductNotFoundException;
import com.shopping.phone.iphone.CheckModelAvailability;
import com.shopping.entity.PhoneModel;
import com.shopping.repo.PhoneModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("phone")
public class PhoneController {
    @Autowired
    private CheckModelAvailability cma;
    @Autowired
    PhoneModelRepository modelRepository;

    @GetMapping("/model")
    public PhoneModel getModel(@RequestParam String modelNo) throws ProductNotFoundException {
        PhoneModel data = cma.isModelAvailable(modelNo);
        return data;
    }

    @PostMapping("/saveOne")
    public ResponseEntity saveModel(@RequestBody PhoneModel data) throws ProductNotFoundException {
        return ResponseEntity.ok().body(data);

    }

    @GetMapping("/all")
    public List<PhoneModel> getModels() {
        return modelRepository.findAll();
    }

    @PostMapping("/save")
    public PhoneModel saveModelInRepo(@RequestBody PhoneModel data) throws ProductNotFoundException {
        return modelRepository.save(data);

    }

    @PostMapping("/saveall")
    public List<PhoneModel> saveInRepo(@RequestBody List<PhoneModel> data) throws ProductNotFoundException {
        return modelRepository.saveAll(data);

    }

    @GetMapping("/findmodelno")
    public List<PhoneModel> getModelByModelNo(@RequestParam String modelNo) {
        return modelRepository.findByModelNo(modelNo);
    }

    @GetMapping("/findmodelcolour")
    public List<PhoneModel> getModelByColour(@RequestParam String modelColour) {
        return modelRepository.findByModelColour(modelColour);
    }

    @GetMapping("/findmodelprice")
    public List<PhoneModel> getModelByPrice(@RequestParam String modelPrice) {
        return modelRepository.findBymodelPrice(modelPrice);
    }

    // @GetMapping("/{id}")
//    public Optional<PhoneModel> getid(@PathVariable Long id) {
//        return modelRepository.findById(id);
//    }
    @GetMapping("/{id}")
    public Optional<PhoneModel> getById(@PathVariable Long id) throws ProductNotFoundException {
        Optional<PhoneModel> res = modelRepository.findById(id);
        System.out.println(res);
        if (res.isEmpty()) {
            throw new ProductNotFoundException("Requested resource is not found " + id);
        }
        return res;
    }

}