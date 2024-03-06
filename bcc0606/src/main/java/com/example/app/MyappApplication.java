package com.example.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyappApplication {

	public static void main(String[] args) {

		SpringApplication.run(MyappApplication.class, args);
	}
	@Bean
	CommandLineRunner initData() {
		return args -> {


		};
	}

}
