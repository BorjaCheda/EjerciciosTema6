package com.example.app.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Producto {
    @NotNull
    @Min(1)
    private long id;
    @NotNull
    private String nombre;
    private boolean enOferta;
    private TipoIva tipoIva;
    private double precio;

    /*private long idCategoria;*/
}
