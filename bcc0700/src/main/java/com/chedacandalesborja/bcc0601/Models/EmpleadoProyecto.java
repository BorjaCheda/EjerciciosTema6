package com.chedacandalesborja.bcc0601.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(EmpleadoProyectoId.class)
public class EmpleadoProyecto {

    @Id
    @ManyToOne
    @JoinColumn(name = "empleado_id")
    @OnDelete(action= OnDeleteAction.CASCADE)
    private Empleado empleado;

    @Id
    @ManyToOne
    @JoinColumn(name = "proyecto_id")
    @OnDelete(action=OnDeleteAction.CASCADE)
    private Proyecto proyecto;

    @NotEmpty
    private String puesto;
}
