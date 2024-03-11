package com.chedacandalesborja.bcc0601.Repositories;

import com.chedacandalesborja.bcc0601.Models.Empleado;
import com.chedacandalesborja.bcc0601.Models.EmpleadoProyecto;
import com.chedacandalesborja.bcc0601.Models.EmpleadoProyectoId;
import com.chedacandalesborja.bcc0601.Models.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmpleadoProyectoRepository extends
        JpaRepository<EmpleadoProyecto, EmpleadoProyectoId> {
    // métodos derivado de nombre
    List<EmpleadoProyecto> findByEmpleado(Empleado empleado);
    List<EmpleadoProyecto> findByProyecto(Proyecto proyecto);
    EmpleadoProyecto findByEmpleadoAndProyecto(Empleado emp, Proyecto proy);

    EmpleadoProyecto findById(Long id);
}