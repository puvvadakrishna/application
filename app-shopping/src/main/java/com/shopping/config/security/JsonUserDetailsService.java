package com.shopping.config.security;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JsonUserDetailsService implements UserDetailsService {

  private List<com.shopping.config.security.User> users;

  public JsonUserDetailsService() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    users =
        mapper.readValue(
            new File(
                "C:\\Users\\puvva\\IdeaProjects\\app\\app-shopping\\src\\main\\resources\\users.json"),
            new TypeReference<List<com.shopping.config.security.User>>() {});
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return users.stream()
        .filter(user -> user.getUsername().equals(username))
        .findFirst()
        .map(
            user ->
                new org.springframework.security.core.userdetails.User(
                    user.getUsername(),
                    user.getPassword(), // For demo purposes; use bcrypt or other encoders in
                    // production
                    user.getRoles().stream()
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList())))
        .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
  }
}
