package com.chedacandalesborja.bcc0601.Services;

import com.chedacandalesborja.bcc0601.Models.Empleado;

import java.util.List;

public interface EmpleadoService {
    public Empleado añadir (Empleado empleado);

    public List<Empleado> obtenerTodos ();

    public Empleado obtenerPorId (long id);

    public Empleado editar (Empleado empleado);

    public void borrar (long id);

    public List<Empleado> findBySalarioGreaterThanEqualOrderBySalario (double salario);
    public List <Empleado> obtenerEmpleadoSalarioMayorMedia();

    List <Empleado> obtenerEmpleadosSalarioMayorMedia();
}
