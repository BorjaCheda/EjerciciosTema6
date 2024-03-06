package com.example.app.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Movimiento {
    @NotNull
    @Min(1)
    private long id;
    @NotNull
    private String IBAN;
    private LocalDateTime fecha;
    @Min(-300)
    @Max(1000)
    private Double importe;
}
