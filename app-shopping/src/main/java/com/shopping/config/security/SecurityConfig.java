package com.shopping.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
// @RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired private UserDetailsService jsonUserDetailsService;

  //  private final CustomAccessDeniedHandler accessDeniedHandler;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(jsonUserDetailsService).passwordEncoder(passwordEncoder());
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  //  @Override
  //  protected void configure(HttpSecurity http) throws Exception {
  //    http.authorizeRequests()
  //        .antMatchers("/*").permitAll()
  ////        .authenticated()
  ////        .and()
  ////        .exceptionHandling()
  ////        .accessDeniedHandler(accessDeniedHandler)
  //        .and()
  //        .httpBasic();
  //  }

  /*    @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.inMemoryAuthentication()
              .withUser("admin").password(passwordEncoder().encode("admin123")).roles("ADMIN")
              .and()
              .withUser("user").password(passwordEncoder().encode("user123")).roles("USER");
  }*/

  //    You can also specify role-based access directly in your controller using @PreAuthorize or
  // @Secured.
  //    @Override
  /*    protected void configure(HttpSecurity http) throws Exception {
      http
              .authorizeRequests()
              .antMatchers("/admin/**").hasRole("ADMIN")  // Only users with 'ADMIN' role can access /admin endpoints
              .antMatchers("/user/**").hasRole("USER")
              .antMatchers("/*").hasAnyRole("USER")  // USER and ADMIN can access /user endpoints
                              // Only users with 'USER' role can access /user endpoints
              .anyRequest().authenticated() // Any other request requires authentication
              .and()
              .httpBasic(); // Basic auth for simplicity
  }*/

  //    @Override
  //    protected void configure(HttpSecurity http) throws Exception {
  //        http
  //                .authorizeRequests()
  //                .antMatchers("/admin/**").hasRole("ADMIN")
  //                .antMatchers("/*").hasRole("USER")
  //                .anyRequest().authenticated()
  //                .and()
  //                .httpBasic();
  //    }

}
