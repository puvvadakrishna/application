package com.shopping.config.cache;

import static com.shopping.config.cache.CacheConstants.DEFAULT_CACHE_NAME;

import java.util.Objects;
import java.util.Optional;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheFactoryBean;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;

@Configuration
@Import(CachePropertiesConfiguration.class)
@EnableConfigurationProperties
@EnableCaching
public class CacheConfig {

  @Bean
  public EhCacheManagerFactoryBean ehCacheCacheManager() {
    final EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean();
    cacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
    cacheManagerFactoryBean.setShared(true);
    return cacheManagerFactoryBean;
  }

  @Bean
  public EhCacheFactoryBean defaultCache(
      CacheProperties defaultCacheProperties, EhCacheManagerFactoryBean ehCacheCacheManager) {
    return createCache(DEFAULT_CACHE_NAME, defaultCacheProperties, ehCacheCacheManager);
  }

  private EhCacheFactoryBean createCache(
      String name, CacheProperties properties, EhCacheManagerFactoryBean ehCacheCacheManager) {
    EhCacheFactoryBean cache = new EhCacheFactoryBean();
    Optional.ofNullable(properties.getTimeToLiveInSeconds()).ifPresent(cache::setTimeToLiveSeconds);
    Optional.ofNullable(properties.getMaxEntriesInMemory())
        .ifPresent(cache::setMaxEntriesLocalHeap);
    cache.setCacheName(name);
    cache.setCacheManager(Objects.requireNonNull(ehCacheCacheManager.getObject()));
    return cache;
  }
}
