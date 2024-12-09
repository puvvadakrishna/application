package com.shopping.kafka.producer;

import lombok.*;

@Builder
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Order {

    private String id;

    private String name;
}
