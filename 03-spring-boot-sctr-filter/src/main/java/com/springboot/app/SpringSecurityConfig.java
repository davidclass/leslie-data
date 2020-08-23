package com.springboot.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/", "/css/**", "/js/**","/images/**", "/listar/colaboradores").permitAll()
                .antMatchers("/ver/**").hasAnyRole("USER")
                .antMatchers("/uploads/**").hasAnyRole("ADMIN")
                .antMatchers("/form/**").hasAnyRole("ADMIN")
                .antMatchers("/eliminar/**").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login")
                .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/error_403");
    }

    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception {

        PasswordEncoder encoder = passwordEncoder();
        User.UserBuilder user = User.builder().passwordEncoder(password ->{
            return encoder.encode(password);
        });

        builder.inMemoryAuthentication()
                .withUser(user.username("Leslie").password("060899").roles("ADMIN", "USER"))
                .withUser(user.username("SUPERVI01").password("12345").roles("USER"))
                .withUser(user.username("SUPERVI02").password("12345").roles("USER"))
                .withUser(user.username("SUPERVI03").password("12345").roles("USER"))
                .withUser(user.username("SUPERVI04").password("12345").roles("USER"))
                .withUser(user.username("SUPERVI05").password("12345").roles("USER"))
        ;

    }
}
