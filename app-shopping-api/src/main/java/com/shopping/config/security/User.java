package com.shopping.config.security;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
  private String username;
  private String password;
  private List<String> roles;
}
