package com.example.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    private String nombre;

    private LocalDate fechaRegistro;

    private String password;

    private Rol rol;

    public Usuario(String nombre, String password, String rol) {
        this.nombre = nombre;
        this.password=password;
        this.rol = Rol.valueOf(rol);
    }
}
