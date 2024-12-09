package com.shopping.config.security;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

@Service
public class JsonUserDetailsService implements UserDetailsService {

    @Value("classpath:users.json")
    private Resource userJsonResource;

    private List<com.shopping.config.security.User> users;

    @PostConstruct
    private void loadUsers() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        users =
                objectMapper.readValue(
                        userJsonResource.getInputStream(), new TypeReference<List<User>>() {});
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
                                        user.getPassword(), // For demo purposes; use bcrypt or
                                        // other encoders in
                                        // production
                                        user.getRoles().stream()
                                                .map(SimpleGrantedAuthority::new)
                                                .collect(Collectors.toList())))
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }
}
