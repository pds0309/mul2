package com.example.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
@EntityScan(basePackages = {"com.example.common"})
@EnableJpaRepositories(basePackages = {"com.example.common"})
public class BatchApplication {

    public static void main(String[] args) {
        if (System.getProperty("spring.profiles.default") == null) {
            System.setProperty("spring.profiles.default", "local");
            System.setProperty("spring.profiles.active", "local");
        }
        SpringApplication.run(BatchApplication.class, args);
    }

}
