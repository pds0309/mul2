package com.example.api;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = {"com.example.common"})
@EnableJpaRepositories(basePackages = {"com.example.common"})
public class RepoConfiguration {

}
