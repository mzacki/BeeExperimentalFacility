package com.colony.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

/**
 * Created by Matt on 08.05.2019 at 19:14.
 */

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder.jdbcAuthentication()
                .***REMOVED***sByUsernameQuery("SELECT ***REMOVED***name, ***REMOVED***word, enabled FROM ***REMOVED***s WHERE ***REMOVED***name=?")
                .authoritiesByUsernameQuery("SELECT ***REMOVED***name, authority FROM ***REMOVED***s WHERE ***REMOVED***name=?")
                .dataSource(dataSource);
    }

    /*Some of the actuator endpoints (e.g. /loggers) support POST requests.
    When using Spring Security you need to ignore the actuator endpoints for CSRF-Protection
    as the Spring Boot Admin Server currently lacks support.*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/", "/index","/css/**", "/js/**").permitAll()
                    .antMatchers("/db").hasRole("ADMIN")
                    .anyRequest().authenticated()
***REMOVED***
                    .formLogin()
                    .loginPage("/login")
                    .failureUrl("/login-error")
                    .permitAll()
***REMOVED***
                    .logout()
                    .logoutSuccessUrl("/logout")
                    .permitAll()
***REMOVED***
                    .csrf()
                    .ignoringAntMatchers("/actuator/**")
***REMOVED***
                    .exceptionHandling().accessDeniedPage("/403");
    }

}
