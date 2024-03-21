package com.example.app;


import com.example.app.entity.Usuario;
import com.example.app.services.UsuarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyappApplication {

    public static void main(String[] args) {

        SpringApplication.run(MyappApplication.class, args);
    }

   /* @Bean
    CommandLineRunner initData(UsuarioService usuarioService) {
        return args -> {
            usuarioService.agregar(new Usuario("Ana", "1234", "ADMIN"));
        };
    } */
}
