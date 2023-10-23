package com.lab1tbd.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService; // Necesario para cargar los detalles del usuario
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/voluntario/register", "/api/voluntario/login").permitAll()
                .antMatchers("/api/coordinador/home", "/api/voluntario/home").hasAnyRole("COORDINADOR", "VOLUNTARIO") // Permite a coordinadores y voluntarios
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("/api/coordinador/home", true) // Redirige a la página de inicio después del inicio de sesión
                .permitAll()
                .and()
                .logout()
                .permitAll();

        // Habilita la autenticación basada en UserDetailsService
        http.userDetailsService(userDetailsService);
    }
}

