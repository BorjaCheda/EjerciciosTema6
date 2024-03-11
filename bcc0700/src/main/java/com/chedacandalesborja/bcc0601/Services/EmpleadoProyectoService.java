package com.chedacandalesborja.bcc0601.Services;

import com.chedacandalesborja.bcc0601.Models.Empleado;
import com.chedacandalesborja.bcc0601.Models.EmpleadoProyecto;
import com.chedacandalesborja.bcc0601.Models.Proyecto;

import java.util.List;

public interface EmpleadoProyectoService {
    public EmpleadoProyecto obtenerPorId(Long id);

    public EmpleadoProyecto añadir(EmpleadoProyecto empleadoProyecto);

    public void borrar(EmpleadoProyecto empleadoProyecto);

    public List<EmpleadoProyecto> obtenerPorEmpleado(Empleado empleado);

    public List<EmpleadoProyecto> obtenerPorProyecto(Proyecto proyecto);

    public EmpleadoProyecto obtenerPorEmpleadoProyecto(Empleado e, Proyecto p);
}
