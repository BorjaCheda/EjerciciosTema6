package com.chedacandalesborja.bcc0601.Services;

import com.chedacandalesborja.bcc0601.Models.Empleado;
import com.chedacandalesborja.bcc0601.Repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpleadoServiceImplBD implements EmpleadoService{
    @Autowired
    EmpleadoRepository repositorioEmpleados;
    @Override
    public Empleado añadir(Empleado empleado) {
        return repositorioEmpleados.save(empleado);
    }

    @Override
    public List<Empleado> obtenerTodos() {
        return repositorioEmpleados.findAll();
    }

    @Override
    public Empleado obtenerPorId(long id) {
        return repositorioEmpleados.findById(id).orElse(null);
    }

    @Override
    public Empleado editar(Empleado empleado) {
        return repositorioEmpleados.save(empleado);
    }

    @Override
    public void borrar(long id) {
        repositorioEmpleados.deleteById(id);
    }

    @Override
    public List<Empleado> findBySalarioGreaterThanEqualOrderBySalario(double salario) {
        return repositorioEmpleados.findBySalarioGreaterThanEqualOrderBySalario(salario);
    }

    @Override
    public List <Empleado> obtenerEmpleadoSalarioMayorMedia() {
        return repositorioEmpleados.obtenerEmpleadoSalarioMayorMedia();
    }

    @Override
    public List<Empleado> obtenerEmpleadosSalarioMayorMedia() {
        return null;
    }

    @Override
    public List<Empleado> obtenerEmpleadosConLetraA() {
        return repositorioEmpleados.obtenerEmpleadosConLetraA();
    }

    @Override
    public List<Empleado> findEmpleadosByDepartamentoId(long idDepartamento) {
        return repositorioEmpleados.findEmpleadosByDepartamentoId(idDepartamento);
    }

    // @Override
    //public List<Empleado> findByDepartamento(Long idDepartamento) {
     //   return null;
    //}
}
