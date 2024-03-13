package com.example.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Producto {

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
