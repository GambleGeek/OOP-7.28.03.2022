package com.adiskerimov.spring.mvc_hibernate_aop.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;

import static org.springframework.security.core.userdetails.User.*;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource);


//        UserBuilder userBuilder = User.withDefaultPasswordEncoder();
//
//        auth.inMemoryAuthentication()
//                .withUser(userBuilder.username("adis")
//                        .password("adis")
//                        .roles("EMPLOYEE"))
//                .withUser(userBuilder.username("aidar")
//                        .password("aidar")
//                        .roles("HR"))
//                .withUser(userBuilder.username("cholpon")
//                        .password("cholpon")
//                        .roles("MANAGER", "HR"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasAnyRole(
                        "SALESMANAGER", "TOURMANAGER", "TOURCREATOR", "DIRECTOR")
                .antMatchers("/sales/**").hasRole("SALESMANAGER")
                .antMatchers("/tour-information/**").hasRole("TOURMANAGER")
                .antMatchers("/tour-creator/**").hasRole("TOURCREATOR")
                .antMatchers("/director/**").hasRole("DIRECTOR")
                .and().formLogin().permitAll();
    }

}
