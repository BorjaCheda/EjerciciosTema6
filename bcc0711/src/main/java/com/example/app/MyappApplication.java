package com.example.app;

import com.example.app.entity.Cuenta;
import com.example.app.entity.Movimiento;
import com.example.app.services.CuentaService;
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
	@Bean
	CommandLineRunner initData(CuentaService cuentaService) {
		return args -> {

			List<Movimiento> movimiento1 = new ArrayList<>();
			List<Movimiento> movimiento2=new ArrayList<>();
			movimiento1.add(new Movimiento(1l,"ES9121000418450200051332", LocalDateTime.of(2022, 12, 5, 12, 12), 150d));
			movimiento1.add(new Movimiento(2l,"ES9121000418450200051332", LocalDateTime.of(2022, 11, 4, 12, 12), 380d));
			movimiento2.add(new Movimiento(1l,"ES4875051428450854700340", LocalDateTime.of(2022, 10, 3, 12, 12), -125d));
			movimiento2.add(new Movimiento(2l,"ES4875051428450854700340", LocalDateTime.of(2023, 8, 1, 12, 12), 180d));


			cuentaService.agregar(
					new Cuenta("ES9121000418450200051332", "cuentaManolo", 1000d, movimiento1));
			cuentaService.agregar(
					new Cuenta("ES4875051428450854700340", "cuentaMaría", 1800d, movimiento2 ));



		};
	}

}
