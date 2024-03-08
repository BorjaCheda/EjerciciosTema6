package com.example.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "DNI")
public class PacienteDTO {
    private String DNI;
    private String nombre;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;

    private Integer tipoPaciente;

    private String motivoConsulta;
    private String recetas;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaUltimaRevision;



}
