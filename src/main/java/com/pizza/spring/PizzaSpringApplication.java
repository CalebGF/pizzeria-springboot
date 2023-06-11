package com.pizza.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class PizzaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaSpringApplication.class, args);
	}

}
