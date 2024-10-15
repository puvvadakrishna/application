package com.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/cache")
public class CacheViewerController {

  @Autowired private CacheManager cacheManager; // Spring CacheManager

  @GetMapping("/view")
  public Map<Object, Object> viewCacheContents(@RequestParam String cacheName) {
    Map<Object, Object> cacheContents = new HashMap<>();
    Cache cache = cacheManager.getCache(cacheName);

    if (cache != null && cache.getNativeCache() instanceof net.sf.ehcache.Ehcache) {
      net.sf.ehcache.Ehcache ehcache = (net.sf.ehcache.Ehcache) cache.getNativeCache();
      for (Object key : ehcache.getKeys()) {
        cacheContents.put(key, ehcache.get(key).getObjectValue());
      }
    } else {
      cacheContents.put("Error", "Cache not found or unsupported cache type.");
    }

    return cacheContents;
  }
}
