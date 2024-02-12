package com.shopping.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "phoneModel")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class PhoneModel implements Serializable {
    private static final long serialVersionUID = 2L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "model_gen")
    @SequenceGenerator(name = "model_gen", sequenceName = "phoneModel_seq", allocationSize = 1)
    private Long id;
    @NonNull
    private String modelColour;
    @NonNull
    private String modelNo;
    @NonNull
    private String modelPrice;


    public PhoneModel(String modelNo, String modelPrice, String modelColour) {

        this.modelNo = modelNo;
        this.modelPrice = modelPrice;
        this.modelColour = modelColour;
    }

}
