package com.shopping.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

@Entity
@Table(name="employee")
@Setter
@Getter
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_gen")
	@SequenceGenerator(name="employee_gen", sequenceName = "employee_seq", allocationSize=1)
	private Long id;
	@NotBlank
	private String firstname;
	@NotBlank
	private String lastname;

}