package com.example.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "Movimiento")
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String IBAN;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fecha;
    @Min(-300)
    @Max(1000)
    private Double importe;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    private Cuenta cuenta;

    public Movimiento(String IBAN) {
        this.IBAN = IBAN;

    }
}