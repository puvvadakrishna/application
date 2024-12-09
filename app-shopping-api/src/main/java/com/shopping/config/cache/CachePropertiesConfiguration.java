package com.shopping.config.cache;

import static com.shopping.config.cache.CacheConstants.CACHE_PROPERTIES_PREFIX;
import static com.shopping.config.cache.CacheConstants.DEFAULT_CACHE_NAME;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CachePropertiesConfiguration {

    @Bean
    @ConfigurationProperties(prefix = CACHE_PROPERTIES_PREFIX + DEFAULT_CACHE_NAME)
    public CacheProperties defaultCacheProperties() {
        return new CacheProperties();
    }
}
