package com.example.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true) //evita duplicados a nivel base de datos
    private String nombre;
    @Size(min = 4, message = "La Contraseña debe tener al menos 4 caracteres")
    private String password;
    private Rol rol;
}
