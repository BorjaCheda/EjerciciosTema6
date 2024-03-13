package com.chedacandalesborja.bcc0601.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpleadoDTO {
    private Long id;
    private String nombre;
    private Double salario;
    private String departamentoNombre;
}
