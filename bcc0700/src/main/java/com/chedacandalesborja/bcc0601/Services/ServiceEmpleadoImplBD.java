package com.chedacandalesborja.bcc0601.Services;

import com.chedacandalesborja.bcc0601.Models.Empleado;
import com.chedacandalesborja.bcc0601.Repositories.EmpleadoRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Primary
public class ServiceEmpleadoImplBD implements EmpleadoService {

    private final EmpleadoRepository repositorioBD;

    public ServiceEmpleadoImplBD(EmpleadoRepository repositorioBD) {
        this.repositorioBD = repositorioBD;
    }

    public Empleado añadir(Empleado empleado) {
        return repositorioBD.save(empleado);
    }

    public List<Empleado> obtenerTodos() {
        return repositorioBD.findAll();
    }

    public Empleado obtenerPorId(long id) {
        return repositorioBD.findById(id).orElse(null);
    }

    public Empleado editar(Empleado empleado) {
        return repositorioBD.save(empleado);
    }

    public void borrar(long id) {repositorioBD.deleteById(id);
    }

    public List<Empleado> obtenerEmpleadosSalarioMayor (double salario){
        return repositorioBD.findBySalarioGreaterThanEqualOrderBySalario(salario);
    }
    public List<Empleado> obtenerEmpleadoSalarioMayorMedia() {
        return repositorioBD.obtenerEmpleadoSalarioMayorMedia();
    }

}

