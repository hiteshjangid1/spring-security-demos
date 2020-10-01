package com.mahendra.demo8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

@SpringBootApplication
@EnableWebSecurity
public class Demo8Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo8Application.class, args);
	}

	
	
}
