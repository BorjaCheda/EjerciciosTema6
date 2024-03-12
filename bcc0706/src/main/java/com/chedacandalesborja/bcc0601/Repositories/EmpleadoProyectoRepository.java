package com.chedacandalesborja.bcc0601.Repositories;

import com.chedacandalesborja.bcc0601.Models.Empleado;
import com.chedacandalesborja.bcc0601.Models.EmpleadoProyecto;
import com.chedacandalesborja.bcc0601.Models.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpleadoProyectoRepository extends JpaRepository<EmpleadoProyecto, Long> {

    List<EmpleadoProyecto> findByEmpleado(Empleado empleado);
    List<EmpleadoProyecto> findByProyecto(Proyecto proyecto);
    EmpleadoProyecto findByEmpleadoAndProyecto(Empleado emp, Proyecto proy);

}
