package com.example.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "IBAN")
@Entity
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String IBAN;
    private String alias;
    private Double saldo;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,
            mappedBy = "cuenta")
    private List<Movimiento> movimientos;
}