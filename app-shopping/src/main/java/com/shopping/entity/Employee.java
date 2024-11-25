package com.shopping.entity;

import javax.persistence.*;

import com.shopping.validator.RequestPayLoad;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name = "employee")
@Setter
@Getter
public class Employee implements RequestPayLoad {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_gen")
  @SequenceGenerator(name = "employee_gen", sequenceName = "employee_seq", allocationSize = 1)
  private Long id;

  @NonNull private String firstname;
  @NonNull private String lastname;
  @NonNull private String employmentType;
}
