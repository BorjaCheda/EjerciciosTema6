package com.example.app;

import com.example.app.entity.Producto;
import com.example.app.entity.TipoIva;
import com.example.app.services.ProductoService;
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
	CommandLineRunner initData(ProductoService productoService) {
		return args -> {
			productoService.añadir(
					new Producto(1L, "tomate", true, TipoIva.REDUCIDO, 1));
			productoService.añadir(
					new Producto(2L, "leche", true, TipoIva.NORMAL, 1.5));
			productoService.añadir(
					new Producto(3L, "pipas", false, TipoIva.NORMAL, 2));
		};
	}

}
