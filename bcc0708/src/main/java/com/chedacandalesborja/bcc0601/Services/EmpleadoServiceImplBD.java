package com.chedacandalesborja.bcc0601.Services;

import com.chedacandalesborja.bcc0601.DTO.EmpleadoDTO;
import com.chedacandalesborja.bcc0601.Models.Empleado;
import com.chedacandalesborja.bcc0601.Repositories.EmpleadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmpleadoServiceImplBD implements EmpleadoService{
    @Autowired
    EmpleadoRepository repositorioEmpleados;
    @Autowired
    public ModelMapper modelMapper;
    @Override
    public List<Empleado> obtenerTodos() {
        return repositorioEmpleados.findAll();
    }

    @Override
    public List<EmpleadoDTO> convertEmpleadoToDto(List<Empleado> listaEmpleados) {
        List<EmpleadoDTO> listaEmpleadoDTO = new ArrayList<>();
        for (Empleado empleado : listaEmpleados)
            listaEmpleadoDTO.add(modelMapper.map(empleado, EmpleadoDTO.class));
        return listaEmpleadoDTO;
    }
}
