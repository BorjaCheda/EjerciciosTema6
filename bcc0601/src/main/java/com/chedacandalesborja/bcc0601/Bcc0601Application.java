package com.chedacandalesborja.bcc0601;

import com.chedacandalesborja.bcc0601.Models.Empleado;
import com.chedacandalesborja.bcc0601.Models.Genero;
import com.chedacandalesborja.bcc0601.Services.EmpleadoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Bcc0601Application {
	public static void main(String[] args) {
		SpringApplication.run(Bcc0601Application.class, args);
	}
	@Bean
	CommandLineRunner initData(EmpleadoService empleadoService) {
		return args -> {
			empleadoService.añadir(
					new Empleado(1L, "pepe", "pepe@gmail.com", 1000d, true, Genero.MASCULINO));
			empleadoService.añadir(
					new Empleado(2L, "ana", "ana@gmail.com", 2000d, true, Genero.FEMENINO));
		};
	}
}
