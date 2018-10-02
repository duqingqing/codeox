package com.codeox.log.codeox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableAsync
public class CodeoxApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeoxApplication.class, args);
	}
}
