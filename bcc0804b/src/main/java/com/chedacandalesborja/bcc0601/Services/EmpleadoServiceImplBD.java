package com.chedacandalesborja.bcc0601.Services;

import com.chedacandalesborja.bcc0601.Exceptions.EmpleadoNotFoundException;
import com.chedacandalesborja.bcc0601.Exceptions.EmptyEmpleadosException;
import com.chedacandalesborja.bcc0601.Models.Empleado;
import com.chedacandalesborja.bcc0601.Repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpleadoServiceImplBD implements EmpleadoService {
    @Autowired
    EmpleadoRepository repositorioEmpleados;

    @Override
    public Empleado añadir(Empleado empleado) {
        return repositorioEmpleados.save(empleado);
    }

    @Override
    public List<Empleado> obtenerTodos() {
        List<Empleado> lista = repositorioEmpleados.findAll();
        if (lista.isEmpty()) throw new EmptyEmpleadosException();
        return lista;
    }

    @Override
    public Empleado obtenerPorId(long id) {

        return repositorioEmpleados.findById(id).orElseThrow(() -> new EmpleadoNotFoundException(id));
    }

    @Override
    public Empleado editar(Empleado empleado) {
        return repositorioEmpleados.save(empleado);
    }

    @Override
    public void borrar(long id) {
        if (repositorioEmpleados.findById(id) == null) {
            throw new EmpleadoNotFoundException(id);
        } else {
            repositorioEmpleados.deleteById(id);
        }
    }
}
