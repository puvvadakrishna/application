package com.shopping.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {
}
//LFU-least  frequently used(resource in .xml) used
//Fifo
