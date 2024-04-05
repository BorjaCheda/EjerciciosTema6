package com.chedacandalesborja.bcc0601.Services;

import com.chedacandalesborja.bcc0601.Models.Empleado;

import java.util.List;

public interface EmpleadoService {
    Empleado añadir(Empleado empleado);

    List<Empleado> obtenerTodos();

    Empleado obtenerPorId(long id);

    Empleado editar(Empleado empleado);

    void borrar(long id);

}
