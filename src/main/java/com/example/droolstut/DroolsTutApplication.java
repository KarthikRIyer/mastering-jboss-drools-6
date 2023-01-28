package com.example.droolstut;

import com.example.droolstut.util.Util;
import org.kie.api.runtime.KieSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DroolsTutApplication {

	public static void main(String[] args) {
		SpringApplication.run(DroolsTutApplication.class, args);
	}

	@Bean
	public KieSession kieSession() {
		return Util.getDefaultKieSession();
	}

}
