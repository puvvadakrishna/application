package com.shopping.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

import java.io.Serializable;

@Entity
@Table(name="phoneModel")
@Setter
@Getter
@ToString
public class PhoneModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "model_gen")
	@SequenceGenerator(name="model_gen", sequenceName = "phoneModel_seq", allocationSize=1)
	private Long id;
	@NotBlank
	private String modelColour;
	@NotBlank
	private String modelNo;
	@NotBlank
	private String modelPrice;

	public PhoneModel() {

	}

	public PhoneModel(String modelNo, String modelPrice, String modelColour) {

		this.modelNo = modelNo;
		this.modelPrice = modelPrice;
		this.modelColour = modelColour;
	}

}
