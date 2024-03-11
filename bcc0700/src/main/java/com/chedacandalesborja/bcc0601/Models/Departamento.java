package com.chedacandalesborja.bcc0601.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Departamento {
    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String nombre;
}