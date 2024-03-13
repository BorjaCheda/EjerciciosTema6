package com.example.app.entity;

import jakarta.persistence.*;
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
@Entity
public class Producto {
    @NotNull
    @Min(1)
    @Id
    @GeneratedValue
    private long id;
    @NotNull
    private String nombre;
    private boolean enOferta;
    private TipoIva tipoIva;
    private double precio;

    @ManyToOne
    @JoinColumn(name = "Categoria_ID", foreignKey = @ForeignKey(name="Categoria_ID_FK"))
    private Categoria categoria;

}
