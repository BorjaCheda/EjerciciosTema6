package com.chedacandalesborja.bcc0601.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class Proyecto {
    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    private String nombre;

    @ToString.Exclude
    @ManyToMany(mappedBy ="proyectos")
    private List<Empleado> empleados = new ArrayList<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "proyecto", cascade = CascadeType.REMOVE)
    private List<EmpleadoProyecto> empleadoProyecto = new ArrayList<>();

}
