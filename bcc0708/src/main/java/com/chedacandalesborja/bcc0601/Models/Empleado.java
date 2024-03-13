package com.chedacandalesborja.bcc0601.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.File;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class Empleado {
    @Id
    @GeneratedValue
    @Min(value = 0)
    private Long id;

    @NotEmpty
    private String nombre;

    @Email(message = "Debe tener formato email válido")
    private String email;

    private Double salario;

    private boolean enActivo;

    private Genero genero;

    @ManyToOne
    @JoinColumn(name = "DEPTO_ID", foreignKey = @ForeignKey(name="DEPTO_ID_FK"))
    private Departamento departamento;

}