package com.shopping.controller;

import static com.shopping.config.cache.CacheConstants.DEFAULT_CACHE_NAME;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecuredController {

  @GetMapping
  @Secured("ROLE_USER")
  @Cacheable(value = DEFAULT_CACHE_NAME, key = "#id")
  public String getData(@RequestParam String id) {
    return "hello-" + id;
  }
}
