package com.chedacandalesborja.bcc0601.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String nombre;

    private String password;

    private Rol rol;

    public Usuario(String nombre, String password, String rol) {
        this.nombre = nombre;
        this.password=password;
        this.rol = Rol.valueOf(rol);
    }
}