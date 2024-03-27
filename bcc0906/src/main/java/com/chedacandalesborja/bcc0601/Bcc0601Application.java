package com.chedacandalesborja.bcc0601;

import com.chedacandalesborja.bcc0601.Models.Usuario;
import com.chedacandalesborja.bcc0601.Services.UsuarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Bcc0601Application {
	public static void main(String[] args) {
		SpringApplication.run(Bcc0601Application.class, args);
	}

	/*@Bean
	CommandLineRunner initData(UsuarioService usuarioService) {
		return args -> {
			usuarioService.añadir(new Usuario("admin", "1234", "ADMIN"));
			/*Categoria informatica = new Categoria(0L, "Informática");
			Categoria materialOficina = new Categoria(0L, "Material Oficina");
			Categoria accesorios = new Categoria(0L, "Accesorios");

			informatica = categoriaService.añadir(informatica);
			materialOficina = categoriaService.añadir(materialOficina);
			accesorios = categoriaService.añadir(accesorios);

			productoService.añadir(
					new Producto(1L, "ordenador", true, TipoIva.REDUCIDO, 300D,informatica));
			productoService.añadir(
					new Producto(2L, "cargador", true, TipoIva.NORMAL, 30D, accesorios));
			productoService.añadir(
					new Producto(3L, "mesa", false, TipoIva.NORMAL, 100D,materialOficina));

		};
	}*/
}