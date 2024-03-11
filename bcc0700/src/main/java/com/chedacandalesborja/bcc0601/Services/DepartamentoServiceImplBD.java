package com.chedacandalesborja.bcc0601.Services;

import com.chedacandalesborja.bcc0601.Models.Departamento;
import com.chedacandalesborja.bcc0601.Repositories.DepartamentoRepository;
import com.chedacandalesborja.bcc0601.Repositories.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartamentoServiceImplBD implements DepartamentoService{

    private final DepartamentoRepository repositoryDepartamento;

    private final EmpleadoRepository repositoryEmpleados;

    public DepartamentoServiceImplBD(DepartamentoRepository repositoryDepartamento, EmpleadoRepository repositoryEmpleados) {
        this.repositoryDepartamento = repositoryDepartamento;
        this.repositoryEmpleados = repositoryEmpleados;
    }

    @Override
    public Departamento añadir(Departamento departamento) {
        return repositoryDepartamento.save(departamento);
    }

    @Override
    public List<Departamento> obtenerTodos() {
        return repositoryDepartamento.findAll();
    }

    @Override
    public Departamento obtenerPorId(long id) {
        return repositoryDepartamento.findById(id).orElse(null);
    }

    @Override
    public Departamento editar(Departamento departamento) {
        return repositoryDepartamento.save(departamento);
    }

    @Override
    public void borrar(Departamento d) {
        Long cantEmpleadosDepto = repositoryEmpleados.cantidadEmpleadosDepto(d.getId());
        if (cantEmpleadosDepto == 0) repositoryDepartamento.delete(d);
        repositoryDepartamento.delete(d);
    }

    @Override
    public Departamento obtenerPorNombre(String nombre) {
        return repositoryDepartamento.findByNombre(nombre);
    }
}
