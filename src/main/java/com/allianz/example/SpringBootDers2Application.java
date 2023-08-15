package com.allianz.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootDers2Application {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootDers2Application.class, args);

    }

}
