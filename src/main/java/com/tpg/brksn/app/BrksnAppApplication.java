package com.tpg.brksn.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;

@SpringBootApplication
@EnableWebFluxSecurity
public class BrksnAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrksnAppApplication.class, args);
	}

}
