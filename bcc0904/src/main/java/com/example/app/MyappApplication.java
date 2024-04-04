package com.example.app;

import com.example.app.entity.*;
import com.example.app.services.CategoriaService;
import com.example.app.services.ProductoService;
import com.example.app.services.UsuarioService;
import com.example.app.services.ValoracionService;
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
	CommandLineRunner initData(ValoracionService valoracionService) {
		return args -> {
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
*/
			valoracionService.añadir(new Valoracion(0L,0,"Es malísimo"));
			valoracionService.añadir(new Valoracion(0L,1,"No funciona bien"));
			valoracionService.añadir(new Valoracion(0L,2,"Tiene muchos defectos"));
			valoracionService.añadir(new Valoracion(0L,3,"Es muy irregular"));
			valoracionService.añadir(new Valoracion(0L,4,"Está defectuoso"));
			valoracionService.añadir(new Valoracion(0L,5,"Regulero"));
			valoracionService.añadir(new Valoracion(0L,6,"Puede safar"));
			valoracionService.añadir(new Valoracion(0L,7,"Bastante bueno"));
			valoracionService.añadir(new Valoracion(0L,8,"Bueno"));
			valoracionService.añadir(new Valoracion(0L,9,"Casi Perfecto"));
			valoracionService.añadir(new Valoracion(0L,10,"Un espectáculo de producto"));


		};
	}
}
