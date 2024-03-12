package com.chedacandalesborja.bcc0601.Services;

import com.chedacandalesborja.bcc0601.Models.Empleado;
import com.chedacandalesborja.bcc0601.Models.EmpleadoProyecto;
import com.chedacandalesborja.bcc0601.Models.Proyecto;
import com.chedacandalesborja.bcc0601.Repositories.EmpleadoProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoProyectoServiceImplBD implements EmpleadoProyectoService {
    @Autowired
    EmpleadoProyectoRepository empleadoProyectoRepository;

    public EmpleadoProyecto obtenerPorId(Long id) {
        return empleadoProyectoRepository.findById(id).orElse(null);
    }

    public EmpleadoProyecto añadir(EmpleadoProyecto empleadoProyecto) {
        return empleadoProyectoRepository.save(empleadoProyecto);
    }

    public void borrar(EmpleadoProyecto empleadoProyecto) {
        empleadoProyectoRepository.delete(empleadoProyecto);
    }

    public List<EmpleadoProyecto> obtenerPorEmpleado(Empleado empleado) {
        return empleadoProyectoRepository.findByEmpleado(empleado);
    }

    public List<EmpleadoProyecto> obtenerPorProyecto(Proyecto proyecto) {
        return empleadoProyectoRepository.findByProyecto(proyecto);
    }

    public EmpleadoProyecto obtenerPorEmpleadoProyecto(Empleado e, Proyecto p) {
        return empleadoProyectoRepository.findByEmpleadoAndProyecto(e, p);
    }
}
