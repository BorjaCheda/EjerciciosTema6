package com.chedacandalesborja.bcc0601.DTO;

import com.chedacandalesborja.bcc0601.Models.Genero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpleadoNuevoDto {
    private String nombre;
    private String email;
    private Double salario;
    private boolean enActivo;
    private Genero genero;
    private Long departamentoId;
}