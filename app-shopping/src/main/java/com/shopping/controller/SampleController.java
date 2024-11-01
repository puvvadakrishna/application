package com.shopping.controller;

import static com.shopping.config.cache.CacheConstants.DEFAULT_CACHE_NAME;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/getname")
public class SampleController {

  @Autowired private DataService dataService;

  @GetMapping
  @Cacheable(value = DEFAULT_CACHE_NAME, key = "#id")
  //  @PreAuthorize("hasRole('ADMIN')")
  @Secured("ROLE_USER")
  public String getData(@RequestParam String id) {
    return dataService.getDataById(id);
  }
}
