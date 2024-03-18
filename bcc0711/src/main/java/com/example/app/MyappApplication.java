package com.example.app;

import com.example.app.entity.Cuenta;
import com.example.app.entity.Movimiento;
import com.example.app.services.CuentaService;
import com.example.app.services.MovimientoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MyappApplication {

	public static void main(String[] args) {

		SpringApplication.run(MyappApplication.class, args);
	}
	/*@Bean
	CommandLineRunner initData(CuentaService cuentaService, MovimientoService movimientoService) {
		return args -> {

			Movimiento movimiento1 = movimientoService.agregar(new Movimiento(0l,"ES9121000418450200051332", LocalDateTime.of(2022, 12, 5, 12, 12), 150d));
			Movimiento movimiento2 = movimientoService.agregar(new Movimiento(0l,"ES4875051428450854700340", LocalDateTime.of(2022, 11, 4, 12, 12), 380d));

			List<Movimiento> movimientosCuenta1 = new ArrayList<>();
			movimientosCuenta1.add(movimiento1);

			List<Movimiento> movimientosCuenta2 = new ArrayList<>();
			movimientosCuenta2.add(movimiento2);
			cuentaService.agregar(
					new Cuenta(0l,"ES9121000418450200051332", "cuentaManolo", 1000d, movimientosCuenta1));
			cuentaService.agregar(
					new Cuenta(0l, "ES4875051428450854700340", "cuentaMaría", 1800d, movimientosCuenta2));



		};
	}*/

}
