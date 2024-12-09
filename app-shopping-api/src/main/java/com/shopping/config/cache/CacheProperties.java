package com.shopping.config.cache;

import lombok.Data;

@Data
public class CacheProperties {

    private Long timeToLiveInSeconds;
    private Long maxEntriesInMemory;
}
