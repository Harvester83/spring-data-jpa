package com.rs.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.rs.entity"})
@ComponentScan(basePackages = "com.rs")
@EnableJpaRepositories(basePackages = "com.rs.repository")
public class SpringDataJpaApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringDataJpaApplication.class, args);
  }
}
