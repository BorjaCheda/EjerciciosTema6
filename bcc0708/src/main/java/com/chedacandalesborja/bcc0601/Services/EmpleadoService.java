package com.chedacandalesborja.bcc0601.Services;

import com.chedacandalesborja.bcc0601.DTO.EmpleadoDTO;
import com.chedacandalesborja.bcc0601.Models.Empleado;

import java.util.List;

public interface EmpleadoService {

    List<Empleado> obtenerTodos();

    List<EmpleadoDTO> convertEmpleadoToDto(List<Empleado> listaEmpleados);

}
