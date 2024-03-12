package com.chedacandalesborja.bcc0601;


import com.chedacandalesborja.bcc0601.Models.*;
import com.chedacandalesborja.bcc0601.Services.CategoriaService;
import com.chedacandalesborja.bcc0601.Services.DepartamentoService;
import com.chedacandalesborja.bcc0601.Services.EmpleadoService;
import com.chedacandalesborja.bcc0601.Services.ProyectoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Bcc0601Application {
	public static void main(String[] args) {
		SpringApplication.run(Bcc0601Application.class, args);
	}
}