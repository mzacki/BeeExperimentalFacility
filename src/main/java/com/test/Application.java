package com.test;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by Matt on 23.04.2019 at 18:32.
 */

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(InsertRepository insertRepository) {
        return args -> {
            insertRepository.save(new Insert("storm"));
            insertRepository.save(new Insert("rain"));
        };
    }
}

