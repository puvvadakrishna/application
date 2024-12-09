package com.shopping.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable {

    private String name;
    private String address;
}
