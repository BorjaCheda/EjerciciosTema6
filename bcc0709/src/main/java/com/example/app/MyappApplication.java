package com.example.app;

import com.example.app.entity.Categoria;
import com.example.app.entity.Producto;
import com.example.app.entity.TipoIva;
import com.example.app.services.CategoriaService;
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
	CommandLineRunner initData(ProductoService productoService, CategoriaService categoriaService) {
		return args -> {
			productoService.añadir(
					new Producto(1L, "ordenador", true, TipoIva.REDUCIDO, 300D, 1L));
			productoService.añadir(
					new Producto(2L, "cargador", true, TipoIva.NORMAL, 30D, 1L));
			productoService.añadir(
					new Producto(3L, "mesa", false, TipoIva.NORMAL, 100D, 2L));
			categoriaService.añadir(new Categoria(1L, "Informática"));
			categoriaService.añadir(new Categoria(2L, "Material de Oficina"));
			categoriaService.añadir(new Categoria(3L, "Comida"));



		};
	}

}