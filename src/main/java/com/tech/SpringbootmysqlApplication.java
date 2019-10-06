package com.tech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.tech.repository")
@SpringBootApplication
public class SpringbootmysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootmysqlApplication.class, args);
	}

}
