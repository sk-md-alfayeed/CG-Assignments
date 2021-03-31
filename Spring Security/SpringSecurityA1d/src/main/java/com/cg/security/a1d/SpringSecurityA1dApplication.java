package com.cg.security.a1d;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class SpringSecurityA1dApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityA1dApplication.class, args);
	}

}
