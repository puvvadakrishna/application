package com.shopping.repo;

import com.shopping.entity.PhoneModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneModelRepository extends JpaRepository<PhoneModel, Long> {

    PhoneModel findByModelNo(String modelNo);

    List<PhoneModel> findByModelColour(String modelColour);

    List<PhoneModel> findBymodelPrice(String modelPrice);
}
