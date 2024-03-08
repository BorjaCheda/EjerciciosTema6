package com.example.app.entity;

import com.example.app.config.Tarifas;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode (of = "DNI")
public abstract class Paciente {

    private String DNI;
    private String nombre;
    private LocalDate fechaNacimiento;

    public abstract Integer facturar(Tarifas tarifas);
}
