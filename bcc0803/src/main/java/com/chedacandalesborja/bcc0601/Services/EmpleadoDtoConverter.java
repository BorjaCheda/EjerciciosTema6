package com.chedacandalesborja.bcc0601.Services;

import com.chedacandalesborja.bcc0601.DTO.EmpleadoNuevoDto;
import com.chedacandalesborja.bcc0601.Models.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmpleadoDtoConverter {
    @Autowired
    DepartamentoService departamentoService;
    public Empleado convertDtoToEmpleado(EmpleadoNuevoDto empleadoNuevoDto) {
        return new Empleado(null,
                empleadoNuevoDto.getNombre(),
                empleadoNuevoDto.getEmail(),
                empleadoNuevoDto.getSalario(),
                empleadoNuevoDto.isEnActivo(),
                empleadoNuevoDto.getGenero(),
                departamentoService.obtenerPorId(empleadoNuevoDto.getDepartamentoId()));
    }
    public Empleado convertDtoToEmpleado(EmpleadoNuevoDto empleadoEditDto, Long id) {
        Empleado empleado = convertoDtoToEmpleado(empleadoEditDto);
        empleado.setId(id);
        return empleado;
    }

    private Empleado convertoDtoToEmpleado(EmpleadoNuevoDto empleadoEditDto) {
        return null;
    }

}