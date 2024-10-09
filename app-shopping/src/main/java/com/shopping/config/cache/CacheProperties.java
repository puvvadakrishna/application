package com.shopping.config.cache;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CacheProperties {

    private Long timeToLiveInSeconds;
    private Long maxEntriesInMemory;
}
