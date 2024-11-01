package com.shopping.repo;

import com.shopping.entity.PhoneModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneModelRepository extends JpaRepository<PhoneModel, Long> {

  PhoneModel findByModelNo(String modelNo);

  List<PhoneModel> findByModelColour(String modelColour);

  List<PhoneModel> findBymodelPrice(String modelPrice);

  void deleteBymodelPrice(String modelPrice);
}
