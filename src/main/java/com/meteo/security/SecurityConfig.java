package com.meteo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Matt on 08.05.2019 at 19:14.
 */

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("kot")
                .password("{noop}mru")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("{noop}pass")
                .roles("ADMIN");
    }

    /*Some of the actuator endpoints (e.g. /loggers) support POST requests.
    When using Spring Security you need to ignore the actuator endpoints for CSRF-Protection
    as the Spring Boot Admin Server currently lacks support.*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    //.anyRequest().authenticated()
                    .antMatchers("/").permitAll()
                    .antMatchers("/index").authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .failureUrl("/login-error")
                    .permitAll()
                .and()
                    .logout()
                    .logoutSuccessUrl("/logout")
                    .permitAll()
                .and()
                    .csrf()
                    .ignoringAntMatchers("/actuator/**");
    }

}
