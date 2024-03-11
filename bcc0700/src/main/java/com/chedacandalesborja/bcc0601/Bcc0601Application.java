package com.chedacandalesborja.bcc0601;

import com.chedacandalesborja.bcc0601.Models.Departamento;
import com.chedacandalesborja.bcc0601.Models.Empleado;
import com.chedacandalesborja.bcc0601.Models.Genero;
import com.chedacandalesborja.bcc0601.Models.Proyecto;
import com.chedacandalesborja.bcc0601.Services.DepartamentoService;
import com.chedacandalesborja.bcc0601.Services.EmpleadoService;
import com.chedacandalesborja.bcc0601.Services.ProyectoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class Bcc0601Application {

	public static void main(String[] args) {
		SpringApplication.run(Bcc0601Application.class, args);
		log.info("Probando el funcionamiento de Slf4j por consola");
	}
	@Bean
	CommandLineRunner initData(EmpleadoService empleadoService,
							   DepartamentoService departamentoService, ProyectoService proyectoService) {
		return args -> {
			departamentoService.añadir(new Departamento(0L, "Informática"));
			departamentoService.añadir(new Departamento(0L, "RRHH"));
			proyectoService.añadir(new Proyecto(0L,"Nueva normativa UE"));
			proyectoService.añadir(new Proyecto(0L,"Mejora Web actual"));
			empleadoService.añadir
					(new Empleado(0L, "pepe", "pepe@gmail.com", 800d, true,Genero.MASCULINO,
							departamentoService. obtenerPorNombre("Informática")));
			empleadoService.añadir(new Empleado(0L, "ana", "ana@gmail.com", 1200d, true, Genero.FEMENINO,
					departamentoService.obtenerPorNombre("RRHH")));
		};
	}
}


