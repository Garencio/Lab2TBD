package com.lab1tbd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Lab1TbdApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab1TbdApplication.class, args);
    }

}
